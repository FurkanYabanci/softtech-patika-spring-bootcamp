package org.example.case3FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.converter.UserMapper;
import org.example.case3FurkanYabanci.dto.UserDto;
import org.example.case3FurkanYabanci.dto.request.UserDeleteRequestDto;
import org.example.case3FurkanYabanci.dto.request.UserSaveRequestDto;
import org.example.case3FurkanYabanci.dto.request.UserUpdateRequestDto;
import org.example.case3FurkanYabanci.generic.exception.ItemNotFoundException;
import org.example.case3FurkanYabanci.generic.model.BaseAdditionalFields;
import org.example.case3FurkanYabanci.model.User;
import org.example.case3FurkanYabanci.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

     private final UserRepository userRepository;

    public List<UserDto> findAll(){
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = UserMapper.INSTANCE.convertToUserDtoList(userList);
        return userDtoList;
    }

    public UserDto getById(long id){
        User user = findById(id);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public UserDto findByName(String name){
        User user = userRepository.findByName(name).orElseThrow(() -> new ItemNotFoundException("User Not Found!"));
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public UserDto save(UserSaveRequestDto userSaveRequestDto){
        checkUser(userSaveRequestDto);
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        BaseAdditionalFields baseAdditionalFields = new BaseAdditionalFields();
        setAdditionalFields(user);
        user = userRepository.save(user);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public UserDto update(UserUpdateRequestDto userUpdateRequestDto){
        User user = findById(userUpdateRequestDto.getId());
        user.setName(userUpdateRequestDto.getName());
        user.setEmail(userUpdateRequestDto.getEmail());
        user.setPhoneNumber(userUpdateRequestDto.getPhoneNumber());
        user.setUserType(userUpdateRequestDto.getUserType());
        setAdditionalFields(user);
        user = userRepository.save(user);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public void delete(UserDeleteRequestDto userDeleteRequestDto){
        User user = findById(userDeleteRequestDto.getId());
        if (user.getPhoneNumber().equals(userDeleteRequestDto.getPhoneNumber()) &&
                user.getName().equals(userDeleteRequestDto.getName()))
        {
            userRepository.delete(user);
        }else {
            throw  new ItemNotFoundException(userDeleteRequestDto.getName()
                    +" kullanıcı adı ile "
                    +userDeleteRequestDto.getPhoneNumber()
                    +" telefonu bilgileri uyuşmamaktadır!");
        }
    }

    protected User findById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("User Not Found!"));
        return user;
    }

    private void checkUser(UserSaveRequestDto userSaveRequestDto){ //todo:base dto yapabilirim
        List<User> userList = userRepository.findAll();
        for (User u:userList) {
            if (u.getName().equals(userSaveRequestDto.getName())){
                throw new ItemNotFoundException("Username already exists.");
            }
            else if (u.getEmail().equals(userSaveRequestDto.getEmail())){
                throw new ItemNotFoundException("Email already exists.");
            }
            else if (u.getPhoneNumber().equals(userSaveRequestDto.getPhoneNumber())){
                throw new ItemNotFoundException("Phone Number already exists.");
            }
        }
    }

    private void setAdditionalFields(User user){
        BaseAdditionalFields baseAdditionalFields = new BaseAdditionalFields();
        baseAdditionalFields.setUpdateDate(new Date());
        if (baseAdditionalFields.getCreateDate() == null){
            baseAdditionalFields.setCreateDate(new Date());
            user.setBaseAdditionalFields(baseAdditionalFields);
        }
    }
}
