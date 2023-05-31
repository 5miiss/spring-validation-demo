package com.validationdemo.buissenes.mapper;


import com.validationdemo.buissenes.dto.request.RoleDto;
import com.validationdemo.persistence.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper( RoleMapper.class );

    Role roleDtoToRole(RoleDto roleDto);
    List<Role> roleDtoToRole(List<RoleDto> roleDto);

    RoleDto roleToRoleDto(Role role);
    List<RoleDto> roleToRoleDto(List<Role> role);

}
