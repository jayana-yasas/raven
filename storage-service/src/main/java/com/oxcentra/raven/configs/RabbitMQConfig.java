package com.oxcentra.raven.configs;


import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.username}")
	String username;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${rabbitmq.routingkey}")
	private String routingKey;

	@Bean
	Queue queue_sms_tier_a() {
		Map<String, Object> args = new HashMap<String, Object>(); 
		return new Queue(Configurations.QUEUE_SMS_A, true,false,false,args);
	}
	@Bean
	Queue queue_sms_tier_b() {
		Map<String, Object> args = new HashMap<String, Object>();
		return new Queue(Configurations.QUEUE_SMS_B, true,false,false,args);
	}
	@Bean
	Queue queue_sms_reply() {
		Map<String, Object> args = new HashMap<String, Object>();
		return new Queue(Configurations.QUEUE_SMS_REPLY, true,false,false,args);
	}

	@Bean
	DirectExchange exchange_sms_tier_a() {
		return new DirectExchange(Configurations.EXCHANGE_SMS_A);
	}
	@Bean
	DirectExchange exchange_sms_tier_b() {
		return new DirectExchange(Configurations.EXCHANGE_SMS_B);
	}
	@Bean
	DirectExchange exchange_sms_reply() {
		return new DirectExchange(Configurations.EXCHANGE_SMS_REPLY);
	}

	@Bean
	public Binding binding_sms_tier_a() {
	    return BindingBuilder.bind(queue_sms_tier_a()).to(exchange_sms_tier_a()).with(routingKey);
	}
	@Bean
	public Binding binding_sms_tier_b() {
		return BindingBuilder.bind(queue_sms_tier_b()).to(exchange_sms_tier_b()).with(routingKey);
	}
	@Bean
	public Binding binding_sms_reply() {
		return BindingBuilder.bind(queue_sms_reply()).to(exchange_sms_reply()).with(routingKey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) { 
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
//		rabbitTemplate.setReplyAddress("psq.reply");
		rabbitTemplate.setReplyTimeout(60000);
		return rabbitTemplate;
    }
	
//	@Bean
//	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
//		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
//		simpleMessageListenerContainer.setQueues(queue1(),queue2(),queue3());
//		simpleMessageListenerContainer.setMessageListener(new RabbitMQVoidListner());
//		return simpleMessageListenerContainer;
//
//	}
	
	
	
	
		
}
