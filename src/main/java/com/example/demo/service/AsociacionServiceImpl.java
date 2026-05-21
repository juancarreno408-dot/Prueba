package com.example.demo.service;

import com.example.demo.model.Asociacion;
import com.example.demo.repository.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsociacionServiceImpl implements IAsociacionService {

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Override
    public List<Asociacion> listarTodos() { return asociacionRepository.findAll(); }

    @Override
    public void guardar(Asociacion asociacion) { asociacionRepository.save(asociacion); }

    @Override
    public Asociacion buscarPorId(Long id) { return asociacionRepository.findById(id).orElse(null); }

    @Override
    public void eliminar(Long id) { asociacionRepository.deleteById(id); }

    @Override
    public List<Asociacion> buscarPorNombre(String q) { 
        return asociacionRepository.findByNombreContainingIgnoreCase(q); 
    }
}