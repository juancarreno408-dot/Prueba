package com.example.demo.service;

import com.example.demo.model.Jugador;
import com.example.demo.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorServiceImpl implements IJugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public List<Jugador> listarTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public void guardar(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public Jugador buscarPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }

    @Override
    public List<Jugador> buscarPorNombre(String q) {
        return jugadorRepository.findByNombreContainingIgnoreCase(q);
    }
}