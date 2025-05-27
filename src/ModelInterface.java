/**
 * Interfaz que define las operaciones del Modelo en el patron MVC,
 * extendiendo la funcionalidad de Sujeto en el patron Observer.
 */
public interface ModelInterface extends Sujeto {

    /**
     * Inicializa la partida cargando los recursos necesarios (barajas, etc.)
     * y asignando el controlador que gestionara el flujo de juego.
     *
     * @param controller la instancia del controlador que iniciara la partida
     */
    public void iniciarPartida(ControllerInterface controller);

    /**
     * Obtiene la siguiente tarjeta de la baraja de retos.
     *
     * @return la siguiente Tarjeta de retos
     */
    public Tarjeta getTarjetaRetos();

    /**
     * Obtiene la siguiente tarjeta de la baraja de eventos.
     *
     * @return la siguiente Tarjeta de eventos
     */
    public Tarjeta getTarjetaEventos();

    /**
     * Obtiene la siguiente tarjeta de la baraja de preguntas.
     *
     * @return la siguiente Tarjeta de preguntas
     */
    public Tarjeta getTarjetaPreguntas();

    /**
     * Obtiene el siguiente jugador en el turno, rotando la cola interna.
     *
     * @return el siguiente Jugador en la secuencia de turnos
     */
    public Jugador obtenerSiguienteJugador();

    /**
     * Devuelve el total de jugadores registrados en el modelo.
     *
     * @return el numero total de jugadores
     */
    public int getTotalJugadores();

    /**
     * Obtiene el controlador asociado al modelo.
     *
     * @return la instancia del controlador
     */
    public ControllerInterface getController();

    /**
     * Obtiene la descripcion del evento actual.
     *
     * @return la cadena que describe el evento actual
     */
    public String getEventoActual();

    /**
     * Selecciona y almacena la siguiente tarjeta de la baraja de eventos
     * como evento actual.
     */
    public void setEventoActual();

    /**
     * Incrementa en uno los puntos de todos los jugadores en estado castigado.
     */
    public void incrementarPuntosCastigado();

    /**
     * Incrementa en uno los puntos de todos los jugadores en estado regular.
     */
    public void incrementarPuntosRegular();

    /**
     * Incrementa en uno los puntos de todos los jugadores.
     */
    public void incrementarPuntosTodos();
}
