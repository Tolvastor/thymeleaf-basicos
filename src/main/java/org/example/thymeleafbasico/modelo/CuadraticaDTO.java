package org.example.thymeleafbasico.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuadraticaDTO {
    @NotNull
    private BigDecimal a;
    @NotNull
    private BigDecimal b;
    @NotNull
    private BigDecimal c;

    //sin validacion
    private BigDecimal raiz1;
    private BigDecimal raiz2;
}
