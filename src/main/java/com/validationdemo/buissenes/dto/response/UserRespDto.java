package com.validationdemo.buissenes.dto.response;

import com.validationdemo.buissenes.dto.request.RoleDto;
import com.validationdemo.utils.validators.annotations.EmailValidator;
import com.validationdemo.utils.validators.annotations.UserNameValidator;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;
@Data

public class UserRespDto {
    private String userName;
    private String password;
    private String email;
    private List<RoleDto> roles;
    private String refNo;
}
