/**
 * Interfaz que representa el comportamiento de estado de un jugador
 */
public interface EstadoJugador {

    void turnoSiguiente(String opcion);

    /**
     * Devuelve la etiqueta de este estado
     *
     * @return El valor de enum Estado que representa este estado.
     */
    Estado getEstado();
}
