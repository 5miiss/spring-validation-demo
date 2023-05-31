package com.validationdemo.buissenes.mapper;

import com.validationdemo.buissenes.dto.request.UserDto;
import com.validationdemo.buissenes.dto.response.UserRespDto;
import com.validationdemo.persistence.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    User userDtoToUser(UserDto userDto);
    List<User> userDtoToUser(List<UserDto> userDto);

    UserRespDto userToUserDto(User user);
    List<UserRespDto> userToUserDto(List<User> user);

}
