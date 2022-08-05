package com.springframework.springboot.controllers;

import com.springframework.springboot.domain.Vacation;
import com.springframework.springboot.repositories.VacationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacationController {

    private final VacationRepository vacationRepository;

    public VacationController(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @RequestMapping("/vacations")
    public String getVacations(Model model){
        model.addAttribute("vacations",vacationRepository.findAll());
        return "vacations/list";
    }

    ///i don't know about this
    @PostMapping("/vacations")
    public String postvacation(@ModelAttribute Vacation vacation, Model model) {
        model.addAttribute("vacation", vacation);
        return "result";
    }
}
