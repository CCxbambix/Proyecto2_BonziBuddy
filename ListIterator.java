import java.util.List;

/**
 * Esta clase implementa la interfaz Iterator para una lista de Jugador.
 */
public class ListIterator implements Iterator<Jugador> {
    /**
     * Posicion actual en la lista.
     */
    private int position;
    /**
     * La lista de Jugador sobre la que se va a iterar.
     */
    private List<Jugador> list;

    public ListIterator(List<Jugador> list) {
        this.list = list;
        this.position = 0;
    }

    /**
     * Verifica si hay un elemento siguiente en la lista.
     *
     * @return true si hay un elemento siguiente, false de lo contrario.
     */
    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    /**
     * Obtiene el siguiente elemento Jugador de la lista.
     *
     * @return El siguiente Jugador en la lista, o null si no hay mas elementos.
     */
    @Override
    public Jugador next() {
        if(position >= list.size()) return null;
        return list.get(position++);
    }

    @Override
    public void remove() {
    }
}