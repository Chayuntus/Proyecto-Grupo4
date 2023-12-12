package com.ciclo2.proyectoia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ciclo2.proyectoia.dao.IIdiomaDao;
import com.ciclo2.proyectoia.models.Idioma;
import java.util.List;

@Service
public class IdiomaService {

    @Autowired
    private IIdiomaDao idiomaDao;

    public List<Idioma> listar() {
        return idiomaDao.findAll();
    }

    public Idioma encontrar(Integer id) {
        return idiomaDao.findById(id).orElse(null);
    }

    public void guardar(Idioma idioma) {
        idiomaDao.save(idioma);
    }

    public void eliminar(Integer id) {
        idiomaDao.deleteById(id);
    }


}



