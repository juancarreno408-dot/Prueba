package com.example.demo.service;

import com.example.demo.model.Jugador;
import java.util.List;

public interface IJugadorService {
    List<Jugador> listarTodos();
    void guardar(Jugador jugador);
    Jugador buscarPorId(Long id);
    void eliminar(Long id);
    List<Jugador> buscarPorNombre(String q);
}