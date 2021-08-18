package com.socialmeli.models.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostXUserModel {
    private Integer userId;
    private List<PostModel> posts;
}
