
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
public class SistemaDeVotaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Llamar a los metodos colocando el nombre del metodo según se llame la clase. 
        SistemaDeVotaciones met1 = new SistemaDeVotaciones();
        
        met1.configuracionInicial();
        
        met1.menuprincipal();
        
        met1.RegistroDeUsuarios();
        
        met1.RegistroDeVotantes();
        
        met1.AdministracionElecciones();
        
        met1.registroVot();
        
        met1.modificarVotantes();
        
        }
    private String f;
    
    public void menuprincipal(){
        Scanner scan = new Scanner(System.in);
        int opcion;
        //Lista de opciones para el menu principal 
        System.out.println("1. Menú Principal");
        System.out.println("2. Configuración Inicial del sistema");
        System.out.println("3. Registro de Usuarios");
        System.out.println("4. Registro de Votantes");
        System.out.println("5. Administración de Elecciones");
        System.out.println("6. Ejecución de Elección\n");
        System.out.println("Ingrese una opción");
        opcion = scan.nextInt();
        
        
        //Elegir opcion para menu principal, se utiliza un switch para elegir la opcion que se necesita
        //colocar en cada case el nombre del metodo y cerrar con un break para que se ejecute unicamente el metodo elegido
        switch (opcion) {
            case 1: 
                menuprincipal();
                break;
                
            case 2: 
                configuracionInicial();
                break;
                
            case 3: 
                RegistroDeUsuarios();
                break;
                
            case 4: 
                RegistroDeVotantes();
                break;
                
            case 5: 
                AdministracionElecciones();
                break;
            
        
        
    }
        }
        
    
    
    public void configuracionInicial (){
    
        //Nuevo metodo para configuracion inicial del sistema
        //Se elije un string para la contraseña del usuario administrador
        Scanner scanner = new Scanner(System.in);
        String CONTRASENIA_CORRECTA = "admin1";
        boolean ingresoCorrecto = false;
        //dato boleano para verificar el ingreso correcto o incorrecto al sistema
        
        System.out.println("BIENVENIDO");
        System.out.println("SISTEMA DE VOTACIONES\n");
        
        //utilizado para crear una secuencia
        do {
            System.out.print("Ingrese una contraseña para el usuario administrador: ");
            
        //leer si la contraseña es correcta
        //si es incorrecta vuelve a realizar el procedimiento
        String contrasena = scanner.nextLine();
        if(contrasena.equals(CONTRASENIA_CORRECTA)){
            System.out.println("Contraseña correcta");
            ingresoCorrecto = true;
        } else {
           System.out.println("Contraseña incorrecta, por favor intente de nuevo");}
        
        //retorna nuevamente si la contraseña es incorrecta hasta colocar la contraeña asignada
        } while(!ingresoCorrecto);
        System.out.println("Inicio de sesión exitoso\n");
        
        //ingreso al sistema hacía el menu principal para elegir opcion 
    
    }
    
    
    public void RegistroDeUsuarios(){
        Scanner scan = new Scanner(System.in); 
        int opcion;
        int opcion2; 
        String linea; 
        String correomod;
        String nombre, apellido, correo, contraseña, rol;
        String correoReinicio;
        
        //opciones para elegir en registro de usuarios 
        System.out.println("SISTEMA DE VOTACIONES\n");
        File f = new File("Registro_Usuarios.txt");
        System.out.println("1. Crear usuario del sistema");
        System.out.println("2. Modificar usuario del sistema");
        System.out.println("3. Reiniciar contraseña\n");
        System.out.println("Ingrese una opción:");
        opcion = scan.nextInt();
        
        //elegir otra opcion despues de las primeras
        switch (opcion) {
            
            case 1: {
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
                System.out.print("Ingrese su rol: ");
                rol = scan.nextLine();
                
                String registro = nombre + "|" + apellido + "|" + correo + "|" + contraseña + "|" + rol;
                   

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(registro + "\n");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            File fc = new File("Registro_Usuarios.txt");
            br.close();
            fw.close();
            System.out.println("\nRegistro exitoso.");
        } catch (IOException e) {
            System.out.println("\nError al registrar usuario: " + e.getMessage());
        }
     } 
            break;
            
        case 2:
            //Opcion a modificar usuarios en el sistema
            //Solicitar el correo electronico del usuario a modificar
            System.out.println("Ingrese el correo del usuario que desea modificar");
            correomod = scan.next();
            
            //opciones para elegir opcion de modificar 
            System.out.println("Elija la opción que requiere modificación");
            System.out.println("1. Modificar primer nombre");
            System.out.println("2. Modificar segundo nombre");
            System.out.println("3. Modificar primer apellido");
            System.out.println("4. Modificar segundo apellido");
            System.out.println("5. Modificar correo electronico");
            System.out.println("6. Modificar contraseña");
            System.out.println("7. Deshabilitar del sistema");
            opcion2 = scan.nextInt();
                
            //leer el archivo para buscar el usuario a modificar
            
            File archivoUsuarios = new File("Registro_Usuarios.txt"); 
            File temporal = new File("Modificaciones_RegistroU.txt");
            
            //lectura de archivos para realizar las modificaciones
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temporal))) {
                

                while((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    if(datos[0].equals(correomod)) { 
                        char[] lineaModificada = null;

            // Aquí pedir y modificar dato según opción elegida

                // Escribir línea modificada en temporal
                
                writer.write(lineaModificada); 
                writer.newLine();
                    } else {
            // Si no coincide, escribir línea original en temporal
            
            writer.write(linea);
            writer.newLine();}
                    
  }

            // Renombrar archivos
            archivoUsuarios.delete();
            temporal.renameTo(archivoUsuarios);
            
            } catch (IOException ex) {
                System.out.println(ex);
             System.out.println("Cambios realizados con éxito"); }
            break;
               
        case 3: 
            
            //Opcion reinicio de contraseña 
            //para ello se debe solicitar el correo electronico 
            
            System.out.println("Reinicio de Contraseña");
            System.out.println("Ingrese el correo electronico del usuario");
            correoReinicio = scan.next();
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                
                if (datos[2].compareTo(correoReinicio) == 0) {
                    
                    System.out.println("Ingrese su anterior contraseña");
                    
                    System.out.println("Ingrese su nueva contraseña");
                }

                
              }  
                
            

            
        
    }      
             
}
        
        
    
    
    
    public void RegistroDeVotantes(){
        Scanner scan = new Scanner(System.in);
        int opcion;
      
        //crear archivo para registrar votantes al sistema
        //se elige la opcion según lo que se solicite
        File f = new File ("Registro_votantes.txt");
        System.out.println("REGISTRO DE VOTANTES\n");
        System.out.println("1. Agregar votante");
        System.out.println("2. Modificar votante");
        System.out.println("3. Reiniciar contraseña de votante");
        System.out.println("4. Registrar fallecimiento de votante\n");
        System.out.println("Ingresar opción:");
        opcion = scan.nextInt();
        
        //switch para eleccion de opcion 
        //opcion 1
        //agregar votante al sistema 
        //solicitar los datos correspondientes al registro de votantes
        
        
        switch (opcion) {
            
            
            case 1: {
                registroVot();
                }
          
            //opcion modificar votante
            case 2: {
                modificarVotantes();
            }
            break; 
            
            //opcion a reiniciar la contraseña del votante
            case 3: {
                
            }
            break;
            
            //opcion dar de baja por fallecimiento 
            case 4:{
                
            }
}
          

       }
    
    
    public void registroVot() {
        Scanner scan = new Scanner (System.in); 
        String nombrescomp, apellidoscomp, CUI, sexo, correovot;
        String fechanac, direcres, deptores, munires, paisres;
        int edadvotante;
        String Registro;
        String contrasenia = null;
        
        //pedir edad para verificar si es igual o mayor a 18 años 
        System.out.println("Verificación de edad para registro");
        System.out.println("Ingrese su año de nacimiento");
        edadvotante = scan.nextInt();
        
        
        if(edadvotante >= 18){
            System.out.println("Puede registrarse para votar");
 
        
        } else {
            System.out.println("No cumple requisito de edad para registrarse"); 
}
        
   
        
       // Código para registrar votante
        System.out.println("Agregar votante al sistema\n");
                System.out.println("Ingrese sus nombres completos");
                nombrescomp =scan.next();
                scan.nextLine();
                System.out.println("Ingrese sus apellidos completos");
                apellidoscomp =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su CUI");
                CUI =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su género");
                sexo =scan.next();
                scan.nextLine();
                System.out.println("Ingrese su correo electronico");
                correovot = scan.next();
                System.out.println("Ingrese su fecha de nacimiento");
                fechanac =scan.next();
                System.out.println("Ingrese su dirección de residencia");
                direcres =scan.next();
                System.out.println("Ingrese su municipio de residencia");
                munires =scan.next();
                System.out.println("Ingrese su departamento de residencia");
                deptores =scan.next();
                System.out.println("Ingrese su país de residencia");
                paisres =scan.next();
                
                String registro = nombrescomp + "|" + apellidoscomp + "|" + CUI + "|" + sexo + "|" + correovot + "|" + fechanac + "|" + direcres + "|" + munires + "|" + deptores + "|" +paisres;
                  //leer las variables para registrar datos 
                  
                     
                           
                  
        try {
           

            FileWriter fw = new FileWriter(f);
            fw.write(registro + "\n");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            File fc = new File("Registro_votantes.txt");
            br.close();
            fw.close();
            System.out.println("\nRegistro exitoso.");
        } catch (IOException e) {
            System.out.println("\nError al registrar usuario: " + e.getMessage());
        }
       
        
        
}
         
        
        
    
   
    public void modificarVotantes() {
        Scanner scan = new Scanner (System.in);
        String correovot;
        int opcion;
        String registro, nuevaDireccion;
                
                
        //metodo para modificacion de datos de votantes 
       
        //solicitar el correo de los votantes para para realizar la busqueda y realizar la modificacion 
        System.out.println("Ingrese el correo electronico del votante");
        correovot = scan.next();
        
        //opciones para elegir opcion de modificar 
            System.out.println("Elija la opción que requiere modificación");
            System.out.println("1. Modificar dirección del votante");
            System.out.println("2. Modificar pais de residencia");
            System.out.println("3. Modificar municipio de residencia");
            System.out.println("4. Modificar correo del votante");
            System.out.println("7. Deshabilitar del sistema");
            opcion = scan.nextInt();
        
        // Buscar registro por identificador 
        //metodos con parametros
        
         
        
        if(correovot != null){
            System.out.print("Ingrese la nueva dirección: ");
            nuevaDireccion = scan.nextLine();

      
        
        } else {
            System.out.println("No se encontró votante con ese correo");}
        
        
    }
    
    
    
    
    
    public void AdministracionElecciones() {
        Scanner scan = new Scanner(System.in); 
        String contrasenia = "admin1";
        int opcion;
        String tituEleccion, proposito, descripcion, codigo; 
        
        System.out.println("Ingrese su contraseña de Administrador");
        contrasenia = scan.next();
        
        File f = new File ("Administrador_Elecciones.txt");
        System.out.println("ADMINISTRACIÓN DE ELECCIONES\n");
        System.out.println("1. Gestionar Elecciones");
        System.out.println("2. Gestionar Candidatos");
        System.out.println("3. Configurar opciones de elección\n");
        System.out.println("Ingresar opción:");
        opcion = scan.nextInt();
        
        switch (opcion) {
            case 1: 
                System.out.println("GESTIÓN DE ELECCIONES\n");
                System.out.println("1. Crear elección");
                System.out.println("2. Duración de elección");
                System.out.println("3. Eliminar elección\n");
                System.out.println("Ingresar opción:");
                opcion = scan.nextInt();
                
                }
                
        switch (opcion) {
        
        
            case 1: {
                
                System.out.println("Crear elección");
                System.out.println("Ingrese el titulo de la elección");
                tituEleccion =scan.next();
                System.out.println("Ingrese el propósito de la elección");
                proposito = scan.next();
                System.out.println("Ingrese la descripción de la elección");
                descripcion = scan.next();
                System.out.println("Ingrese el código único de identificación");
                codigo = scan.next();
                
               String gestion = tituEleccion + "|" + proposito + "|" + descripcion + "|" + codigo; 
               
               try {
            FileWriter fw = new FileWriter(f);
                    String administrador = null;
            fw.write(administrador + "\n");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            File fc = new File("Administrador_Elecciones.txt");
            br.close();
            fw.close();
            System.out.println("\nRegistro exitoso.");
        } catch (IOException e) {
            System.out.println("\nError al registrar elección: " + e.getMessage());
        }
     } 
            break;
            
        
            
        
            case 2: {
                System.out.println("");
            }
            
            
            case 3: 
                File original = new File("Administrador_Elecciones.txt");
                File temporal = new File("temp.txt");
                
                try (BufferedReader br = new BufferedReader(new FileReader(original));
                     BufferedWriter bw = new BufferedWriter(new FileWriter(temporal))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split(",");
                        String fecha = partes[0];
                        Object fechaEliminar = null;
                        if (!fecha.equals(fechaEliminar)) {
                            bw.write(linea);
                            bw.newLine();
      }
    }
                    if(original.delete()) {
                        temporal.renameTo(original);
                        System.out.println("Registro eliminado");
                    } else {
                        System.out.println("Error al eliminar registro");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                
            }

    

    
        
        
    
    
}