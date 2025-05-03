/**
 * Clase que representa a el estado activo de un usuario
 */
public class Activo implements EstadoJugador{

    /**Atributo que representa a el jugador  */
    private Jugador jugador;

    public Activo (Jugador jugador){
        this.jugador = jugador;
    }

    public void borrarPregunta(){
    }
}