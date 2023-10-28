
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
public class USUARIOSPRUEBA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        int opcion2;
        String nombre, correo, contraseña;
        String apellido; 
        String rol;
        String correomodi;
        String Nnombre, Napellido, Ncorreo;
        
        File f = new File("Registro_Usuarios2.txt");
        System.out.println("SISTEMA DE VOTACIONES\n");
        System.out.println("1. Crear usuario del sistema");
        System.out.println("2. Modificar usuario del sistema");
        System.out.println("3. Reiniciar contraseña");
        System.out.println("4. Ingrese una opción:");
        opcion = scan.nextInt();
        
        switch (opcion) {
            case 1: 
                System.out.println("Ingrese sus nombres");
                nombre =scan.next();
                scan.nextLine();
                System.out.println("Ingrese sus apellidos");
                apellido =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su correo electronico");
                correo =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su contraseña");
                contraseña =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su Rol");
                rol =scan.next();
                
                String registro = nombre + "|" + apellido + "|" + correo + "|" + contraseña + "|" + rol;
                    try {
                        FileWriter fw = new FileWriter("Registro_Usuarios2.txt");
                        BufferedWriter bw = new BufferedWriter(fw); 
                        bw.write("Registro_Usuarios2.txt\n");
                        bw.close();
                        System.out.println("\nRegistro exitoso.");
                    } catch (IOException ex) {
                        System.out.println("\nError al registrar usuar1io: " + e.getMessage());
                    }
                    break;
            case 2:
               
                    try {
                        FileReader fr = new FileReader("Modificacion_Usuarios"); 
                        BufferedReader br = new BufferedReader(fr);
                        
                        FileWriter fw = new FileWriter(f, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String linea = "";
                        System.out.println("Modificación de usuarios en el sistema");
                        System.out.println("Elija la opción que requiere modificación");
                        System.out.println("1. Modificar primer nombre");
                        System.out.println("2. Modificar segundo nombre");
                        System.out.println("3. Modificar primer apellido");
                        System.out.println("4. Modificar segundo apellido");
                        System.out.println("5. Modificar correo electronico");
                        System.out.println("6. Modificar contraseña");
                        System.out.println("7. Deshabilitar del sistema");
                        opcion2 = scan.nextInt();
                    
                     
                     
                    } catch (IOException ex) {
                        System.out.println(ex);
                        System.out.println("Cambios realizados con éxito");
                    }
                    break;

            case 3: 
                    try {
                        FileReader fr = new FileReader(f); //lector de archivo//
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {  //expresion relacional//
                            System.out.println(linea);
                        } 
                        br.close();
                    } catch (FileNotFoundException ex) { //captura otro error//
                        System.out.println(ex);
                    } catch (IOException ex) { //captura el anterior//
                    System.out.println(ex);
                    }
                    break;
            case 4:
                    try {
                        FileReader fr = new FileReader(f);//se abre archivo para lectura//
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("archivo_texto_copia.txt"); //archvo//
                        FileWriter fw = new FileWriter(fc);//abrir el archivo//
                        BufferedWriter bw = new BufferedWriter(fw);//envoltura//
                        
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");  //leer el archivo//
                            if (datos[0].compareTo("123456") == 0) {
                                linea = "123456|Estela|González|F|21|Ingeniería";
                            }
                            
                            bw.write(linea+"\n");
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    } catch (IOException ex) {
                    System.out.println(ex);
                    } 
                    break;
            case 5: 
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("archivo_texto_copia.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo("123456") != 0) {
                                bw.write(linea+"\n");
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    } catch (IOException ex) {
                    System.out.println(ex);
                    } 
                    break;
            default: System.out.println("Ingrese una opción válida.");
        }
    }
    
}
    
    

