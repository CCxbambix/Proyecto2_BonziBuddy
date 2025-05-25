/**
 * Representa a un jugador en el juego.
 * Implementa la interfaz Observador para ser notificado por el modelo.
 * Maneja su estado actual (regular o castigado) y su interaccion con el modelo.
 */
public class Jugador implements Observador {
    private final String nombre;
    private final EstadoJugador estadoRegular;
    private final EstadoJugador estadoCastigado;
    private EstadoJugador estadoActual;

    /**
     * Representa los puntos del jugador 
     */
    private int puntos;    
    private ModelInterface model;

    /**
     * Constructor de la clase Jugador.
     * Inicializa al jugador con su nombre, el modelo asociado y sus estados iniciales.
     * Se registra automaticamente en el modelo al ser creado.
     * @param nombre El nombre del jugador.
     * @param model La instancia del modelo con la que interactuara el jugador.
     */
    public Jugador(String nombre, ModelInterface model) {
        this.nombre = nombre;
        this.model = model;
        this.estadoRegular = new Regular(this);
        this.estadoCastigado = new Castigado(this);
        this.estadoActual = estadoRegular;
    }

    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el estado actual del jugador (REGULAR o CASTIGADO).
     * @return El estado actual del jugador.
     */
    public Estado getEstado() {
        return estadoActual.getEstado();
    }

    /**
     * Establece el estado actual del jugador.
     * @param nuevo El nuevo estado del jugador.
     */
    public void setEstadoActual(EstadoJugador nuevo) {
        this.estadoActual = nuevo;
    }

    /**
     * Obtiene la instancia del estado Regular.
     * @return La instancia de EstadoJugador para el estado Regular.
     */
    public EstadoJugador getEstadoActivo() {
        return estadoRegular;
    }

    /**
     * Obtiene la instancia del estado Castigado.
     * @return La instancia de EstadoJugador para el estado Castigado.
     */
    public EstadoJugador getEstadoCastigado() {
        return estadoCastigado;
    }

    /**
     * Obtiene la instancia del modelo asociada a este jugador.
     * @return La instancia del modelo.
     */
    public ModelInterface getModel() {
        return model;
    }

    /**
     * Metodo de actualizacion llamado por el modelo cuando cambia su estado.
     * Implementa la logica de vista al recibir la notificacion.
     */
    @Override
    public void actualizar() {
        // logica de vista al recibir notificacion del modelo
        System.out.println("[" + nombre + "] modelo actualizado: estado=" + getEstado());
    }

    /**
     * Procesa el siguiente turno para el jugador basandose en su estado actual.
     */
    public void turnoSiguiente(String opcion) {
        estadoActual.turnoSiguiente(opcion);
    }

    /**
     * Devuelve los puntos que tiene el jugador 
     * @return int con valor de los puntos que tiene el jugador
     */
    public int getPuntos(){
        return puntos;
    }

    /**
     * Metodo que cambia el valor de los puntos del jugador 
     * @param int con valor a los nuevos puntos del jugador
     */
    public void setPuntos(int puntos){
        this.puntos= puntos;
    }

    /**
     * Metodo que incrementa 1 los puntos actuales del jugador 
     */
    public void incrementarPuntos(){
        int puntosJugador = getPuntos();
        puntosJugador++;
        setPuntos(puntosJugador);
    }

}