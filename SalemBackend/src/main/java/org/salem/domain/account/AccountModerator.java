package org.salem.domain.account;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("moderator")
public class AccountModerator extends Account {

    private static final long serialVersionUID = 1L;

    public AccountModerator() {
        super();
    }

    public AccountModerator(Name name, String password, String email, String phoneNumber, Set<Role> roles) {
        super(name, password, email, phoneNumber, roles);
    }
}