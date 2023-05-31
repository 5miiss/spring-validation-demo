package com.validationdemo.utils.validators.classes;

import com.validationdemo.persistence.repository.UserRepo;
import com.validationdemo.utils.validators.annotations.UserNameValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UserNameValidator,String> {
    private final UserRepo userRepo;
    @Override
    public void initialize(UserNameValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && !userRepo.existsByUserNameAndDeletedFalse(s);
    }
}
