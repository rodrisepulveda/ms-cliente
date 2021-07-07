package com.example.mscliente.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@ComponentScan(basePackages = "eficacia.atthegoal.jms")
public class JmsConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		connectionFactory.setBrokerURL("tcp://localhost:61616");

		connectionFactory.setPassword("admin");

		connectionFactory.setUserName("admin");

		Properties properties = new Properties();

		properties.put("trustAllPackages", true);

		connectionFactory.setProperties(properties);

		// https://activemq.apache.org/objectmessage

		return connectionFactory;

	}

	@Bean
	public JmsTemplate jmsTemplate() throws IOException {

		JmsTemplate template = new JmsTemplate();

		template.setConnectionFactory(connectionFactory());

		return template;

	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws IOException {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		factory.setConnectionFactory(connectionFactory());

		factory.setConcurrency("1-1");

		return factory;

	}

}
