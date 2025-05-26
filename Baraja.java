import java.util.List;
import java.util.Random;

/**
 * Representa una baraja de tarjetas con preguntas para el juego
 */
public class Baraja {
    private final Tarjeta[] tarjetas;
    private int indexActual = 0;

    /**
     * Construye una nueva baraja a partir de una lista de preguntas.
     * Cada pregunta se copia en un objeto Tarjeta mediante el constructor de copia,
     * y luego se revuelve el orden de las tarjetas.
     *
     * @param preguntas lista de cadenas que representan las preguntas para las tarjetas
     * @throws IllegalArgumentException si la lista de preguntas es nula o esta vacia
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
     * Obtiene la siguiente tarjeta de la baraja y avanza el indice interno.
     * Si se han agotado las tarjetas, reinicia el indice y vuelve a revolver.
     *
     * @return la siguiente tarjeta en la baraja
     */
    public Tarjeta getSiguienteTarjeta() {
        if (indexActual >= tarjetas.length) {
            indexActual = 0; // reinicia el indice si se han agotado las tarjetas
            revolverBaraja();
        }
        return tarjetas[indexActual++];
    }

    /**
     * Obtiene una tarjeta al azar de la baraja sin modificar el orden ni el indice actual.
     *
     * @return una tarjeta seleccionada aleatoriamente
     */
    public Tarjeta getTarjetaRandom() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(tarjetas.length);
        return tarjetas[randomIndex];
    }

    /**
     * Obtiene el numero total de tarjetas en la baraja.
     *
     * @return el tamano de la baraja
     */
    public int getSize() {
        return tarjetas.length;
    }

    /**
     * Obtiene el indice de la siguiente tarjeta que se devolvera.
     *
     * @return el indice actual en la baraja
     */
    public int getIndex() {
        return indexActual;
    }
}
