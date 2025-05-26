/**
 * Representa a un jugador en el juego.
 * Implementa Observador para recibir notificaciones del modelo.
 * Gestiona su estado (regular o castigado) y su interaccion con el modelo.
 */
public class Jugador implements Observador {
    private final String nombre;
    private final EstadoJugador estadoRegular;
    private final EstadoJugador estadoCastigado;
    private EstadoJugador estadoActual;
    private int puntos;
    private ModelInterface model;

    /**
     * Construye un jugador con nombre y modelo asociados.
     * Inicializa los estados regular y castigado, y fija el estado inicial a regular.
     *
     * @param nombre el nombre del jugador
     * @param model  la instancia del modelo con la que interactuara
     */
    public Jugador(String nombre, ModelInterface model) {
        this.nombre = nombre;
        this.model = model;
        this.estadoRegular = new Regular(this);
        this.estadoCastigado = new Castigado(this);
        this.estadoActual = estadoRegular;
        this.puntos = 0;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el estado actual del jugador.
     *
     * @return el valor de enum Estado que representa el estado actual
     */
    public Estado getEstado() {
        return estadoActual.getEstado();
    }

    /**
     * Obtiene la instancia de EstadoJugador para el estado regular.
     *
     * @return objeto EstadoJugador que representa el estado regular
     */
    public EstadoJugador getEstadoRegular() {
        return estadoRegular;
    }

    /**
     * Obtiene la instancia de EstadoJugador para el estado castigado.
     *
     * @return objeto EstadoJugador que representa el estado castigado
     */
    public EstadoJugador getEstadoCastigado() {
        return estadoCastigado;
    }

    /**
     * Establece un nuevo estado actual para el jugador.
     *
     * @param nuevo el nuevo estado del jugador
     */
    public void setEstadoActual(EstadoJugador nuevo) {
        this.estadoActual = nuevo;
    }

    /**
     * Obtiene los puntos acumulados del jugador.
     *
     * @return el numero de puntos del jugador
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece la cantidad de puntos del jugador.
     *
     * @param puntos el nuevo valor de puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Incrementa en uno los puntos actuales del jugador.
     */
    public void incrementarPuntos() {
        this.puntos++;
    }

    /**
     * Obtiene la instancia del modelo asociada al jugador.
     *
     * @return la instancia del modelo
     */
    public ModelInterface getModel() {
        return model;
    }

    /**
     * Metodo invocado por el modelo al emitir una notificacion.
     * Muestra en la vista un mensaje indicando el evento actual.
     */
    @Override
    public void actualizar() {
        Controller controller = (Controller) model.getController();
        controller.getVista().mostrarMensaje("Jugador " + nombre + " " + model.getEventoActual());
    }

    /**
     * Procesa el siguiente turno segun el estado actual del jugador.
     *
     * @param opcion la opcion de turno ("pregunta" o "reto")
     * @return el mensaje generado para el turno
     */
    public String turnoSiguiente(String opcion) {
        return estadoActual.turnoSiguiente(opcion);
    }

    /**
     * Notifica al estado actual que el turno fue logrado.
     */
    public void turnoLogrado() {
        estadoActual.turnoLogrado();
    }

    /**
     * Notifica al estado actual que el turno fue fallido.
     */
    public void turnoFallido() {
        estadoActual.turnoFallido();
    }
}
