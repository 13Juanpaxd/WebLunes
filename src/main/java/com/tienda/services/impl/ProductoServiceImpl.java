package com.tienda.services.impl;

import com.tienda.DAO.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao ProductoDao;

    
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
    
        var Productos = ProductoDao.findAll();
        if (activo){
            Productos.removeIf(e -> !e.isActivo());
        }
        return Productos;
        
    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
        
        return ProductoDao.findById(producto.getIdProducto()).orElse(null);
        
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        
        ProductoDao.save(producto);
        
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        ProductoDao.delete(producto);
    }

    
    public List<Producto> consultaQuery(double precioInf,double precioSup){
    return ProductoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    public List<Producto> consultaJPQL(double precioInf,double precioSup){
    return ProductoDao.consultaJPQL(precioInf, precioSup);
    }
    
    public List<Producto> consultaSQL(double precioInf,double precioSup){
    return ProductoDao.consultaSQL(precioInf, precioSup);
    }
    
}
