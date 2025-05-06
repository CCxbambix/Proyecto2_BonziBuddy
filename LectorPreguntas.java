
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorPreguntas {

    ArrayList<String> preguntas = new ArrayList<>();

    public LectorPreguntas() {
        try {
            // Crea un BufferedReader para leer el archivo preguntas.txt
            BufferedReader br = new BufferedReader(new FileReader("preguntas.txt"));
            String linea;
            // Lee cada línea del archivo y la agrega a la lista de preguntas
            while ((linea = br.readLine()) != null) {
                preguntas.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    public ArrayList<String> getPreguntas() {
        return preguntas;
    }
}