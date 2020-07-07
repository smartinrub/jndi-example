package com.sergiomartinrubio.jndiexample;

import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;

public class BindAndLookupExample {

    public static void main(String[] args) throws NamingException {
        Properties properties = new Properties();
        properties.setProperty(INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        properties.setProperty(PROVIDER_URL, "file:/Users/sergio/workspace/jndi-example");
        Context jndi = new InitialContext(properties);

        // if the class is already bind with the same name
        // it will throw an exception
//        jndi.bind("my-service", myService);

        jndi.rebind("my-service", new MyService("Test", "OK", true));

//        jndi.unbind("my-service");

        MyService myServiceFromJNDI = (MyService) jndi.lookup("my-service");

        System.out.println(myServiceFromJNDI);
    }

}
