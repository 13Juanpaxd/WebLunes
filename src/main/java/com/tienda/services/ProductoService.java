package com.tienda.services;


import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
 
    public List<Producto>getProductos(boolean activo);
    
    
    //codigo para obtener Producto
    public Producto getProducto(Producto producto);
    
    
    
    //actualiza o crea un registro que tenga el mismo idProducto
    public void save(Producto producto);

    //se elimina el registro que tenga el idProducto
    public void delete(Producto producto);

    
    
  //devuelve la lista de productos filtrados
    public List<Producto> consultaQuery(double precioInf,double precioSup);
    
    
    //devuelve la lista de productos filtrados
    public List<Producto> consultaJPQL(double precioInf,double precioSup);
    
     public List<Producto> consultaSQL(double precioInf,double precioSup);
}
