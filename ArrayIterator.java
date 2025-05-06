import java.util.Iterator;

/**
 * Clase que permite iterar sobre un arreglo de cartas.
 */
public class ArrayIterator implements Iterator<Tarjeta> {
    /**
     * Indice actual del arreglo
     */
    private int index;
    /**
     * Arreglo de cartas a iterar
     */
    private Carta[] array;

    /**
     * Indica si hay una siguiente carta en el arreglo.
     *
     * @return true si hay una siguiente carta, false de lo contrario.
     */
    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    /**
     * Regresa la siguiente carta en el arreglo.
     *
     * @return La siguiente carta.
     */
    @Override
    public Tarjeta next() {
        if (index >= array.length) {
            return null;
        }
        Tarjeta carta = array[index];
        index++;
        return carta;
    }

    /**
     * Remueve la carta actual del arreglo.
     * No implementada en esta version.
     */
    public void remove() {
    }
}