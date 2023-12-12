package com.ciclo2.proyectoia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ciclo2.proyectoia.dao.ICulturaDao;
import com.ciclo2.proyectoia.models.Cultura;
import java.util.List;

@Service
public class CulturaService {

    @Autowired
    private ICulturaDao culturaRepo;

    public List<Cultura> listar(){
        return culturaRepo.findAll();
    }
    public void guardar(Cultura cultura) {
        culturaRepo.save(cultura);
    }
    public void eliminar(Integer id) {
        culturaRepo.deleteById(id);
    }
    public Cultura encontrar(Integer id) {
        return culturaRepo.findById(id).orElse(null);
    }

}