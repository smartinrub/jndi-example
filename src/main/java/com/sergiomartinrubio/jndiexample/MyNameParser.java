package com.sergiomartinrubio.jndiexample;

import javax.naming.CompoundName;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingException;
import java.util.Properties;

public class MyNameParser implements NameParser {

    private static final Properties properties = new Properties();

    static {
        properties.put("jndi.syntax.direction", "right_to_left");
        properties.put("jndi.syntax.separator", ".");
        properties.put("jndi.syntax.ignorecase", "false");
        properties.put("jndi.syntax.escape", ":");
    }

    @Override
    public Name parse(String name) throws NamingException {
        return new CompoundName(name, properties);
    }
}
