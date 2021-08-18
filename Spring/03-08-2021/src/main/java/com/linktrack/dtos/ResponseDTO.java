package com.linktrack.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String link;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idLink;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer metrics;

    public ResponseDTO(String message){
        this.message = message;
    }
}
