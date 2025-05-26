/**
 * Representa el estado de un jugador que esta castigado.
 */
public class Castigado implements EstadoJugador {
    private int turnosCastigado;
    private final Jugador jugador;

    /**
     * Construye el estado Castigado para un jugador dado.
     * Inicializa el contador de turnos de castigo en cero.
     *
     * @param jugador el jugador que sera castigado
     */
    public Castigado(Jugador jugador) {
        this.jugador = jugador;
        this.turnosCastigado = 0;
    }
    
    /**
     * Genera el mensaje para el siguiente turno de un jugador castigado.
     * Presenta la pregunta y el reto actuales del jugador.
     *
     * @param opcion opcion seleccionada por el jugador
     * @return mensaje con la pregunta y el reto que debe completar el jugador
     */
    @Override
    public String turnoSiguiente(String opcion) {
        Tarjeta reto     = jugador.getModel().getTarjetaRetos();
        Tarjeta pregunta = jugador.getModel().getTarjetaPreguntas();
        String mensaje = "Turno de " + jugador.getNombre() + " :\n"
                       + "Debes responder la pregunta: " + pregunta.getPregunta() + "\n"
                       + "Y completar el reto: "      + reto.getPregunta();
        return mensaje;
    }

    /**
     * Obtiene el tipo de estado actual del jugador.
     *
     * @return Estado.CASTIGADO
     */
    @Override
    public Estado getEstado() {
        return Estado.CASTIGADO;
    }
    
    /**
     * Maneja la logica cuando el jugador cumple el reto del turno.
     * Incrementa puntos del jugador y aumenta el contador de turnos de castigo.
     */
    @Override
    public void turnoLogrado() {
        jugador.incrementarPuntos();
        turnosCastigado++;
        if (turnosCastigado >= 2) {
            jugador.setEstadoActual(jugador.getEstadoRegular());
        }
    }

    /**
     * Maneja la logica cuando el jugador falla el reto del turno.
     * Reinicia el contador de turnos de castigo para empezar de nuevo.
     */
    @Override
    public void turnoFallido() {
        turnosCastigado = 0;
    }
}
