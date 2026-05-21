package com.example.demo.service;

import com.example.demo.model.Entrenador;
import java.util.List;

public interface IEntrenadorService {
    List<Entrenador> listarTodos();
    void guardar(Entrenador entrenador);
    Entrenador buscarPorId(Long id);
    void eliminar(Long id);
    List<Entrenador> buscarPorNombre(String q);
}