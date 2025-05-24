/**
 * Interfaz que define las operaciones del Modelo en el patron MVC, extendiendo la funcionalidad de Sujeto en el patron Observer.
 * Representa la interfaz publica del modelo para que el Controlador y otras partes del sistema interactuen con el.
 */
public interface ModelInterface extends Sujeto {
    /**
     * Inicializa la partida cargando los recursos necesarios (barajas, etc.).
     */
    public void iniciarPartida();
    /**
     * Obtiene la siguiente tarjeta de la baraja de retos.
     * @return La siguiente Tarjeta de retos.
     */
    public Tarjeta getTarjetaRetos();
    /**
     * Obtiene la siguiente tarjeta de la baraja de eventos.
     * @return La siguiente Tarjeta de eventos.
     */
    public Tarjeta getTarjetaEventos();
    /**
     * Obtiene la siguiente tarjeta de la baraja de preguntas.
     * @return La siguiente Tarjeta de preguntas.
     */
    public Tarjeta getTarjetaPreguntas();
    /**
     * Obtiene el siguiente jugador en el turno.
     * @return El siguiente Jugador.
     */
    public Jugador obtenerSiguienteJugador();
}
