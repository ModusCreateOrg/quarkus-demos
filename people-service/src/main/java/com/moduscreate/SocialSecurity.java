package com.moduscreate;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { SocialSecurityValidator.class })
public @interface SocialSecurity {

    String message() default "{value} is a invalid social security number";
    Class[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
