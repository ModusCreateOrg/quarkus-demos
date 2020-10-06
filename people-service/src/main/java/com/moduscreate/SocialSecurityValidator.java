package com.moduscreate;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SocialSecurityValidator implements ConstraintValidator<SocialSecurity, String> {

    public static Pattern SOCIAL_SECURITY_NUM_PAT = Pattern.compile("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return SOCIAL_SECURITY_NUM_PAT.matcher(value).matches();
    }

    @Override
    public void initialize(SocialSecurity constraintAnnotation) {

    }

}
