package com.jvision.admin201618049.web.dto;

import com.jvision.admin201618049.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private String title;
    private String name;
    private String tel;
    private String address;
    private String intro;

    public PostsResponseDto(Posts entity)
    {
        this.title = entity.getTitle();
        this.name = entity.getName();
        this.tel = entity.getTel();
        this.address = entity.getAddress();
        this.intro = entity.getIntro();
    }

}
