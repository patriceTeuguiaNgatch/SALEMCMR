package org.salem.domain.account;

import java.util.Set;

public class AccountAdministrator extends Account {

    public AccountAdministrator(String firstName, String lastName, String password, String email,
            String telephoneNumber, Set<Role> roles) {
        super(firstName, lastName, password, email, telephoneNumber, roles);
    }

}