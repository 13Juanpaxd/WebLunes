package com.tienda.services;


import com.tienda.domain.categoria;
import java.util.List;

public interface CategoriaService {
 
    public List<categoria>getCategorias(boolean activo);
    
    
    //codigo para obtener categoria
    public categoria getCategoria(categoria categoria);
    
    
    
    //actualiza o crea un registro que tenga el mismo idCategoria
    public void save(categoria categoria);

    //se elimina el registro que tenga el idCategoria
    public void delete(categoria categoria);
    
}
