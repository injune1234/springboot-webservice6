package com.jvision.admin201618049.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT", nullable = false)
    private String title;

    @Column(columnDefinition="TEXT", nullable = false)
    private String name ;

    private String tel;

    private String address;

    @Column(length = 300, nullable = true)
    private String intro;

    @Builder
    public Posts(String title, String name, String tel, String address, String intro)
    {
        this.title = title;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.intro = intro;
    }

    public void update(String title, String name, String tel, String address, String intro)
    {
        this.title = title;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.intro = intro;
    }

}
