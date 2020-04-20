package org.salem.service.account;

import java.util.HashSet;
import java.util.Set;

import org.salem.domain.account.Account;
import org.salem.domain.account.ERole;
import org.salem.domain.account.Role;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory {
    private ERole eRoleSubscriber = ERole.ROLE_SUBSCRIBER;
    private ERole eRoleModerator = ERole.ROLE_MODERATOR;
    private ERole eRoleAdmistrator = ERole.ROLE_ADMINISTRATOR;

    public AccountFactory() {

    }

    public Account create(String firstName, String lastName, String password, String email, String telephoneNumber,
            String role) throws InvalidAccountTypeException {
        Role roleVolunteer = new Role(eRoleSubscriber);
        Role roleModerator = new Role(eRoleModerator);
        Set<Role> setRoles = new HashSet<>();
        if (role.equals(eRoleSubscriber.toString())) {
            setRoles.add(roleVolunteer);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else if (role.equals(eRoleModerator.toString())) {
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else if (role.equals(eRoleAdmistrator.toString())) {
            Role roleAdmistrator = new Role(eRoleAdmistrator);
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            setRoles.add(roleAdmistrator);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else {
            throw new InvalidAccountTypeException(role);
        }

    }

}