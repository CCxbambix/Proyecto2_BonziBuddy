/**
 * Clase que representa a el estado regular de un usuario
 */
public class Regular implements EstadoJugador{

    /**Atributo que representa a el jugador  */
    private Jugador jugador;

    /**
     * Constructor de la clase
     * @param Jugador 
     */
    public Regular (Jugador jugador){
        this.jugador = jugador;
    }

    /**
     * Metodo que rgresara la siguiente pregunta del mazo de cartas
     */
    public Tarjeta obtenerSiguientePregunta(){
        return; null;//falta este metodo
    }

    /**
     * Borra la Tarjeta que se mostro de la baraja correspondiente
     */
    public void borrarPregunta(Tarjeta tarjeta){
        jugador.getBarajaRegular().remove(tarjeta);
    }
}