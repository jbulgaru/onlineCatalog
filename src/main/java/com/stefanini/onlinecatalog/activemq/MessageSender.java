package com.stefanini.onlinecatalog.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import javax.xml.bind.JAXBException;

public class MessageSender {
    private  String queueName;
    private  ConnectionFactory connectionFactory;
    private Connection connection;
    private Session connectionSession;
    private Destination destination;
    private MessageProducer producer;
    private TextMessage myMessage;

    public MessageSender(String queueName) throws JMSException {

        this.queueName = queueName;
        this.connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        this.connection = this.connectionFactory.createConnection();
        this.connectionSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        this.destination = connectionSession.createQueue(this.queueName);
        this.producer = connectionSession.createProducer(this.destination);
        this.myMessage = connectionSession.createTextMessage("default message ");
    }

    public MessageSender(String queueName, ConnectionFactory connectionFactory,
                         Connection connection, Session connectionSession,
                         Destination destination, MessageProducer producer,
                         TextMessage myMessage) {
        this.queueName = queueName;
        this.connectionFactory = connectionFactory;
        this.connection = connection;
        this.connectionSession = connectionSession;
        this.destination = destination;
        this.producer = producer;
        this.myMessage = myMessage;
    }

    public MessageSender() throws JMSException, JAXBException {
        this.queueName = "grantHolders";
        this.connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        this.connection = this.connectionFactory.createConnection();
        this.connectionSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        this.destination = connectionSession.createQueue(this.queueName);
        this.producer = connectionSession.createProducer(this.destination);
        this.myMessage = connectionSession.createTextMessage("default message ");
    }
    public MessageSender(String queueName, String strXML) throws JMSException {
        this.queueName = queueName;
        this.connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        this.connection = this.connectionFactory.createConnection();
        this.connectionSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        this.destination = connectionSession.createQueue(this.queueName);
        this.producer = connectionSession.createProducer(this.destination);
        this.myMessage = connectionSession.createTextMessage(strXML);
    }


    public  void start() throws JMSException {
        this.connection.start();
    }
    public  void close() throws JMSException {
        this.connection.close();
    }
    public  void send() throws JMSException {
        this.producer.send(this.myMessage);
    }

}