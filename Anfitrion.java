import java.util.List;

public class Anfitrion{
    
    /**Atributos de la clase */

    /**
     * Representa a la lista de jugadores totales del jugeo
     */
    private List<Jugador> jugadores;

    /**
     * Representa a la lista de jugadores Regulares actuales
     */
    private List<Jugador> jugadoresRegulares;

    /**
     * representa a la lista actual de jugadores castigados
     */
    private List<Jugador> jugadoresCastigados;

    /**Metodos de la clase  */

    /**
     * Metodo que añade a un Jugador a la lista de Todos los jugadores
     * para ser notificados
     * @param Jugador con el jugador a registrar
     */
    public void registrarJugador(Jugador jugador){
      jugadores.add(jugador);
    }

    /**
     * Metodo que añade a un jugador a la lista de jugadores regulares 
     * para ser notificados
     * @param Jugador con valor a el jugador a registrar
     */
    public void registrarRegular(Jugador jugador){
      jugadoresRegulares.add(jugador);
    }

    /**
     * Metodo que añade a un jugador a la lista de jugadores castigados 
     * para ser notificados
     * @param Jugador con valor a el jugador a registrar
     */
    public void registrarCastigado(Jugador jugador){
      jugadoresCastigados.add(jugador);
    }

    /**
     * Metodo que elimina a un jugador de la lista de Regulares 
     * @param Jugador con el jugador a eliminar
     */
    public void eliminarRegular(Jugador jugador){
      jugadoresRegulares.remove(jugador);
    }
    /**
     * Metodo que elimina a un jugador de la lista de Castigados 
     * @param Jugador con el jugador a eliminar
     */
    public void eliminarCastigado(Jugador jugador){
      jugadoresCastigados.remove(jugador);
    }

    /**
     * Metodo que Notifica a todos los jugadores del juego
     */
    public void notificarTodos(){
      if (jugadores.zise() > 0){
        for (Jugador jugador : jugador ){
          alumno.setNotificacion(mensaje);
        }
      }
    }

    /**
     * Metodo que notifica solo a los Jugadores Regulares
     */
    public void notificarRegulares(){  
      if (jugadores.zise() > 0){
        for (Jugador jugadoresRegulares : jugador ){
          alumno.setNotificacion(mensaje);
        }
      }
    }

    /**
     * Metodo que notifica solo a los jugadores Castigados
     */
    public void notificarCastigados(){
      if (jugadores.zise() > 0){
        for (Jugador jugadoresCastigados : jugador ){
          alumno.setNotificacion(mensaje);
        }
      }
    }
}
