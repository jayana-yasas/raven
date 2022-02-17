package com.oxcentra.raven.queue;

import com.oxcentra.raven.configs.Configurations;
import com.oxcentra.raven.process.SMSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class RMQConsumer {
    Logger LOGGER = LoggerFactory.getLogger(RMQConsumer.class);

    @RabbitListener(queues = Configurations.QUEUE_SMS_A)
    @SendTo("lpq.replies")
    public void RabbitListenerMobitelA(SMSTask smsTask) {
        try {
            LOGGER.info("To : {}, {}", smsTask.mobile,smsTask.content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


