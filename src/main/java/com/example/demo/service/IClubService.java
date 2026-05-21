package com.example.demo.service;

import com.example.demo.model.Club;
import java.util.List;

public interface IClubService {
    List<Club> listarTodos();
    void guardar(Club club);
    Club buscarPorId(Long id);
    void eliminar(Long id);
    List<Club> buscarPorNombre(String q);
}