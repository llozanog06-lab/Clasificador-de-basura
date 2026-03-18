import java.io.*;
import java.util.*;

public class ClasificadorBasura {
    public static void main(String[] args) throws IOException {
        String basura = "basura.txt";
        String organico = "organica.txt";
        String plasticos = "plasticos.txt";
        String general = "general.txt";

        Integer contadorOrganico = 0, contadorPlastico = 0, contadorGeneral = 0;
        double pesoOrganico = 0, pesoPlastico = 0, pesoGeneral = 0;

        // Leer fichero de entrada
        BufferedReader br = new BufferedReader(new FileReader(basura));
        String linea;

        // Crear ficheros de salida
        PrintWriter ficheroOrganico = new PrintWriter(new FileWriter(organico));
        PrintWriter ficheroPlastico = new PrintWriter(new FileWriter(plasticos));
        PrintWriter ficheroGeneral = new PrintWriter(new FileWriter(general));

        // Procesar cada línea del fichero
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String codigo = datos[0];
            String descripcion = datos[1];
            Double peso = Double.parseDouble(datos[2]);

            switch (codigo) {
                case "O":
                    String fechaCaducidad = datos[3];
                    ficheroOrganico.println(codigo + "," + descripcion + "," + peso + "," + fechaCaducidad);
                    contadorOrganico++;
                    pesoOrganico += peso;
                    break;
                case "P":
                    String tipoPlastico = datos[3];
                    ficheroPlastico.println(codigo + "," + descripcion + "," + peso + "," + tipoPlastico);
                    contadorPlastico++;
                    pesoPlastico += peso;
                    break;
                case "G":
                    String origen = datos[3];
                    ficheroGeneral.println(codigo + "," + descripcion + "," + peso + "," + origen);
                    contadorGeneral++;
                    pesoGeneral += peso;
                    break;
                default:
                    System.out.println("Código de basura desconocido: " + codigo);
            }
        }

        // Cerrar ficheros
        br.close();
        ficheroOrganico.close();
        ficheroPlastico.close();
        ficheroGeneral.close();

        // Informe final
        System.out.println("Informe de clasificación de basura:");
        System.out.println("------------------------------------");
        System.out.println("Orgánica: " + contadorOrganico + " elementos, " + pesoOrganico + " kg");
        System.out.printf("Plásticos: %d elementos, %.1f kg%n", contadorPlastico, pesoPlastico);
        System.out.println("General: " + contadorGeneral + " elementos, " + pesoGeneral + " kg");
        System.out.println("Total: " + (contadorOrganico + contadorPlastico + contadorGeneral) + " elementos, " + (pesoOrganico + pesoPlastico + pesoGeneral) + " kg");
    }
}