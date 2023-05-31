package com.validationdemo.utils.validators.classes;

import com.validationdemo.persistence.repository.UserRepo;
import com.validationdemo.utils.validators.annotations.EmailValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<EmailValidator,String> {
    private final UserRepo userRepo;
    @Override
    public void initialize(EmailValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && !userRepo.existsByEmailAndDeletedFalse(s);
    }
}
