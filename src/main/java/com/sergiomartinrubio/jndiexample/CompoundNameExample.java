package com.sergiomartinrubio.jndiexample;

import javax.naming.CompoundName;
import javax.naming.NamingException;
import java.util.Enumeration;
import java.util.Properties;

public class CompoundNameExample {

    public static void main(String[] args) throws NamingException {
        Properties properties = new Properties();
        properties.put("jndi.syntax.direction", "right_to_left");
        properties.put("jndi.syntax.separator", ".");
        CompoundName compoundName = new CompoundName("fileSystemRoot.rightChildComponent.rootComponent", properties);
        Enumeration<String> components = compoundName.getAll();

        while (components.hasMoreElements()) {
            System.out.println(components.nextElement());
        }

    }
}
