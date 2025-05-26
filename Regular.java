/**
 * Representa el estado de un jugador que esta en estado regular.
 * En este estado, el jugador puede participar normalmente en el juego.
 */
public class Regular implements EstadoJugador {

    private final Jugador jugador;

    /**
     * Construye el estado Regular para un jugador dado.
     *
     * @param jugador el jugador que asumira el estado regular
     */
    public Regular(Jugador jugador) {
        this.jugador = jugador;
    }
    
    /**
     * Genera el mensaje para el siguiente turno de un jugador regular.
     * Si la opcion es "pregunta", obtiene una tarjeta de preguntas;
     * en caso contrario, obtiene una tarjeta de retos.
     *
     * @param opcion indica si es turno de "pregunta" o "reto"
     * @return mensaje con la instruccion o contenido de la tarjeta
     */
    @Override
    public String turnoSiguiente(String opcion) {
        Tarjeta tarjeta;
        if (opcion.equalsIgnoreCase("pregunta")) {
            tarjeta = jugador.getModel().getTarjetaPreguntas();
        } else {
            tarjeta = jugador.getModel().getTarjetaRetos();
        }
        String mensaje = "Turno de " + jugador.getNombre() + ":\n"
                       + tarjeta.getPregunta();
        return mensaje;
    }

    /**
     * Obtiene la etiqueta de este estado.
     *
     * @return Estado.REGULAR
     */
    @Override
    public Estado getEstado() {
        return Estado.REGULAR;
    }

    /**
     * Maneja la logica cuando el jugador cumple el turno.
     * Incrementa sus puntos.
     */
    @Override
    public void turnoLogrado() {
        jugador.incrementarPuntos();
    }

    /**
     * Maneja la logica cuando el jugador falla el turno.
     * Cambia su estado a castigado.
     */
    @Override
    public void turnoFallido() {
        jugador.setEstadoActual(jugador.getEstadoCastigado());
        jugador.getModel().registrarCastigado(jugador);
    }
}
