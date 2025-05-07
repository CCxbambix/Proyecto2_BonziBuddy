
import java.util.ArrayList;
/**
 * Clase que representa una baraja regular de tarjetas.
 */
public class Baraja {
    Tarjeta[] tarjetas;

    public void setBaraja(ArrayList<String> preguntas) {
        startBaraja(preguntas);
        revolverBaraja();
    }

    public void startBaraja(ArrayList<String> preguntas) {
        if (preguntas == null || preguntas.isEmpty()) {
            throw new IllegalArgumentException("La lista de preguntas no puede estar vacía.");
        }
        
        // Inicializa la baraja con el tamaño de las preguntas
        this.tarjetas = new Tarjeta[preguntas.size()];

        tarjetas[0] = new Tarjeta();
        tarjetas[0].setPregunta(preguntas.get(0));

        // Crea una tarjeta para cada pregunta y la agrega a la baraja
        for (int i = 1; i < preguntas.size(); i++) {
            Tarjeta tarjeta = tarjetas[0].clone();
            tarjeta.setPregunta(preguntas.get(i));
            this.tarjetas[i] = tarjeta;
        }
    }

    public void revolverBaraja() {
        // Baraja las tarjetas de la baraja
        for (int i = 0; i < tarjetas.length; i++) {
            int randomIndex = (int) (Math.random() * tarjetas.length);
            Tarjeta temp = tarjetas[i];
            tarjetas[i] = tarjetas[randomIndex];
            tarjetas[randomIndex] = temp;
        }
    }
}