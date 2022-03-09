package org.example.case3FurkanYabanci.converter;

import org.example.case3FurkanYabanci.dto.UserDto;
import org.example.case3FurkanYabanci.dto.request.UserSaveRequestDto;
import org.example.case3FurkanYabanci.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);
    UserDto convertToUserDto(User user);
    List<UserDto> convertToUserDtoList(List<User> userList);

}
