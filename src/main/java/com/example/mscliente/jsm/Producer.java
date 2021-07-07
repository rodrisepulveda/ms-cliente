package com.example.mscliente.jsm;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendObjectMessage(final String nombreCola, final Serializable objectMessage) {

		jmsTemplate.send(nombreCola, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				ObjectMessage message = session.createObjectMessage(objectMessage);

				return message;

			}

		});

	}

}