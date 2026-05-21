package com.example.demo.service;

import com.example.demo.model.Entrenador;
import com.example.demo.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements IEntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> listarTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    public void guardar(Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
    }

    @Override
    public Entrenador buscarPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }

    @Override
    public List<Entrenador> buscarPorNombre(String q) {
        return entrenadorRepository.findByNombreContainingIgnoreCase(q);
    }
}