package org.example.case3FurkanYabanci.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private String text;
    private long userId;
    private long productId;
}
