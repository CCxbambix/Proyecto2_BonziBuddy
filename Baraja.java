import java.util.List;
import java.util.Random;

/**
 * Representa una baraja de tarjetas con preguntas para el juego.
 */
public class Baraja {
    private final Tarjeta[] tarjetas;
    private int indexActual = 0;

    /**
     * Constructor de la Baraja.
     * Inicializa la baraja con una lista de preguntas y las clona en objetos Tarjeta.
     * Luego, revuelve la baraja.
     * @param preguntas Una lista de cadenas que representan las preguntas para las tarjetas.
     * @throws IllegalArgumentException Si la lista de preguntas es nula o esta vacia.
     */
    public Baraja(List<String> preguntas) {
        if (preguntas == null || preguntas.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacia");
        }
        int n = preguntas.size();
        this.tarjetas = new Tarjeta[n];
        // inicializa y clona correctamente usando el constructor de copia
        for (int i = 0; i < n; i++) {
            Tarjeta base = new Tarjeta();
            base.setPregunta(preguntas.get(i));
            this.tarjetas[i] = base.clone();
        }
        revolverBaraja();
    }

    /**
     * Revuelve el orden de las tarjetas en la baraja de forma aleatoria.
     */
    private void revolverBaraja() {
        Random rnd = new Random();
        for (int i = 0; i < tarjetas.length; i++) {
            int j = rnd.nextInt(tarjetas.length);
            Tarjeta tmp = tarjetas[i];
            tarjetas[i] = tarjetas[j];
            tarjetas[j] = tmp;
        }
    }

    /**
     * Obtiene la siguiente tarjeta de la baraja.
     * Avanza el indice interno a la siguiente tarjeta.
     * @return La siguiente tarjeta en la baraja, o null si no hay mas tarjetas.
     */
    public Tarjeta getSiguienteTarjeta() {
        if (indexActual >= tarjetas.length) {
            return null;
        }
        return tarjetas[indexActual++];
    }

    /**
     * Obtiene el numero total de tarjetas en la baraja.
     * @return El tamano de la baraja.
     */
    public int getSize() {
        return tarjetas.length;
    }

    /**
     * Obtiene el indice de la tarjeta actual en la baraja.
     * @return El indice actual de la tarjeta.
     */
    public int getIndex() {
        return indexActual;
    }
}