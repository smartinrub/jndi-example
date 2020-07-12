package com.sergiomartinrubio.jndiexample;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingException;
import java.util.Enumeration;

public class MyNameParserExample {

    public static void main(String[] args) throws NamingException {
        Context jndi = new MyContext();
        NameParser nameParser = jndi.getNameParser("");

        Name name = nameParser.parse("hello.world:.txt");

        Enumeration<String> components = name.getAll();
        while (components.hasMoreElements()) {
            System.out.println(components.nextElement());
        }
    }
}
