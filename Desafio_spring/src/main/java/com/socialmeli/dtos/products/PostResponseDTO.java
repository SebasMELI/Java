package com.socialmeli.dtos.products;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;
    private Integer id_post;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private ProductResponseDTO detail;
    private Integer category;
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;
}
