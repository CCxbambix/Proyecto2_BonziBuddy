/**
 * Clase que representa a el estado Castigado del jugador
 */
public class Castigado implements EstadoJugador{
 
    /**
     * Atributo que representa a el jugador
     */
    private final Jugador jugador;

    /**
     * Metodo constructor de la clase
     * @param Jugador para crear es estado Castigado
     */
    public Castigado (Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public Estado getEstado(){
        return Estado.CASTIGADO;
    }

    @Override
    public void turnoSiguiente() {
        jugador.getModel();
    }
}