package com.oxcentra.raven.process;

import com.oxcentra.raven.entity.Contacts;
import com.oxcentra.raven.entity.SmsCampaign;
import com.oxcentra.raven.queue.RMQProducer;
import com.oxcentra.raven.repository.ContactsRepository;
import com.oxcentra.raven.repository.SmsCampaignRepository;
import com.oxcentra.raven.util.BasicUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SMSCampaignEvent implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSCampaignEvent.class);

    @Autowired
    SmsCampaignRepository smsCampaignRepository;
    @Autowired
    ContactsRepository contactsRepository;
    @Autowired
    RMQProducer rabbitMQSender;
    @Override
    public void run() {
        try {
            while (true){
                SmsCampaign smsCampaign = smsCampaignRepository.findFirstByStatus("Queued");
                if(smsCampaign != null) {
                    smsCampaign.setStatus("InProgress");
                    smsCampaignRepository.save(smsCampaign);
                    LOGGER.info("SmsCampaign {}",smsCampaign.toString());
                    HashMap<String,String> hashMap = new HashMap<String,String>();
                    String[] tags = smsCampaign.getTags().split(",");
                    LOGGER.info("tags {}",tags.length);
                    SMSTask smsTask = null;

                    for (int i =0; i< tags.length; i++) {
                        System.out.println(">"+tags[i]+"<");
                        for (Contacts contacts: contactsRepository.findByTagsLike(tags[i])) {
                            hashMap.put(contacts.getMobile(),BasicUtilities.generateContentbyTemplate_(contacts,smsCampaign));
                            LOGGER.info("Contacts {}",contacts.toString());
                        }
                        for (Map.Entry<String,String> entry : hashMap.entrySet()) {
                            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                            smsTask = new SMSTask(entry.getKey(), entry.getValue(), smsCampaign);
                            rabbitMQSender.ConvertAndSendToSmsApplication(smsTask);
                            BasicUtilities.sleep(10);
                        }
                    }
                }

                BasicUtilities.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
