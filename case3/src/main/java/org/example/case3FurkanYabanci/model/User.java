package org.example.case3FurkanYabanci.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.case3FurkanYabanci.generic.model.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseModel {

    @Id
    @SequenceGenerator(name = "User" , sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "EMAIL",nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30)
    private UserType userType;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments ;

}
