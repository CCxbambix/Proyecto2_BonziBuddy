
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorPreguntas {

    public static ArrayList<String> preguntasRegular() {
        return preguntas("preguntasRegular.txt");
    }

    public static ArrayList<String> preguntasCastigado() {
        return preguntas("preguntasCastigado.txt");
    }

    public static ArrayList<String> eventos() {
        return preguntas("eventos.txt");
    }

    private static ArrayList<String> preguntas(String archivo){
        ArrayList<String> preguntas = new ArrayList<>();

        try {
            // Crea un BufferedReader para leer el archivo preguntas.txt
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            // Lee cada línea del archivo y la agrega a la lista de preguntas
            while ((linea = br.readLine()) != null) {
                preguntas.add(linea);
                return preguntas;
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }
}