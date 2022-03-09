package org.example.case3FurkanYabanci.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.case3FurkanYabanci.generic.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseModel {

    @Id
    @SequenceGenerator(name = "Comment" , sequenceName = "COMMENT_ID_SEQ")
    @GeneratedValue(generator = "Comment")
    private long id;

    @Lob
    @Column(name = "TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;





}
