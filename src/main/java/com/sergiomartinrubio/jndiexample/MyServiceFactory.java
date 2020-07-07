package com.sergiomartinrubio.jndiexample;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Enumeration;
import java.util.Hashtable;

public class MyServiceFactory implements ObjectFactory {

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        if (!(obj instanceof Reference)) {
            return null;
        }

        Reference reference = (Reference) obj;
        if (!MyService.class.getName().equals(((Reference) obj).getClassName())) {
            return null;
        }

        MyService myService = new MyService();
        Enumeration<RefAddr> addresses = reference.getAll();

        while (addresses.hasMoreElements()) {
            RefAddr address = addresses.nextElement();
            switch (address.getType()) {
                case MyService.NAME:
                    myService.setName((String) address.getContent());
                    break;
                case MyService.STATUS:
                    myService.setStatus((String) address.getContent());
                    break;
                case MyService.IS_ACTIVE:
                    myService.setActive(Boolean.parseBoolean((String) address.getContent()));
                    break;
            }
        }

        return myService;
    }
}
