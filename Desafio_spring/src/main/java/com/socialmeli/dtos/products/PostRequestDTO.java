package com.socialmeli.dtos.products;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDTO {
    private Integer userId;
    private Integer id_post;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private ProductRequestDTO detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
