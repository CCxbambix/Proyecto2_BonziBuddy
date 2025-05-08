/**
 * Clase que representa a el estado Castigado del jugador
 */
public class Castigado implements EstadoJugador{
 
    /**
     * Atributo que representa a el jugador
     */
    private Jugador jugador;

    public Castigado (Jugador jugador){
        this.jugador = jugador;
    }

     /**
     * Metodo que rgresara la siguiente pregunta del mazo de cartas
     */
    public Tarjeta obtenerSiguientePregunta(){
        return null;
    }

    /**
     * Metodo que borrar la pregunta mostrada del mazo
     */
    public void borrarPregunta(Tarjeta tarjeta){
        jugador.getBarajaCastigado().remove(tarjeta);
    }
}