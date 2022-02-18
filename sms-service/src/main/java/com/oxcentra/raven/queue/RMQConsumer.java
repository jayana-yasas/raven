package com.oxcentra.raven.queue;

import com.oxcentra.raven.configs.Configurations;
import com.oxcentra.raven.entity.SmsSent;
import com.oxcentra.raven.process.SMSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RMQConsumer.class);
    @Autowired
    RMQProducer rabbitMQSender;

    @RabbitListener(queues = Configurations.QUEUE_SMS_A)
    public void RabbitListenerMobitelA(SMSTask smsTask) {
        try {
            LOGGER.info("To : {}, {}", smsTask.mobile, smsTask.content);

            SmsSent smsSent = new SmsSent();
            smsSent.setStatus("COMPLETED");
            smsSent.setUuid(smsTask.getUuid());
            rabbitMQSender.ConvertAndSendToSmsApplication(smsSent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


