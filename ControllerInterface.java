/**
 * Interfaz que define las acciones del controlador en el patron MVC.
 */
public interface ControllerInterface {

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

    /**
     * Arranca la partida: carga barajas y notifica a los observadores.
     */
    public void iniciarPartida();

    /**
     * Permite a la vista obtener el modelo para registrarse como observer
     * y leer estado.
     *
     * @return la instancia de ModelInterface que usa el controlador.
     */
    public ModelInterface getModel();
}