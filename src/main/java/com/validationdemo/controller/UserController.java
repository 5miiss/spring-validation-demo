package com.validationdemo.controller;

import com.validationdemo.buissenes.dto.request.UserDto;
import com.validationdemo.buissenes.dto.response.ResponseDto;
import com.validationdemo.buissenes.service.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{refNo}")
    ResponseDto getUserByRef(@PathVariable String refNo){
        return userService.getUserByRef(refNo);
    }
    @GetMapping()
    ResponseDto getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    ResponseDto addUser(@RequestBody @Valid UserDto userDto){
        return userService.addUser(userDto);
    }
    @PutMapping("/{refNo}")

    ResponseDto updateUser(@PathVariable String refNo,@RequestBody @Valid  UserDto userDto){
        return userService.updateUser(refNo, userDto);
    }
    @DeleteMapping("/{refNo}")

    ResponseEntity<?> deleteUser(@PathVariable String refNo){

        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(userService.deleteUser(refNo));
    }
}
