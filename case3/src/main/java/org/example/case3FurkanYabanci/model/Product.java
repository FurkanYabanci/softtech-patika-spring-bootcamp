package org.example.case3FurkanYabanci.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.case3FurkanYabanci.generic.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseModel {

    @Id
    @SequenceGenerator(name = "Product" , sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "Product")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "PRICE",precision = 19,scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments ;


}
