package org.example.case3FurkanYabanci.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductSaveRequestDto {

    private String name;
    private BigDecimal price;
}
