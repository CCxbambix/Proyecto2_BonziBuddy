import java.util.ArrayList;
import java.util.List;

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
     * representa el estado activo del usuario
     */
    private EstadoJugador estadoActivo;

    /**
     * Representa a el estado castigado del usuario
     */
    private EstadoJugador estadoCastigado;

    /**
     * Representa cuantas penalizaciones tiene el jugador por no contestar una pregunta
     */
    private int penalizaciones;

    /**
     * Representa a el mazo de cartas cuando el jugador es activo
     */
    List<Carta> mazoActivo;

    /**
     * Representa a el mazo de cartas cuando el jugador esta castigado
     */
    List<Carta> mazoCastigado;

    /**Metodos de la clase */
    
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
    public EstadoJugador getEstadoActual(){
        return estadoActual;
    }

    /**
     * Regresa el estado activo del jugador.
     * @return El estado activo del jugador.
     */
    public EstadoJugador getEstadoActivo(){
        return estadoActivo;
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
    }

    /**
     * Regresa las penalizaciones del jugador.
     * @return Las penalizaciones del jugador.
     */
    public int getPenalizaciones(){
        return penalizaciones;
    }

    /**
     * Cambia las penalizaciones del jugador.
     * @param penalizaciones El nuevo valor de penalizaciones.
     */
    public void setPenalizaciones(int penalizaciones){
        this.penalizaciones= penalizaciones;
    }
    
    public void incrementarPenalizacion(){
       
    }

    public void resetPenalizacion(){
        
    }

    /**
     * Metodo que no recibe nada y no regresa nada.
     */
    public void actualizar(){
    }
    
    /**
     * Metodo que regresa una pregunta.
     * @return Una pregunta.
     */
    public Pregunta obtenerSiguientePregunta(){
        return null;
    }

    /**
     * Metodo que recibe una respuesta y no regresa nada
     * @param respuesta que da el usuario.
     */
    public void responderPregunta(Respuesta r){
    }

    /**
     * Metodo que no recibe nada y no regresa nada
     */
    public void rechazarPregunta(){
    }

    /**
     * Metodo que no recibe nada y no regresa nada
     */
    public void borrarPregunta(){
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.estadoActivo = new Activo(this);
        this.estadoCastigado = new Castigado(this);
        this.estadoActual = this.estadoActivo;
        this.penalizaciones = 0;
        this.mazoActivo = new ArrayList<>();
        this.mazoCastigado = new ArrayList<>();
    }
    
    

}