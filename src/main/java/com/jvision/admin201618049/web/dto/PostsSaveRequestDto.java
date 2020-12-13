package com.jvision.admin201618049.web.dto;

import com.jvision.admin201618049.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String name;
    private String tel;
    private String address;
    private String intro;

    @Builder
    public PostsSaveRequestDto(String title, String name, String tel, String address, String intro)
    {
        this.title = title;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.intro = intro;
    }

    public Posts toEntity()
    {
        return Posts.builder()
                .title(title)
                .name(name)
                .tel(tel)
                .address(address)
                .intro(intro)
                .build();
    }
}
