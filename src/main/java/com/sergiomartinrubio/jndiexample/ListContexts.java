package com.sergiomartinrubio.jndiexample;

import javax.naming.*;
import java.util.Properties;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;

public class ListContexts {

    public static void main(String[] args) throws NamingException {
        Properties properties = new Properties();
        properties.setProperty(INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        properties.setProperty(PROVIDER_URL, "file:/Users/sergio/workspace/jndi-example");
        Context jndi = new InitialContext(properties);

        jndi.rebind("my-service", new MyService("Test", "OK", true));

        NamingEnumeration<NameClassPair> contextData = jndi.list("");

        // this will return everything in the classpath, including my-service class
        while (contextData.hasMoreElements()) {
            NameClassPair nameClassPair = contextData.nextElement();
            System.out.println("Name: " + nameClassPair.getName() + " -> Class Name: " + nameClassPair.getClassName());
        }

    }
}
