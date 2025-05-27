/**
 * Representa el comportamiento de estado de un jugador.
 */
public interface EstadoJugador {

    /**
     * Genera el mensaje para el siguiente turno del jugador
     * en funcion de la opcion indicada.
     *
     * @param opcion la opcion del turno (por ejemplo "pregunta" o "reto")
     * @return mensaje con las instrucciones o contenido del turno
     */
    public String turnoSiguiente(String opcion);

    /**
     * Devuelve la etiqueta de este estado.
     *
     * @return el valor del enum Estado que identifica este estado
     */
    public Estado getEstado();

    /**
     * Maneja la logica cuando el jugador cumple el objetivo del turno.
     * Por ejemplo, incrementar puntos o avanzar estado.
     */
    public void turnoLogrado();

    /**
     * Maneja la logica cuando el jugador falla el objetivo del turno.
     * Por ejemplo, resetear contadores o cambiar estado.
     */
    public void turnoFallido();
}
