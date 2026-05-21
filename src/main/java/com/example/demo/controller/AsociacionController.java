package com.example.demo.controller;

import com.example.demo.model.Asociacion;
import com.example.demo.service.IAsociacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private IAsociacionService asociacionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asociaciones", asociacionService.listarTodos());
        return "lista-asociaciones";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "form-asociacion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        asociacionService.guardar(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("asociacion", asociacionService.buscarPorId(id));
        return "form-asociacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        asociacionService.eliminar(id);
        return "redirect:/asociaciones";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String q, Model model) {
        model.addAttribute("asociaciones", asociacionService.buscarPorNombre(q));
        return "lista-asociaciones";
    }
}