package com.tienda.services.impl;

import com.tienda.DAO.CategoriaDao;
import com.tienda.domain.categoria;
import com.tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<categoria> getCategorias(boolean activo) {
    
        var categorias = categoriaDao.findAll();
        if (activo){
            categorias.removeIf(e -> !e.isActivo());
        }
        return categorias;
        
    }

    @Override
    @Transactional(readOnly=true)
    public categoria getCategoria(categoria categoria) {
        
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
        
    }

    @Override
    @Transactional
    public void save(categoria categoria) {
        
        categoriaDao.save(categoria);
        
    }

    @Override
    @Transactional
    public void delete(categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
