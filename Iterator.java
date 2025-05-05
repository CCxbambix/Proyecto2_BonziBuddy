/**
 * Interfaz Iterator que permite iterar sobre una coleccion de elementos.
 * @param <T> Tipo de elemento que la interfaz va a iterar.
 */
public interface Iterator<T> {
    /**
     * Indica si hay mas elementos en la coleccion.
     * @return true si hay mas elementos, false en otro caso.
     */
    public boolean hasNext();
    /**
     * Regresa el siguiente elemento de la coleccion.
     * @return El siguiente elemento de la coleccion.
     */
    public T next();
    /**
     * Elimina el ultimo elemento retornado por el metodo next.
     */
    public void remove();
}