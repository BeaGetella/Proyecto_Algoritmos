

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
public class registrousuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
    String nombre, apellido, correo, contraseña, rol;
    
    System.out.println("SISTEMA DE VOTACIONES\n");
    File f = new File ("Registro_Usuarios.txt");
    System.out.println("1. Crear usuario del sistema");
    System.out.println("2. Modificar usuario del sistema");
    System.out.println("3. Reiniciar contraseña");
    System.out.println("Ingrese una opción:");
    opcion = scan.nextInt();
    
   
   switch (opcion) {
        case 1 -> {
            System.out.println("Ingrese sus nombres");
            nombre =scan.next();
            scan.next();
            System.out.println("Ingrese sus apellidos");
            apellido =scan.next();
            System.out.println("Ingrese su correo electronico");
            correo =scan.next();
            System.out.println("Ingrese su contraseña");
            contraseña =scan.next();
            scan.next();
            System.out.println("Ingrese su Rol");
            rol =scan.next();
            
           String registro = nombre + "|" + apellido + "|" + correo + "|" + contraseña + "|" + rol;

        try {
            FileWriter fw = new FileWriter("Registro_Usuarios.txt", true);
            fw.write(registro + "\n");
            fw.close();
            System.out.println("\nRegistro exitoso.");
        } catch (IOException e) {
            System.out.println("\nError al registrar usuario: " + e.getMessage());
        }
    }
}
  
            
        
    }
     }
       
                        
   
        
        
    
        
        
      

    

