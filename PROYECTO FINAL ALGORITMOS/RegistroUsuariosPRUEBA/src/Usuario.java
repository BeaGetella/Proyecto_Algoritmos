
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;
    private List<Rol> roles;

    public Usuario(String nombre, String apellido, String correoElectronico, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.roles = new ArrayList<>();
    }

    public void editarUsuario(String nombre, String apellido, String correoElectronico, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    public void deshabilitarUsuario() {
        // Código para deshabilitar usuario
    }

    public void reiniciarContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
    }

    public void asignarRol(Rol rol) {
        this.roles.add(rol);
    }

    public void eliminarRol(Rol rol) {
        this.roles.remove(rol);
    }
} 
    

public class Rol {
    private String nombre;
    private List<String> funcionalidades;

    public Rol(String nombre) {
        this.nombre = nombre;
        this.funcionalidades = new ArrayList<>();
    }

    public void agregarFuncionalidad(String funcionalidad) {
        this.funcionalidades.add(funcionalidad);
    }

    public void eliminarFuncionalidad(String funcionalidad) {
        this.funcionalidades.remove(funcionalidad);
        
        Usuario usuario1 = new Usuario("Juan", "Pérez", "juan.perez@example.com", "contraseña123");
Rol rol1 = new Rol("Administrador");
rol1.agregarFuncionalidad("Acceso a todas las funcionalidades del sistema");
usuario1.asignarRol(rol1);

Usuario usuario2 = new Usuario("María", "García", "maria.garcia@example.com", "contraseña456");
Rol rol2 = new Rol("Registrador de votantes");
rol2.agregarFuncionalidad("Registro de votantes");
usuario2.asignarRol(rol2);
    }
}

