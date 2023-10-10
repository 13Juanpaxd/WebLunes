package com.tienda.services.impl;

import com.tienda.DAO.CategoriaDao;
import com.tienda.domain.categoria;
import com.tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<categoria> getCategorias(boolean activo) {
    
        var categorias = categoriaDao.findAll();
        if (activo){
            categorias.removeIf(e -> !e.isActivo());
        }
        return categorias;
        
    }
    
}
