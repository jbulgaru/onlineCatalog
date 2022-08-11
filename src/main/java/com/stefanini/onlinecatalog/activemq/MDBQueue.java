
package com.stefanini.onlinecatalog.activemq;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;

import javax.jms.JMSException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MDBQueue {

    private static final String DEFAULT_MESSAGE = "HELLO";
    private static final String DEFAULT_CONNECTION_FACTORY = "ConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:/jms/queue/iosif";
    private static final String DEFAULT_MESSAGE_COUNT = "2";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin123";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    //private static final String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
    private static final String PROVIDER_URL = "http-remoting://localhost:8080";
    static  Context namingContext = null;




public void doLookup() throws NamingException, IOException {
    String username = System.getProperty("username", DEFAULT_USERNAME);
    String password = System.getProperty("password", DEFAULT_PASSWORD);
    try{
        System.out.println("\n\n\nsendMessage start\n\n");


        final Properties env = new Properties();
        System.out.println("\n\n\nfactory end\n\n");
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        System.out.println("\n\n\nfactory end\n\n");
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        this.namingContext = new InitialContext(env);
        System.out.println("\n\n\nsendMessage end\n\n");
    }catch (Exception e){
        e.printStackTrace();
    }
    // Perform the JNDI lookups
    System.out.println("\n\n\ndoLookup start\n\n");
    if(this.namingContext == null){
        System.out.println("\n\n\nContext is NULL!!\n\n\n");
    }
    String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
    String s = "Attempting to acquire connection factory" + connectionFactoryString;
    log.write(s.getBytes());
    System.out.println("\n\n\nconnectionFactoryString:"+connectionFactoryString+"\n\n\n");
    //ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup(connectionFactoryString);
    ConnectionFactory connectionFactory = (ConnectionFactory) this.namingContext.lookup(connectionFactoryString);
    ConnectionFactory connectionFactory1 = (ConnectionFactory) namingContext.lookup("jms/RemoteConnectionFactory");
    System.out.println("\n\n\nconnectionFactory\n\n\n");
    String mes = "Found connection factory \"" + connectionFactoryString + "\" in JNDI";
    log.write(mes.getBytes());
    System.out.println("\n\n\nJNDI\n\n\n");
    String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
    System.out.println("\n\n\ndestinationStringStart\n\n\n");
    String mess2 = "Attempting to acquire destination \"" + destinationString + "\"";
    log.write(mess2.getBytes());
    Destination destination1 = (Destination) namingContext.lookup("jms/queue/iosif");
    System.out.println("\n\n\ndestination___GOOOOOOD\n\n\n");
    Destination destination = (Destination) namingContext.lookup(destinationString);
    System.out.println("\n\n\ndestinationEnd\n\n\n");
    String mess3 = "Found destination \"" + destinationString + "\" in JNDI";
    log.write(mess3.getBytes());

    int count = Integer.parseInt(System.getProperty("message.count", DEFAULT_MESSAGE_COUNT));
    String content = System.getProperty("message.content", DEFAULT_MESSAGE);

    try {
            JMSContext context = (JMSContext) connectionFactory.createConnection(username, password);
        String mess4 = "Sending " + count + " messages with content: " + content;
        log.write(mess4.getBytes());
        // Send the specified number of messages
        for (int i = 0; i < count; i++) {
            context.createProducer().send(destination, content);
        }

        // Create the JMS consumer
        JMSConsumer consumer = context.createConsumer(destination);
        // Then receive the same number of messages that were sent
        for (int i = 0; i < count; i++) {
            String text = consumer.receiveBody(String.class, 5000);
            String mess5 = "Received message with content " + text;
            log.write(mess5.getBytes());
        }
    } catch (JMSException ex) {
        throw new RuntimeException(ex);
    } finally {
        if (namingContext != null) {
            try {
                namingContext.close();
            } catch (NamingException e) {
                log.write(e.getMessage().getBytes());
            }
        }
    }
}



}
/*
<connection-factory name="RemoteConnectionFactory" entries="java:jboss/exported/jms/RemoteConnectionFactory"
        connectors="http-connector" ha="true" block-on-acknowledge="true" reconnect-attempts="-1"/>*/
