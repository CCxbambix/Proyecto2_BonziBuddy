/**
 * Clase que representa a el estado activo de un usuario
 */
public class Activo implements EstadoJugador{

    /**Atributo que representa a el jugador  */
    private Jugador jugador;

    /**
     * Constructor de la clase
     * @param Jugador 
     */
    public Activo (Jugador jugador){
        this.jugador = jugador;
    }

    /**
     * Borra la Tarjeta que se mostro del mazo correspondiente
     */
    public void borrarPregunta(Tarjeta tarjeta){
        jugador.mazoActivo.removerCarta(Carta carta);
    }
}