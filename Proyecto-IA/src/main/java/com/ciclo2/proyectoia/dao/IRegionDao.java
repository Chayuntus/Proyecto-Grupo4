package com.ciclo2.proyectoia.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ciclo2.proyectoia.models.Region;

public interface IRegionDao extends JpaRepository<Region, Integer> {

    List<Region> findByNombre(String nombre);

}

