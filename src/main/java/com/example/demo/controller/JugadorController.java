package com.example.demo.controller;

import com.example.demo.model.Jugador;
import com.example.demo.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", jugadorService.listarTodos());
        return "lista-jugadores";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "form-jugador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        jugadorService.guardar(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorService.buscarPorId(id));
        return "form-jugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return "redirect:/jugadores";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String q, Model model) {
        model.addAttribute("jugadores", jugadorService.buscarPorNombre(q));
        return "lista-jugadores";
    }
}