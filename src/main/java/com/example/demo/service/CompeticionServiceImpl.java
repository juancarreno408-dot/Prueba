package com.example.demo.service;

import com.example.demo.model.Competecion; // Revisa si tu entidad es Competecion o Competicion
import com.example.demo.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompeticionServiceImpl implements ICompeticionService {

    @Autowired
    private CompeticionRepository competicionRepository;

    @Override
    public List<Competecion> listarTodos() { return competicionRepository.findAll(); }

    @Override
    public void guardar(Competecion competicion) { competicionRepository.save(competicion); }

    @Override
    public Competecion buscarPorId(Long id) { return competicionRepository.findById(id).orElse(null); }

    @Override
    public void eliminar(Long id) { competicionRepository.deleteById(id); }

    @Override
    public List<Competecion> buscarPorNombre(String q) { 
        return competicionRepository.findByNombreContainingIgnoreCase(q); 
    }
}