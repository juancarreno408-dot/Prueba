package com.example.demo.controller;

import com.example.demo.model.Entrenador;
import com.example.demo.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private IEntrenadorService entrenadorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", entrenadorService.listarTodos());
        return "lista-entrenadores";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "form-entrenador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        entrenadorService.guardar(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorService.buscarPorId(id));
        return "form-entrenador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        entrenadorService.eliminar(id);
        return "redirect:/entrenadores";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String q, Model model) {
        model.addAttribute("entrenadores", entrenadorService.buscarPorNombre(q));
        return "lista-entrenadores";
    }
}