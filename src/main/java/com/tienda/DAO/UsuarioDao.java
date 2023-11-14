package com.tienda.DAO;

import com.tienda.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

    
    //ejemplo de un metodo utilizando metodos query
    public Usuario findByUsername(String username);
   
   

}


