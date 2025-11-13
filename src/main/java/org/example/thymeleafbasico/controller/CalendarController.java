package org.example.thymeleafbasico.controller;

import org.example.thymeleafbasico.modelo.CalendarRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @GetMapping("")
    public String getCalendarForm(Model model, @ModelAttribute CalendarRequestDTO calendarRequestDTO, Locale locale) {

        //Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG,new Locale("es"));

        List<String> meses = new ArrayList<>(12);
        Calendar calendar= Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            calendar.set(2025, i, 0);
            meses.add(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG,locale));
        }
        model.addAttribute("meses", meses);
        model.addAttribute("CalendarRequestDTO", calendarRequestDTO);
        return "calendar";
    }

    @PostMapping("")
    public String calcularMes(Model model, @ModelAttribute CalendarRequestDTO calendarRequestDTO) {

        String mes= calendarRequestDTO.getMes();
        int anio= calendarRequestDTO.getAnio();

        return "show-calendar";
    }

}
