package com.wanderer.core.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.wanderer.core.entity.TransactionLogEntity;
import com.wanderer.core.queue.TransactionQueue;
import com.wanderer.utility.constants.AppConstants;
import com.wanderer.utility.utils.PropertyReaderUtil;

/**
 * 
 * @author anupam.babar
 * 
 */

@Component
public class JMSMessageSender {

	private static final Logger logger = LoggerFactory.getLogger(JMSMessageSender.class);

	@Autowired
	private JmsTemplate requestJmsTemplate;

	@Autowired
	private JmsTemplate responseJmsTemplate;

	/**
	 * @param message
	 * @param destinationString
	 * @param rrn
	 * @param delegateLogEntity
	 */
	public void sendMessage(final String message, String destinationString, final String rrn, final String requestKey,
			TransactionLogEntity delegateLogEntity) {

		if (destinationString.equals(PropertyReaderUtil.getInstance().getValue(AppConstants.JMS_DEFAULT_REQUEST_DESTINATION))) {

			delegateLogEntity.setRequest(message);
			delegateLogEntity.setStage(AppConstants.REQUEST_STAGE_MIDDLEWARE_JMSSENDER);

			requestJmsTemplate.send(new MessageCreator() {

				@Override
				public Message createMessage(Session session) throws JMSException {

					TextMessage txtMsg = session.createTextMessage(message);
					txtMsg.setStringProperty(AppConstants.JMS_REQUEST_KEY_RRN, rrn);
					txtMsg.setStringProperty(AppConstants.JMS_REQUEST_KEY_REQUESTKEY, requestKey);
					return txtMsg;
				}
			});

			logger.debug("Request sent to Queue. RRN : " + rrn);
		} else {

			delegateLogEntity.setResponse(message);
			delegateLogEntity.setStage(AppConstants.RESPONSE_STAGE_MIDDLEWARE_JMSSENDER);

			responseJmsTemplate.send(new MessageCreator() {

				@Override
				public Message createMessage(Session session) throws JMSException {

					TextMessage textMsg = session.createTextMessage(message);
					textMsg.setStringProperty(AppConstants.JMS_REQUEST_KEY_RRN, rrn);
					textMsg.setStringProperty(AppConstants.JMS_REQUEST_KEY_REQUESTKEY, requestKey);
					textMsg.setStringProperty(AppConstants.JMS_RESPONSE_IDENTIFIER_KEY, AppConstants.JMS_RESPONSE_IDENTIFIER_VALUE);
					return textMsg;
				}
			});

			logger.debug("Response sent to Queue for RRN : " + rrn);
		}

		logRequest(delegateLogEntity);
	}

	private void logRequest(TransactionLogEntity transactionLogEntity) {
		TransactionQueue.getInstance().addTransaction(transactionLogEntity);
	}
}
