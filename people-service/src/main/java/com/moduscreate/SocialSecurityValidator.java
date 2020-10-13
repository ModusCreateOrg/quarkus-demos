package com.moduscreate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class SocialSecurityValidator implements ConstraintValidator<SocialSecurity, Person> {

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        final var validatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
        validatorContext.addExpressionVariable("socialSecurity", value.socialSecurity);
        validatorContext.addExpressionVariable("issuedState", value.issuedState);
        return value.issuedState.checkPrefixOnRange(Integer.parseInt(value.socialSecurity.substring(0, 2)));
    }

}
