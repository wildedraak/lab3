package com.mitocode.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CamisaDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    private Integer numero;

    @NotNull
    private String color;
}