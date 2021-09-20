package com.mercadolibre.demo_app_sebas.dtos;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data")
public class NormalDataDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date date;
}
