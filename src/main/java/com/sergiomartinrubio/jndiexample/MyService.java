package com.sergiomartinrubio.jndiexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyService implements Referenceable {

    public static final String NAME = "name";
    public static final String STATUS = "status";
    public static final String IS_ACTIVE = "isActive";

    private String name;
    private String status;
    private boolean isActive;

    @Override
    public Reference getReference() {
        // factoryLocation is null because the factory class is in the project classpath
        Reference reference = new Reference(MyService.class.getName(), MyServiceFactory.class.getName(), null);

        reference.add(new StringRefAddr(NAME, this.name));
        reference.add(new StringRefAddr(STATUS, this.status));
        reference.add(new StringRefAddr(IS_ACTIVE, Boolean.toString(this.isActive)));

        return reference;
    }
}
