
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class Usuario {
 
    private static final long serialVersionUID= 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String rutaImagen;
    private boolean activo;
    
    
    @OneToMany
@JoinColumn(name="id_usuario",updatable=false)
List<Rol> roles;

}
