package com.sergiomartinrubio.jndiexample;

import javax.naming.*;
import java.util.Enumeration;
import java.util.Properties;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;

public class NameParserExample {

    public static void main(String[] args) throws NamingException {
        Properties properties = new Properties();
        properties.setProperty(INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        properties.setProperty(PROVIDER_URL, "file:/Users/sergio/workspace/jndi-example");
        Context jndi = new InitialContext(properties);

        // you can retrieve the File System Name parser by
        // passing an empty string
        NameParser nameParser = jndi.getNameParser("");
        Name name = nameParser.parse("tutorial/report.txt");

        Enumeration<String> components = name.getAll();
        while (components.hasMoreElements()) {
            System.out.println(components.nextElement());
        }

    }
}
