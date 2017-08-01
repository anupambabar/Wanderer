package com.wanderer.core.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.wanderer.utility.constants.AppConstants;

/**
 * 
 * @author anupam.babar
 * 
 */

@SuppressWarnings("rawtypes")
@Component
public class JMSMessageReceiver implements SessionAwareMessageListener {

	@Autowired
	JMSRequestProcessor requestProcessor;

	public void onMessage(Message message, Session session) throws JMSException {

		TextMessage text = (TextMessage) message;
		if (text != null && !AppConstants.JMS_RESPONSE_IDENTIFIER_VALUE.equals(text.getStringProperty(AppConstants.JMS_RESPONSE_IDENTIFIER_KEY))) {
			requestProcessor.processRequest(text.getText(), text.getStringProperty(AppConstants.JMS_REQUEST_KEY_RRN),
					text.getStringProperty(AppConstants.JMS_REQUEST_KEY_REQUESTKEY));
		}
	}
}
