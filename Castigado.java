/**
 * Representa el estado de un jugador que esta castigado.
 * En este estado, el jugador no puede avanzar por un numero determinado de turnos.
 */
public class Castigado implements EstadoJugador {
    private static final int TURNOS_PENA = 2;

    /**
     * Maneja el paso del turno para un jugador en estado castigado.
     * Decrementa los turnos de castigo del jugador.
     * Si los turnos de castigo llegan a cero o menos, cambia el estado del jugador a regular.
     * @param jugador El jugador cuyo turno se esta procesando.
     */
    @Override
    public void turnoSiguiente(Jugador jugador) {
        // Decrementa su cuenta de turnos castigado
        jugador.decrementarTurnosCastigado();
        // Si ya cumplio la pena, vuelve a regular
        if (jugador.getTurnosCastigado() <= 0) {
            jugador.setEstadoActual(jugador.getEstadoActivo());
            // Notifica a los regulares de que el grupo cambio
            jugador.getModel().notificarRegulares();
        }
    }

    /**
     * Obtiene el tipo de estado actual.
     * @return El estado actual, que es CASTIGADO.
     */
    @Override
    public Estado getEstado() {
        return Estado.CASTIGADO;
    }
}