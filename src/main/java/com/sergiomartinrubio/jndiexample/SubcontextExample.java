package com.sergiomartinrubio.jndiexample;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;

public class SubcontextExample {

    public static void main(String[] args) throws NamingException {
        Properties properties = new Properties();
        properties.setProperty(INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        properties.setProperty(PROVIDER_URL, "file:/Users/sergio/workspace/jndi-example");
        Context jndi = new InitialContext(properties);

        jndi.rebind("my-service", new MyService("Test", "OK", true));

        // this will create a folder name "subcontext_folder"
        jndi.createSubcontext("subcontext_folder");

        // this will delete the folder "subcontext_folder"
        jndi.destroySubcontext("subcontext_folder");
    }
}
