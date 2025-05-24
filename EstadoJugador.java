/**
 * Interfaz que representa el comportamiento de estado de un jugador
 */
public interface EstadoJugador {
    /**
     * Se invoca al avanzar un turno.
     *
     * @param jugador El contexto (jugador) sobre el que opera este estado.
     */
    void turnoSiguiente(Jugador jugador);

    /**
     * Devuelve la etiqueta de este estado
     *
     * @return El valor de enum Estado que representa este estado.
     */
    Estado getEstado();
}
