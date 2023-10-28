/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iglesiadecristo
 */
class RegistroUsuarios {
    try {
                        FileReader fr = new FileReader(usuarios);
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("copia_usuarios.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        
                        System.out.println("Bienvenido a la modificacion de usuarios del sistema");
                        System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
                        correoEleUsuario=scan.next();
                        System.out.println(correoEleUsuario);
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            
                            if (datos[4].compareTo(correoEleUsuario) == 0) {
                                linea = "Pedro|Pedro|Perez|Lopez|perezluis@gmail.com|pp12*|null|";
                                System.out.println(linea);
                            }
                            
                            bw.write(linea+"\n");
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), usuarios.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                         System.out.println(ex);
                    } catch (IOException ex) {
                         System.out.println(ex);
                    }
}
