/**
 * Interfaz que representa a el Estado que tiene el jugador durante el cuurso de la partida 
 */
public interface EstadoJugador{
    
    /**
     * Metodo que rgresara la siguiente pregunta del mazo de cartas
     */
    public Tarjeta obtenerSiguientePregunta();

    /**
     * Metodo que borrar la pregunta mostrada del mazo
     */
    public void borrarPregunta(Tarjeta tarjeta);

    

}