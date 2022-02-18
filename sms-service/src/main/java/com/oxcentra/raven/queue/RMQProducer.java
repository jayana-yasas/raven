package com.oxcentra.raven.queue;


import com.oxcentra.raven.configs.Configurations;
import com.oxcentra.raven.entity.SmsSent;
import com.oxcentra.raven.process.SMSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RMQProducer {
	Logger LOGGER = LoggerFactory.getLogger(RMQProducer.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.routingkey}")
	private String routingKey;

	public void ConvertAndSendToSmsApplication(SmsSent smsSent) {
		try {
			String exchange = Configurations.EXCHANGE_SMS_REPLY;
			MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
				@Override
				public Message postProcessMessage(Message message) throws AmqpException {
					message.getMessageProperties().setPriority(10);
					return message;
				}
			};
			rabbitTemplate.convertAndSend(exchange, routingKey, smsSent, messagePostProcessor);
			LOGGER.info("SMS-Reply RMQProducer {} ",smsSent);
		} catch (Exception e) {
			LOGGER.info("Exception {}", e);
		}
	}


}