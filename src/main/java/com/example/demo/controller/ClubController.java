package com.example.demo.controller;

import com.example.demo.model.Club;
import com.example.demo.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private IClubService clubService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubService.listarTodos());
        return "lista-clubes";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("club", new Club());
        return "form-club";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        clubService.guardar(club);
        return "redirect:/clubes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("club", clubService.buscarPorId(id));
        return "form-club";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clubService.eliminar(id);
        return "redirect:/clubes";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String q, Model model) {
        model.addAttribute("clubes", clubService.buscarPorNombre(q));
        return "lista-clubes";
    }
}