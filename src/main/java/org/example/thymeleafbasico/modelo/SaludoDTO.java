package org.example.thymeleafbasico.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaludoDTO {
    // para recibir y enviar datos a la vista
    private String nombre;
    private String idioma;
}
