package com.validationdemo.utils.validators.annotations;

import com.validationdemo.utils.validators.classes.UniqueUserNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.aspectj.bridge.IMessage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidator.class)
public @interface UserNameValidator {
    public String message () default "user name must be unique";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};

}
