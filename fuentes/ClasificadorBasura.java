import java.io.*;
import java.util.*;

public class ClasificadorBasura {
    public static void main(String[] args) throws IOException {
        String a = "basura.txt";
        String b = "organica.txt";
        String c = "plasticos.txt";
        String d = "general.txt";

        int contO = 0, contP = 0, contG = 0;
        double pesoO = 0, pesoP = 0, pesoG = 0;

        // Leer fichero de entrada
        BufferedReader br = new BufferedReader(new FileReader(a));
        String linea;

        // Crear ficheros de salida
        PrintWriter fwO = new PrintWriter(new FileWriter(b));
        PrintWriter fwP = new PrintWriter(new FileWriter(c));
        PrintWriter fwG = new PrintWriter(new FileWriter(d));

        // Procesar cada línea del fichero
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String codigo = datos[0];
            String descripcion = datos[1];
            double peso = Double.parseDouble(datos[2]);

            switch (codigo) {
                case "O":
                    String fechaCaducidad = datos[3];
                    fwO.println(codigo + "," + descripcion + "," + peso + "," + fechaCaducidad);
                    contO++;
                    pesoO += peso;
                    break;
                case "P":
                    String tipoPlastico = datos[3];
                    fwP.println(codigo + "," + descripcion + "," + peso + "," + tipoPlastico);
                    contP++;
                    pesoP += peso;
                    break;
                case "G":
                    String origen = datos[3];
                    fwG.println(codigo + "," + descripcion + "," + peso + "," + origen);
                    contG++;
                    pesoG += peso;
                    break;
                default:
                    System.out.println("Código de basura desconocido: " + codigo);
            }
        }

        // Cerrar ficheros
        br.close();
        fwO.close();
        fwP.close();
        fwG.close();

        // Informe final
        System.out.println("Informe de clasificación de basura:");
        System.out.println("------------------------------------");
        System.out.println("Orgánica: " + contO + " elementos, " + pesoO + " kg");
        System.out.printf("Plásticos: %d elementos, %.1f kg%n", contP, pesoP);
        System.out.println("General: " + contG + " elementos, " + pesoG + " kg");
        System.out.println("Total: " + (contO + contP + contG) + " elementos, " + (pesoO + pesoP + pesoG) + " kg");
    }
}

