import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para leer preguntas, retos o eventos desde archivos de texto.
 * Proporciona metodos estaticos para cargar diferentes tipos de contenido del juego.
 */
public class LectorPreguntas {

    /**
     * @return Una lista de cadenas con las preguntas.
     */
    public static List<String> getPreguntas() {
        return leerArchivo("preguntas.txt");
    }

    /**
     * Lee los retos (preguntas para castigados) desde el archivo "preguntasCastigado.txt".
     * @return Una lista de cadenas con los retos.
     */
    public static List<String> getRetos() {
        return leerArchivo("retos.txt");
    }

    /**
     * Lee los eventos desde el archivo "eventos.txt".
     * @return Una lista de cadenas con los eventos.
     */
    public static List<String> getEventos() {
        return leerArchivo("eventos.txt");
    }

    /**
     * Lee todas las lineas de un archivo dado.
     * Maneja excepciones de I/O e imprime un mensaje de error si ocurre alguna.
     * @param ruta La ruta del archivo a leer.
     * @return Una lista de cadenas, donde cada cadena es una linea del archivo.
     */
    private static List<String> leerArchivo(String ruta) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer " + ruta + ": " + e.getMessage());
        }
        return lineas;
    }
}