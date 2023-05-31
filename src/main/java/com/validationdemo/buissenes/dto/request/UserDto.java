package com.validationdemo.buissenes.dto.request;

import com.validationdemo.utils.validators.annotations.EmailValidator;
import com.validationdemo.utils.validators.annotations.UserNameValidator;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    @UserNameValidator
    private String userName;
    private String password;
    @EmailValidator
    private String email;
    @Valid
    private List<RoleDto> roles;
}
