package com.example.demo.repository;

import com.example.demo.model.Asociacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsociacionRepository extends JpaRepository<Asociacion, Long> {
    List<Asociacion> findByNombreContainingIgnoreCase(String q);
}