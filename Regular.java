/**
 * Representa el estado de un jugador que esta en estado regular.
 * En este estado, el jugador puede participar normalmente en el juego.
 */
public class Regular implements EstadoJugador {

    /**
     * Maneja el paso del turno para un jugador en estado regular.
     * En este estado, el jugador no tiene una logica especial para el turno en esta implementacion basica.
     * @param jugador El jugador cuyo turno se esta procesando.
     */
    @Override
    public void turnoSiguiente(Jugador jugador) {
       
    }

    /**
     * Obtiene el tipo de estado actual.
     * @return El estado actual, que es REGULAR.
     */
    @Override
    public Estado getEstado() {
        return Estado.REGULAR;
    }
}