package com.socialmeli.dtos.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer followers_count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDTO> followed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDTO> followers;

}
