package org.salem.domain.account;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrator")
public class AccountAdministrator extends Account {

    private static final long serialVersionUID = 1L;

    public AccountAdministrator() {
        super();
    }

    public AccountAdministrator(Name name, String password, String email, String phoneNumber, Set<Role> roles) {
        super(name, password, email, phoneNumber, roles);
    }

}