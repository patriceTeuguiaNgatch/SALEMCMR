package org.salem.service.account;

import java.util.HashSet;
import java.util.Set;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountAdministrator;
import org.salem.domain.account.AccountModerator;
import org.salem.domain.account.AccountSubscriber;
import org.salem.domain.account.ERole;
import org.salem.domain.account.Name;
import org.salem.domain.account.Role;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.service.assemler.NameAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory {

    @Autowired
    private NameAssembler nameAssembler;

    private ERole eRoleSubscriber = ERole.ROLE_SUBSCRIBER;
    private ERole eRoleModerator = ERole.ROLE_MODERATOR;
    private ERole eRoleAdmistrator = ERole.ROLE_ADMINISTRATOR;

    public AccountFactory(NameAssembler nameAssembler) {
        this.nameAssembler = nameAssembler;

    }

    public Account create(AccountRequestDto accountRequestDto) throws InvalidAccountTypeException {

        Role roleVolunteer = new Role(eRoleSubscriber);
        Role roleModerator = new Role(eRoleModerator);

        Set<Role> setRoles = new HashSet<>();
        String role = accountRequestDto.getRole();

        String firstName = accountRequestDto.getFirstName();
        String lastName = accountRequestDto.getLastName();
        String password = accountRequestDto.getPassword();
        String email = accountRequestDto.getEmail();
        String phoneNumber = accountRequestDto.getPhoneNumber();

        Name name = this.nameAssembler.createName(firstName, lastName);

        if (role.equals(eRoleSubscriber.toString())) {
            setRoles.add(roleVolunteer);
            return new AccountSubscriber(name, password, email, phoneNumber, setRoles);
        } else if (role.equals(eRoleModerator.toString())) {
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            return new AccountModerator(name, password, email, phoneNumber, setRoles);
        } else if (role.equals(eRoleAdmistrator.toString())) {
            Role roleAdmistrator = new Role(eRoleAdmistrator);
            setRoles.add(roleVolunteer);
            setRoles.add(roleModerator);
            setRoles.add(roleAdmistrator);
            return new AccountAdministrator(name, password, email, phoneNumber, setRoles);
        } else {
            throw new InvalidAccountTypeException(role);
        }

    }

}