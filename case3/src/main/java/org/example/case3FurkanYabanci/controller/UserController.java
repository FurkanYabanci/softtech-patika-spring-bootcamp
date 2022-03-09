package org.example.case3FurkanYabanci.controller;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.dto.UserDto;
import org.example.case3FurkanYabanci.dto.request.UserDeleteRequestDto;
import org.example.case3FurkanYabanci.generic.dto.RestResponse;
import org.example.case3FurkanYabanci.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.case3FurkanYabanci.dto.request.UserSaveRequestDto;
import org.example.case3FurkanYabanci.dto.request.UserUpdateRequestDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @GetMapping
    public ResponseEntity getAll(){
        List<UserDto> userDtoList = userService.findAll();
        return ResponseEntity.ok(RestResponse.of(userDtoList));
    }

    @GetMapping(value = "/byId/{id}")
    public ResponseEntity getById(@PathVariable long id){
        UserDto userDto = userService.getById(id);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @GetMapping(value = "/byName/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        UserDto userDto = userService.findByName(name);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        UserDto userDto = userService.save(userSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateRequestDto userUpdateRequestDto){
        UserDto userDto = userService.update(userUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody UserDeleteRequestDto userDeleteRequestDto){
        userService.delete(userDeleteRequestDto);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
