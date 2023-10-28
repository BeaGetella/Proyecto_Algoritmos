
import java.io.File;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
public class RegistroDeVotantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int opcion;
        
        System.out.println("SISTEMA DE VOTACIONES\n");
    File f = new File ("Registro_Votantes.txt");
    System.out.println("Registro de Votantes");
    System.out.println("1. Agregar Votante");
    System.out.println("2. Modificar Votante");
    System.out.println("3. Reiniciar contraseña de votante");
    System.out.println("4. Registrar fallecimiento de votante\n");
    System.out.println("Ingrese una opción:");
    opcion = scan.nextInt();
    
    
    
    
    }
    
}
