/**
 * Interfaz que define las acciones del controlador en el patron MVC.
 */
public interface ControllerInterface {

    /**
     * Refuerza el estado del jugador.
     *
     * @param j El jugador que reforzara su estado.
     */
    public void reforzarEstado(Jugador j);

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