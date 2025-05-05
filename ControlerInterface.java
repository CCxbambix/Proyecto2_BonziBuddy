/**
 * Interfaz que define las acciones del controlador en el patron MVC.
 */
public interface ControlerInterface {

    /**
     * Procesa la respuesta de un jugador.
     *
     * @param j El jugador que respondio.
     * @param r La respuesta del jugador.
     */
    void procesadorRespuesta(Jugador j, Respuesta r);

    /**
     * Pasa el turno al siguiente jugador.
     */
    void pasarTurno();

    /**
     * Refuerza el estado del jugador.
     *
     * @param j El jugador que reforzara su estado.
     */
    void reforzarEstado(Jugador j);
}