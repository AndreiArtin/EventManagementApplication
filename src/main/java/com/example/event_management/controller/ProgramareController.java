package com.example.event_management.controller;

import com.example.event_management.Programare;
import com.example.event_management.ProgramareService;
import com.example.event_management.dto.FormularDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/formular")
public class ProgramareController {

    @Autowired// sa folosesc contructori in loc de autowired
    private ProgramareService programareService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody Programare programare) {
        if (programare.getDetaliiEveniment() == null || programare.getDetaliiEveniment().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Detalii Eveniment is required");
        }
        programareService.addProgramare(programare);
        return ResponseEntity.ok("Programare successfully added");
    }

    @GetMapping("/confirmare")
    public String confirmare() {
        return "formular/confirmare";
    }

    @GetMapping
    public List<Programare> getAllProgramari() {
        return programareService.getAllProgramari();
    }

    @PutMapping("/{id}")
    public Programare updateProgramare(@PathVariable Long id, @RequestBody Programare programare) {
        return programareService.updateProgramare(id, programare);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramare(@PathVariable Long id) {
        programareService.deleteProgramare(id);
    }

    @PostMapping("/formular-classic")
    public String addProgramareClassic(@ModelAttribute FormularDTO formularDTO, Model model) {
        if (formularDTO.getDetaliiEveniment() == null || formularDTO.getDetaliiEveniment().isEmpty()) {
            model.addAttribute("error", "Detalii Eveniment sunt necesare.");
            return "formular/formular";
        }

        Programare programare = new Programare();
        programare.setNume(formularDTO.getNume());
        programare.setEmail(formularDTO.getEmail());
        programare.setTelefon(formularDTO.getTelefon());
        programare.setCompanie(formularDTO.getCompanie());
        programare.setDetaliiEveniment(formularDTO.getDetaliiEveniment());
        programare.setLocatieEveniment(formularDTO.getLocatieEveniment());

        try {
            programareService.addProgramare(programare);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "A apărut o problemă la procesarea formularului.");
            return "formular/formular";
        }

        return "redirect:/formular/confirmare";
    }

}
