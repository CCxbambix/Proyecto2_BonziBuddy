
/**
 * Clase que representa a un jugador en el juego.
 */

public class Jugador {

    /**Atributos de la clase */

    /**
     * Representa a el nombre del jugador
     */
    private String nombre;

    /**
     * Representa a el estado actual del usuario
     */
    private EstadoJugador estadoActual;

    /**
     * representa el estado regular del usuario
     */
    private EstadoJugador estadoRegular;

    /**
     * Representa a el estado castigado del usuario
     */
    private EstadoJugador estadoCastigado;

    /**
     * Representa los turnos que el usuario esta castigado
     */
    private int turnosCastigado;

    private Estado estado;
    
    private ModelInterface model;

    /**
     * Metodo constructor de la clase
     * @param String con valor del nombre del jugador
     */
    public Jugador(String nombre, ModelInterface model) {
        this.nombre = nombre;
        this.estadoRegular = new Regular(this);
        this.estadoCastigado = new Castigado(this);
        this.estadoActual = this.estadoRegular;
        estado = Estado.REGULAR;
        this.model = model;
    }

    /**
     * Regresa el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Regresa el estado actual del jugador.
     * @return El estado actual del jugador.
     */
    public Estado getEstado(){
        return estado;
    }

    public ModelInterface getModel(){
        return model;
    }

    /**
     * Regresa el estado activo del jugador.
     * @return El estado activo del jugador.
     */
    public EstadoJugador getEstadoActivo(){
        return estadoRegular;
    }

    /**
     * Regresa el estado castigado del jugador.
     * @return El estado castigado del jugador.
     */
    public EstadoJugador getEstadoCastigado(){
        return estadoCastigado;
    }

    /**
     * Cambia el estado actual del jugador.
     * @param estadoJugador El nuevo estado del jugador.
     */
    public void setEstadoActual(EstadoJugador estadoJugador){
        this.estadoActual = estadoJugador;
        this.estado = estadoJugador.getEstado();
    }

    /**
     * Regresa los turnos que el jugador lleva castigados
     * @return int con valor de los turnos que el jugador lleva castigado
     */
    public int getTurnosCastigado(){
        return turnosCastigado;
    }

    public void actualizar(){
    }

    public void turnoSiguiente(){
        estadoActual.turnoSiguiente();
    }
}