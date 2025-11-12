package org.example.thymeleafbasico.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafbasico.modelo.SaludoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SaludoController {
    //endpoint
    @GetMapping("/saludos")
    public String saludos(Model model, @ModelAttribute SaludoDTO saludoDTO) {
        model.addAttribute("saludoDTO", saludoDTO);

        return "saludos";
    }

    @PostMapping("/saludos")
    public String saludosSubmit(Model model, @ModelAttribute SaludoDTO saludoDTO) {

        log.info(saludoDTO.toString());
        String salida = "";
        if("es".equals(saludoDTO.getIdioma())) {
            salida="hola " + saludoDTO.getNombre();
        } else if ("en".equals(saludoDTO.getIdioma())) {
            salida="hello " + saludoDTO.getNombre();
        } else if ("fr".equals(saludoDTO.getIdioma())) {
            salida="bonjour " + saludoDTO.getNombre();

        }else{
            salida ="idioma no soportado";
        }
model.addAttribute("saludo", salida);

        return "saludos";
    }


}
