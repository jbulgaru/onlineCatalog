package com.stefanini.onlinecatalog.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
@LocalBean
public class Producer {
    @Resource(name = "RemoteConnectionFactory")
    public ConnectionFactory connectionFactory ;

    @Resource(name = "jms/queue/iosif")
    public Destination destination;

@Schedule(hour = "*", minute = "*",second = "*/5", persistent = false)
    public void produceMessage() {
        try {

            System.out.println("\n\n\n++++++++++++++++++++++ERROR+++++++++++++++++++++++\n\n\n");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage("Hello MDB");
            messageProducer.send(textMessage);
            System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
            connection.close();
            session.close();
        } catch (JMSException e) {
            System.out.println("Exception Producer");
            e.printStackTrace();
        }
    }
}
