package org.example.case3FurkanYabanci.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDeleteRequestDto {

    private long id;
    private String name;
    private String phoneNumber;
}
