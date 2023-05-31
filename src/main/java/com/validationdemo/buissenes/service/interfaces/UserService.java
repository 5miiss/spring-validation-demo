package com.validationdemo.buissenes.service.interfaces;

import com.validationdemo.buissenes.dto.request.UserDto;
import com.validationdemo.buissenes.dto.response.ResponseDto;
import com.validationdemo.buissenes.dto.response.UserRespDto;

import java.util.List;

public interface UserService {
    ResponseDto getUserByRef(String refNo);
    ResponseDto getUsers();
    ResponseDto addUser(UserDto userDto);
    ResponseDto updateUser(String refNo, UserDto userDto);
    ResponseDto deleteUser(String refNo);
}
