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
     * representa el estado regular del usuario
     */
    private EstadoJugador estadoRegular;

    /**
     * Representa a el estado castigado del usuario
     */
    private EstadoJugador estadoCastigado;

    /**
     * Representa cuantas penalizaciones tiene el jugador por no contestar una pregunta
     */
    private int penalizaciones;

    /**
     * Representa los turnos que el usuario esta castigado
     */
    private int turnosCastigado;

    /**
     * Representa a el mazo de cartas cuando el jugador es activo
     */
    List<Tarjeta> barajaRegular;

    /**
     * Representa a el mazo de cartas cuando el jugador esta castigado
     */
    List<Tarjeta> barajaCastigado;

    /**Metodos de la clase */
    
    /**
     * Metodo constructor de la clase
     * @param String con valor del nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.estadoRegular = new Regular(this);
        this.estadoCastigado = new Castigado(this);
        this.estadoActual = this.estadoRegular;
        this.penalizaciones = 0;
        this.barajaRegular = new ArrayList<>();
        this.barajaCastigado = new ArrayList<>();
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
    public EstadoJugador getEstadoActual(){
        return estadoActual;
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
    }

    /**
     * Regresa las penalizaciones del jugador.
     * @return Las penalizaciones del jugador.
     */
    public int getPenalizaciones(){
        return penalizaciones;
    }
    /**
     * Regresa los turnos que el jugador lleva castigados
     * @return int con valor de los turnos que el jugador lleva castigado
     */
    public int getTurnosCastigado(){
        return turnosCastigado;
    }

    /**
     * Cambia las penalizaciones del jugador.
     * @param penalizaciones El nuevo valor de penalizaciones.
     */
    public void setPenalizaciones(int penalizaciones){
        this.penalizaciones= penalizaciones;
    }
    
   // public void incrementarPenalizacion(){
   //    setPenalizaciones(getPenalizaciones++);
   // }

    //public void resetPenalizacion(){
    //    
    //}

    /**
     * Metodo que no recibe nada y no regresa nada.
     */
    public void actualizar(){
    }
    
    /**
     * Metodo que regresa una pregunta.
     * @return Una pregunta.
     */
    public Tarjeta obtenerSiguientePregunta(){
        return estadoActual.obtenerSiguientePregunta();
    }

    ///**
    // * Metodo que recibe una respuesta y no regresa nada
    // * @param respuesta que da el usuario.
    // */
    //public void responderPregunta(){
    //    estadoActivo.responderPregunta();
    //}
//
    ///**
    // * Metodo que no recibe nada y no regresa nada
    // */
    //public void rechazarPregunta(){
    //    estadoActual.rechazarPregunta(); 
    //}

    /**
     * Metodo que no recibe nada y no regresa nada
     */
    public void borrarPregunta(Tarjeta tarjeta){
        estadoRegular.borrarPregunta(tarjeta);
    }

    /**
     * Metodo que regresa la baraja regular
     * @return la baraja regular
     */
    public List<Tarjeta> getBarajaRegular(){
        return barajaRegular;
    }

    /**
     * Metodo que regresa la baraja Castigado
     * @return barajaCastigado
     */
    public List<Tarjeta> getBarajaCastigado(){
        return barajaCastigado;
    }

    
    

}