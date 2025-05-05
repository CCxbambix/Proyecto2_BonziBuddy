import java.util.Tarjeta;
import java.util.Queue;

/**
 * Clase que implementa la interfaz Iterator para una cola de Cartas.
 */
public class QueueIterator implements Iterator<Tarjeta> {
    /**
     * Cola de cartas que se van a iterar.
     */
    private Queue<Tarjeta> queue;

    /**
     * Verifica si hay una siguiente carta en la cola.
     * @return true si hay una siguiente carta, false si no.
     */
    public boolean hasNext() {
        return false;
    }

    /**
     * Retorna la siguiente carta en la cola.
     * @return La siguiente carta en la cola.
     */
    public Tarjeta next() {
        return null;
    }

    /**
     * Remueve la ultima carta retornada por next().
     */
    public void remove() {
    }
}