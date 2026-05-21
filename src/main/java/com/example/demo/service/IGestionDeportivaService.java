package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface IGestionDeportivaService {
    // Métodos para manejar relaciones entre entidades
    void asignarJugadorAClub(Long jugadorId, Long clubId);
    void vincularEntrenadorAClub(Long entrenadorId, Long clubId);
    void inscribirClubEnCompeticion(Long clubId, Long competicionId);
    
    // Consultas combinadas (JOINs)
    List<Club> obtenerClubesPorAsociacion(Long asociacionId);
}