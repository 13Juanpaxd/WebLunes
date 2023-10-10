package com.tienda.services;


import com.tienda.domain.categoria;
import java.util.List;

public interface CategoriaService {
 
    public List<categoria>getCategorias(boolean activo);
    
}
