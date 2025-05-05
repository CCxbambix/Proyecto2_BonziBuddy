import java.util.NoSuchElementException;
import java.util.List;

/**
 * Esta clase implementa la interfaz Iterator para una lista de Jugador.
 */
public class ListIterator implements Iterator<Tarjeta> {
    /**
     * Posicion actual en la lista.
     */
    private int position;
    /**
     * La lista de Jugador a iterar.
     */
    private List<Jugador> list;

    /**
     * Indica si hay un elemento siguiente en la lista.
     * @return true si hay un elemento siguiente, false de lo contrario.
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * Retorna la siguiente Carta en la lista.
     * @return la siguiente carta.
     * @throws NoSuchElementException si no hay mas elementos en la lista.
     */
    @Override
    public Tarjeta next() {
        return null;
    }

    @Override
    public void remove() {
    }
}