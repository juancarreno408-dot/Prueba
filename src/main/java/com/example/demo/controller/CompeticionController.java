package com.example.demo.controller;

import com.example.demo.model.Competecion; // Revisa si es con 'e' o 'i'
import com.example.demo.service.ICompeticionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private ICompeticionService competicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("competiciones", competicionService.listarTodos());
        return "lista-competiciones";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("competicion", new Competecion());
        return "form-competicion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competecion competicion) {
        competicionService.guardar(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("competicion", competicionService.buscarPorId(id));
        return "form-competicion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        competicionService.eliminar(id);
        return "redirect:/competiciones";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String q, Model model) {
        model.addAttribute("competiciones", competicionService.buscarPorNombre(q));
        return "lista-competiciones";
    }
}