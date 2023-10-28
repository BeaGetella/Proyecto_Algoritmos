/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
public class fecha extends fechanac {

    public fecha() {
    }
    
    System.out.println("Verificación de edad");
                System.out.println("Ingrese su fecha de nacimiento");
                fechanac = scan.nextLine();
                
                fechanac formato = new fechanac("dd/MM/yyyy");
                fechanac fechaNac = formato.parse(fechanac);
                
                fechanac fechaActual = new fecha();
                int anios = fechaActual.anioactual() - fechaNac.anioactual();
                
                if(anios < 18) {
                    System.out.println("No cumple requisito de edad mínima");
                } else {

                // Registrar votante
}
