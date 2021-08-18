package com.socialmeli.dtos.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostXUserDTO {
    private Integer userId;
    private List<PostResponseDTO> posts;
}
