import java.util.List;

public class Anfitrion{
    private List<Jugador> jugadores;

    private List<Jugador> jugadoresRegulares;

    private List<Jugador> jugadoresCastigados;

       /**
     * Metodo que añade a un Jugador a la lista de Todos los jugadores
     * para ser notificados
     * @param Jugador con el jugador a registrar
     */
    public void registrarJugador(Jugador jugador){
    }

    /**
     * Metodo que añade a un jugador a la lista de jugadores regulares 
     * para ser notificados
     * @param Jugador con valor a el jugador a registrar
     */
    public void registrarRegular(Jugador jugador){
    }

    /**
     * Metodo que añade a un jugador a la lista de jugadores castigados 
     * para ser notificados
     * @param Jugador con valor a el jugador a registrar
     */
    public void registrarCastigado(Jugador jugador){
    }

    /**
     * Metodo que elimina a un jugador de la lista de Regulares 
     * @param Jugador con el jugador a eliminar
     */
    public void eliminarRegular(Jugador jugador){
    }
    /**
     * Metodo que elimina a un jugador de la lista de Castigados 
     * @param Jugador con el jugador a eliminar
     */
    public void eliminarCastigado(Jugador jugador){
    }

    /**
     * Metodo que Notifica a todos los jugadores del juego
     */
    public void notificarTodos(){
    }

    /**
     * Metodo que notifica solo a los Jugadores Regulares
     */
    public void notificarRegulares(){  
    }

    /**
     * Metodo que notifica solo a los jugadores Castigados
     */
    public void notificarCastigados(){
    }
}
