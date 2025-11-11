package org.example.thymeleafbasico.controller;

import org.example.thymeleafbasico.modelo.SaludoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class saludoController {
    //endpoint
    @GetMapping("/saludos")
    public String saludos(Model model, @ModelAttribute SaludoDTO saludoDTO) {
    model.addAttribute("saludoDTO", saludoDTO);
        return "saludos";
    }

}
