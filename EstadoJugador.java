/**
 * Interfaz que representa el comportamiento de estado de un jugador
 */
public interface EstadoJugador {

    public String turnoSiguiente(String opcion);

    /**
     * Devuelve la etiqueta de este estado
     *
     * @return El valor de enum Estado que representa este estado.
     */
    public Estado getEstado();

    public void turnoLogrado();

    public void turnoFallido();
}
