package org.salem.controller.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.salem.domain.account.ERole;

public class RoleValidator implements ConstraintValidator<RolePreference, String> {

    private ERole eRoleSubscriber = ERole.ROLE_SUBSCRIBER;
    private ERole eRoleModerator = ERole.ROLE_MODERATOR;
    private ERole eRoleAdmistrator = ERole.ROLE_ADMINISTRATOR;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.equals(eRoleAdmistrator.toString()) || value.equals(eRoleModerator.toString())
                || value.equals(eRoleSubscriber.toString()));
    }

}