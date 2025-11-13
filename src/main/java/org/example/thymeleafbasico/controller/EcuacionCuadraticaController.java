package org.example.thymeleafbasico.controller;

import jakarta.validation.Valid;
import org.example.thymeleafbasico.modelo.CuadraticaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.MathContext;

//ejercicio 5
@Controller
@RequestMapping("/cuadratica")
public class EcuacionCuadraticaController {
    @GetMapping("/formulario")
    public String formulario(Model model, @ModelAttribute CuadraticaDTO cuadraticaDTO) {
        model.addAttribute("cuadraticaDTO", cuadraticaDTO);
        return "cuadratica";
    }

    @PostMapping("/formulario/enviar")
    public String formularioEnviar(Model model,@Valid @ModelAttribute CuadraticaDTO cuadraticaDTO) {
        BigDecimal a = cuadraticaDTO.getA();
        BigDecimal b = cuadraticaDTO.getB();
        BigDecimal c = cuadraticaDTO.getC();

        BigDecimal discriminante = b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));
        if(discriminante.compareTo(BigDecimal.ZERO)>=0){
            BigDecimal raizDiscriminante = discriminante.sqrt(MathContext.DECIMAL128);
            BigDecimal raiz1 = b.negate().add(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a),MathContext.DECIMAL128);
            BigDecimal raiz2 = b.negate().subtract(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a),MathContext.DECIMAL128);
           model.addAttribute("msg","tiene solucion");
            //cuadraticaDTO.setRaiz1(raiz1);  son dos formas de pasar los datos a la vista
            // cuadraticaDTO.setRaiz2(raiz2);
            model.addAttribute("raiz1", raiz1);
            model.addAttribute("raiz2", raiz2);
        } else{
            model.addAttribute("msg","sin solucion");
        }


        return "cuadratica";
    }
}
