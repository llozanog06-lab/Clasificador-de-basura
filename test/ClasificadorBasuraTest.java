import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ClasificadorBasuraTest {

    private final String inputFile = "basura.txt";
    private final String organicaFile = "organica.txt";
    private final String plasticosFile = "plasticos.txt";
    private final String generalFile = "general.txt";

    @BeforeEach
    public void setUp() throws IOException {
        // Crear el fichero de entrada para el test
        String[] lines = {
            "O,Restos de comida,0.5,2026-03-14",
            "P,Botella de agua,0.2,PET",
            "G,Papel de regalo,0.1,Casa",
            "O,Cáscaras de fruta,0.3,2026-03-15",
            "P,Bolsa de supermercado,0.1,HDPE",
            "G,Lata de refresco,0.4,Calle"
        };
        //Files.write(Path.of(inputFile), List.of(lines));
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Borrar los ficheros generados después del test
        //Files.deleteIfExists(Path.of(inputFile));
        Files.deleteIfExists(Path.of(organicaFile));
        Files.deleteIfExists(Path.of(plasticosFile));
        Files.deleteIfExists(Path.of(generalFile));
    }

    @Test
    public void testClasificadorBasura() throws IOException {
        // Redirigir la salida estándar para capturar el informe
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutar el programa
        ClasificadorBasura.main(new String[0]);

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Leer los ficheros de salida
        List<String> organicaLines = Files.readAllLines(Path.of(organicaFile));
        List<String> plasticosLines = Files.readAllLines(Path.of(plasticosFile));
        List<String> generalLines = Files.readAllLines(Path.of(generalFile));

        // Comprobar el contenido de los ficheros de salida
        assertEquals(2, organicaLines.size());
        assertEquals(2, plasticosLines.size());
        assertEquals(2, generalLines.size());

        // Comprobar el informe generado
        String informe = outputStream.toString();
        assertTrue(informe.contains("Orgánica: 2 elementos, 0.8 kg"));
        assertTrue(informe.contains("Plásticos: 2 elementos, 0,3 kg"));
        assertTrue(informe.contains("General: 2 elementos, 0.5 kg"));
        assertTrue(informe.contains("Total: 6 elementos, 1.6 kg"));
    }
}

