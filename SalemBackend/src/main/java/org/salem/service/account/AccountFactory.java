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
    private final ERole eRoleSubscriber = ERole.ROLE_SUBSCRIBER;
    private final ERole eRoleModerator = ERole.ROLE_MODERATOR;
    private final ERole eRoleAdmistrator = ERole.ROLE_ADMINISTRATOR;

    private final Role roleVolunteer = new Role(eRoleSubscriber);
    private final Role roleModerator = new Role(eRoleModerator);

    public AccountFactory() {

    }

    public Account create(final String firstName, final String lastName, final String password, final String email,
            final String telephoneNumber, final String role) throws InvalidAccountTypeException {
        final Set<Role> setRoles = new HashSet<>();
        if (role.equals(eRoleSubscriber.toString())) {
            setRoles.add(roleVolunteer);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else if (role.equals(eRoleModerator.toString())) {
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else if (role.equals(eRoleAdmistrator.toString())) {
            final Role roleAdmistrator = new Role(eRoleAdmistrator);
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            setRoles.add(roleAdmistrator);
            return new Account(firstName, lastName, password, email, telephoneNumber, setRoles);
        } else {
            throw new InvalidAccountTypeException(role);
        }

    }

}