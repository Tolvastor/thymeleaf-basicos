package org.example.thymeleafbasico.controller;

import org.example.thymeleafbasico.modelo.SaludoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcularController {
    //endpoint


    @GetMapping("calcular")
    public String calcular(Model model) {

        return "calcular";

    }

    @PostMapping("/calcular")
    public String calcularMedia(@ModelAttribute("nota1") double nota1,
                                @ModelAttribute("nota2") double nota2,
                                @ModelAttribute("nota3") double nota3,
                                Model model) {

        double media = (nota1 + nota2 + nota3) / 3;
        model.addAttribute("media", media);
        return "calcular";
    }
}