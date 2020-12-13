package com.jvision.admin201618049.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String name;
    private String tel;
    private String address;
    private String intro;

    @Builder
    public PostsUpdateRequestDto(String title, String name, String tel, String address, String intro)
    {
        this.title = title;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.intro = intro;
    }
}
