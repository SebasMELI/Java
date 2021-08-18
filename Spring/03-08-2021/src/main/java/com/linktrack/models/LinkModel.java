package com.linktrack.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LinkModel {
    private String link;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idLink;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean validate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer metrics;

    public LinkModel(){
        this.validate = true;
    }
}
