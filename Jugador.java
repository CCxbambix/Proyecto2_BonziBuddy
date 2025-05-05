import java.util.List;
/**
 * Clase que representa a un jugador en el juego
 */
public class Jugador {

    /**Atributos de la clase */

    /**Representa a el nombre del jugador */
    private String nombre;

    /**Representa a el estado actual del usuario */
    private EstadoJugador estadoActual;

    /**representa el estado activo del usuario */
    private EstadoJugador estadoActivo;

    /**Representa a el estado castigado del usuario */
    private EstadoJugador estadoCastigado;

    /**Representa cuantas penalizaciones tiene el jugador por no contestar una pregunta */
    private int penalizaciones;

    /**Representa a el mazo de cartas cuando el jugador es activo */
    List<Carta> mazoActivo;

    /**Representa a el mazo de cartas cuando el jugador esta castigado */
    List<Carta> mazoCastigado;

    /**Metodos de la clase */

    /**
     * Metodo que regresa el nombre del usuario
     * @return Strin con valor a el nombre del jugador
     */
    public String getNombre(){
        return nombre;
    }


    public EstadoJugador getEstadoJugador(){
        return estadoActual;
    }

    public EstadoJugador getEstadoActivo(){
        return estadoActivo;
    }

    public EstadoJugador getEstadoCastigado(){
        return estadoCastigado;
    }

    /**
     * Metodo que regresa las penalizaciones del jugador
     * @return int con valor a las penalizaciones que tiene el jugador
     */
    public int getPenalizaciones(){
        return penalizaciones;
    }

    /**
     * Metodo que cambia las penalizaciones del jugador
     * @param int con valor a el nuevo valor de las penalizaciones 
     */
    public void setPenalizaciones(int penalizaciones){
        this.penalizaciones= penalizaciones;
    }

    /**
     * Metodo que incrementa 1 las penalizaciones del jugador 
     */
    public void incrementarPenalizacion(){
     setPenalizaciones(getPenalizaciones()++);
    }

    /**
     * Metodo que pone en 0 las penalizaciones del jugador
     */
    public void resetPenalizaciones(){
        setPenalizaciones(0);
    }

}