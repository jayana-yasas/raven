package com.oxcentra.raven.process;

import com.oxcentra.raven.entity.Contacts;
import com.oxcentra.raven.entity.SmsCampaign;
import com.oxcentra.raven.entity.SmsSent;
import com.oxcentra.raven.queue.RMQProducer;
import com.oxcentra.raven.repository.ContactsRepository;
import com.oxcentra.raven.repository.SmsCampaignRepository;
import com.oxcentra.raven.repository.SmsSentRepository;
import com.oxcentra.raven.util.BasicUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;


@Service
public class SMSCampaignEvent implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSCampaignEvent.class);

    @Autowired
    SmsCampaignRepository smsCampaignRepository;
    @Autowired
    ContactsRepository contactsRepository;
    @Autowired
    SmsSentRepository smsSentRepository;
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
                    HashMap<String,String> hashMap = new HashMap<String,String>();
                    String[] tags = smsCampaign.getTags().split(",");
                    LOGGER.info("SmsCampaign {} Started. It has {} number of tags",smsCampaign.getCampaignName(),(tags.length+1));
                    SMSTask smsTask = null;

                    for (int i =0; i< tags.length; i++) {
                        for (Contacts contacts: contactsRepository.findByTagsLike(tags[i])) {
                            hashMap.put(contacts.getMobile(),BasicUtilities.generateContentbyTemplate_(contacts,smsCampaign));
                        }

                        for (Map.Entry<String,String> entry : hashMap.entrySet()) {
                            UUID uuid = UUID.randomUUID();
                            SmsSent smsSent = new SmsSent();
                            smsSent.setUuid(uuid.toString().replace("-",""));
                            smsSent.setStatus("SENT");
                            smsSent.setMobile(entry.getKey());
                            smsSent.setContent(entry.getValue());
                            smsSent.setCreatedtime(new Timestamp(System.currentTimeMillis()));

                            smsSentRepository.save(smsSent);
                            smsTask = new SMSTask(entry.getKey(), entry.getValue(),smsSent.getUuid(), smsCampaign);
                            rabbitMQSender.ConvertAndSendToSmsApplication(smsTask);
                            BasicUtilities.sleep(5);
                        }

                    }

                    smsCampaign.setStatus("Done");
                    smsCampaignRepository.save(smsCampaign);
                    LOGGER.info("SmsCampaign {} Finished.",smsCampaign.getCampaignName());

                }
                BasicUtilities.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
