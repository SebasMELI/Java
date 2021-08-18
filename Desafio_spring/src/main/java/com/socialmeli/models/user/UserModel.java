package com.socialmeli.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private Integer userId;
    private String userName;
    private Integer followers_count;
    private List<UserModel> followed;
    private List<UserModel> followers;
}
