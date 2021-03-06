package org.example.case3FurkanYabanci.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private BigDecimal price;
}
