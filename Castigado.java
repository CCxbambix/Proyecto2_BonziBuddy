/**
 * Representa el estado de un jugador que esta castigado.
 * En este estado, el jugador no puede avanzar por un numero determinado de turnos.
 */
public class Castigado implements EstadoJugador {
    private int turnosCastigado;
    private final Jugador jugador;

    /**
     * Constructor de la clase Castigado.
     * Inicializa el estado castigado del jugador.
     * @param jugador El jugador que tiene este estado.
     */
    public Castigado(Jugador jugador) {
        this.jugador = jugador;
        turnosCastigado = 0;
    }
    
    /**
     * Maneja el paso del turno para un jugador en estado castigado.
     * Decrementa los turnos de castigo del jugador.
     * Si los turnos de castigo llegan a cero o menos, cambia el estado del jugador a regular.
     */
    @Override
    public String turnoSiguiente(String opcion) {
        Tarjeta reto = jugador.getModel().getTarjetaRetos();
        Tarjeta pregunta = jugador.getModel().getTarjetaPreguntas();
        String mensaje = "Turno de " + jugador.getNombre() + " :\n" +
                         "Debes responder la pregunta: " + pregunta.getPregunta() + "\n" +
                         "Y completar el reto: " + reto.getPregunta();
        return mensaje;
    }

    /**
     * Obtiene el tipo de estado actual.
     * @return El estado actual, que es CASTIGADO.
     */
    @Override
    public Estado getEstado() {
        return Estado.CASTIGADO;
    }
    
    @Override
    public  void turnoLogrado(){
        jugador.incrementarPuntos();
        turnosCastigado++;
        if (turnosCastigado >= 2) {
            jugador.setEstadoActual(jugador.getEstadoRegular());
        }
    }

    @Override
    public void turnoFallido() {
        turnosCastigado = 0;
    }
}