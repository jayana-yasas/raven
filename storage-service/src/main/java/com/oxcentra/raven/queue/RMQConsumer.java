package com.oxcentra.raven.queue;

import com.oxcentra.raven.configs.Configurations;
import com.oxcentra.raven.entity.SmsSent;
import com.oxcentra.raven.process.SMSTask;
import com.oxcentra.raven.repository.SmsSentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RMQConsumer {
    Logger LOGGER = LoggerFactory.getLogger(RMQConsumer.class);

    @Autowired
    RMQProducer rabbitMQSender;
    @Autowired
    SmsSentRepository smsSentRepository;

    @RabbitListener(queues = Configurations.QUEUE_SMS_REPLY)
    public void RabbitListenerSmsReply(SmsSent smsSentResponse) {
        try {
            LOGGER.info("SMS-Reply RMQConsumer {} ",smsSentResponse);
            Optional<SmsSent> smsSent = smsSentRepository.findByUuid(smsSentResponse.getUuid());
            smsSent.get().setStatus(smsSentResponse.getStatus());
            smsSentRepository.save(smsSent.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


