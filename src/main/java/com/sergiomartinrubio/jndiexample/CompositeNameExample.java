package com.sergiomartinrubio.jndiexample;

import javax.naming.CompositeName;
import javax.naming.NamingException;

public class CompositeNameExample {

    public static void main(String[] args) throws NamingException {
        CompositeName name = new CompositeName();
        name.add("fileSystemRoot.rightChildComponent.rootComponent");
        name.add("tutorial");
        name.add("report.txt");
        System.out.println(name);
    }
}
