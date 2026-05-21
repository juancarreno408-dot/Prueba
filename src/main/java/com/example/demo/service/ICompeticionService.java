package com.example.demo.service;

import com.example.demo.model.Competecion; // Revisa si es con 'e' o 'i'
import java.util.List;

public interface ICompeticionService {
    List<Competecion> listarTodos();
    void guardar(Competecion competicion);
    Competecion buscarPorId(Long id);
    void eliminar(Long id);
    List<Competecion> buscarPorNombre(String q);
}