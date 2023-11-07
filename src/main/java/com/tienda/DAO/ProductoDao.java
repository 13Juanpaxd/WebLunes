package com.tienda.DAO;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long>{

    
    //ejemplo de un metodo utilizando metodos query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf,double precioSup);
   
    //ejemplo de un metodo utilizando metodos query
 @Query(value="SELECT a FROM Producto a Where a.precio between :precioInf AND :precioSup ORDER BY a.descripcion ASC")
 public List<Producto> consultaJPQL(double precioInf,double precioSup);
 
  //ejemplo de un metodo utilizando metodos query
 @Query(nativeQuery=true,value="SELECT * FROM Producto producto Where producto.precio between :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
 public List<Producto> consultaSQL(double precioInf,double precioSup);

}


