package com.example.demo.service;

import com.example.demo.model.Club;
import com.example.demo.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClubServiceImpl implements IClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<Club> listarTodos() { return clubRepository.findAll(); }

    @Override
    public void guardar(Club club) { clubRepository.save(club); }

    @Override
    public Club buscarPorId(Long id) { return clubRepository.findById(id).orElse(null); }

    @Override
    public void eliminar(Long id) { clubRepository.deleteById(id); }

    @Override
    public List<Club> buscarPorNombre(String q) { 
        return clubRepository.findByNombreContainingIgnoreCase(q); 
    }
}