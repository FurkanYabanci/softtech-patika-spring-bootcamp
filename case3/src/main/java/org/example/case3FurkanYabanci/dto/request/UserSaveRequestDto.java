package org.example.case3FurkanYabanci.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.case3FurkanYabanci.model.UserType;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String name;
    private String email;
    private String phoneNumber;
    private UserType userType;
}
