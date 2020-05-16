package org.salem.domain.account;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("subscriber")
public class AccountSubscriber extends Account {

    private static final long serialVersionUID = 1L;

    public AccountSubscriber() {
        super();
    }

    public AccountSubscriber(final Name name, final String password, final String email, final String phoneNumber,
            final Set<Role> roles) {
        super(name, password, email, phoneNumber, roles);
    }

}