package com.example.demo.repository;

import com.example.demo.model.Competecion; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompeticionRepository extends JpaRepository<Competecion, Long> {
    List<Competecion> findByNombreContainingIgnoreCase(String q);
}