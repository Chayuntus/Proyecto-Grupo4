package com.ciclo2.proyectoia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ciclo2.proyectoia.dao.IRegionDao;
import com.ciclo2.proyectoia.models.Region;

import java.util.List;


@Service
public class RegionService {
    @Autowired
    private IRegionDao regionDao;

    public List<Region> listar() {
        return regionDao.findAll();
    }
    public void guardar(Region Region) {
        regionDao.save(Region);
    }
    public void eliminar(Integer id) {
        regionDao.deleteById(id);
    }
    public Region encontrar(Integer id) {
        return regionDao.findById(id).orElse(null);
    }


} 


