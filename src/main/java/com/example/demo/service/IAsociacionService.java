package com.example.demo.service;

import com.example.demo.model.Asociacion;
import java.util.List;

public interface IAsociacionService {
    List<Asociacion> listarTodos();
    void guardar(Asociacion asociacion);
    Asociacion buscarPorId(Long id);
    void eliminar(Long id);
    List<Asociacion> buscarPorNombre(String q);
}