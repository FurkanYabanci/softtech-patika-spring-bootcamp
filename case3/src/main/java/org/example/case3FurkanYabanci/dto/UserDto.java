package org.example.case3FurkanYabanci.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.case3FurkanYabanci.model.UserType;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private UserType userType;
}
