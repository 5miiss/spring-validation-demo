package com.validationdemo.buissenes.service.impl;

import com.validationdemo.buissenes.dto.request.UserDto;
import com.validationdemo.buissenes.dto.response.ResponseDto;
import com.validationdemo.buissenes.dto.response.UserRespDto;
import com.validationdemo.buissenes.mapper.RoleMapper;
import com.validationdemo.buissenes.mapper.UserMapper;
import com.validationdemo.buissenes.service.interfaces.UserService;
import com.validationdemo.persistence.entities.Role;
import com.validationdemo.persistence.entities.User;
import com.validationdemo.persistence.repository.RoleRepo;
import com.validationdemo.persistence.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public ResponseDto getUserByRef(String refNo) {
        return ResponseDto.builder()
                .message("succecssful request")
                .status(true)
                .code(200)
                .data(UserMapper.INSTANCE.userToUserDto( userRepo.findByRefNoAndDeletedFalse(refNo)
                        .orElseThrow(()->new RuntimeException("user not found"))))
                .build();

    }

    @Override
    public ResponseDto getUsers() {
        return
                ResponseDto.builder()
                        .message("succecssful request")
                        .status(true)
                        .code(200)
                        .data(UserMapper.INSTANCE.userToUserDto(userRepo.findAll()))
                        .build();

    }

    @Override
    @Transactional
    public ResponseDto addUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user.setRefNo(UUID.randomUUID().toString());
        List<Role> roles = RoleMapper.INSTANCE.roleDtoToRole(userDto.getRoles());
        Iterator<Role> roleIterator = roles.listIterator();
        List<Role> rolesSaved = new ArrayList<>();
        while (roleIterator.hasNext()){
            Role role = roleIterator.next();
            if (!roleRepo.existsByRoleName(role.getRoleName())){
                rolesSaved.add(roleRepo.saveAndFlush(role));
            }
            else
                rolesSaved.add(roleRepo.findByRoleName(role.getRoleName()));
        }
        user.setRoles(rolesSaved);

        return
                ResponseDto.builder()
                        .message("succecssful request")
                        .status(true)
                        .code(200)
                        .data(UserMapper.INSTANCE.userToUserDto(userRepo.save(user)))
                        .build();

    }

    @Override
    @Transactional

    public ResponseDto updateUser(String refNo, UserDto userDto) {
        User user = userRepo.findByRefNoAndDeletedFalse(refNo).orElseThrow(()->new RuntimeException("no user found"));
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        List<Role> roles = RoleMapper.INSTANCE.roleDtoToRole(userDto.getRoles());
        Iterator<Role> roleIterator = roles.listIterator();
        List<Role> rolesSaved = new ArrayList<>();
        while (roleIterator.hasNext()){
            Role role = roleIterator.next();
            if (!roleRepo.existsByRoleName(role.getRoleName())){
                rolesSaved.add(roleRepo.saveAndFlush(role));
            }
        }
        user.setRoles(rolesSaved);


        return ResponseDto.builder()
                .message("succecssful request")
                .status(true)
                .code(200)
                .data(UserMapper.INSTANCE.userToUserDto(userRepo.save(user)))
                .build();

    }

    @Override
    @Transactional
    public ResponseDto deleteUser(String refNo) {
        User user = userRepo.findByRefNoAndDeletedFalse(refNo).orElseThrow(()->new RuntimeException("no user found"));
        userRepo.delete(user);
        return ResponseDto.builder()
                .message("succecssful request")
                .status(true)
                .code(200)
                .data(null)
                .build();
    }
}
