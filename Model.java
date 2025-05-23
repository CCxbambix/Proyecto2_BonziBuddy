import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa el modelo del juego.
 */
public class Model {

    /**
     * Lista de jugadores en el juego.
     */
    private List<Jugador> jugadores;

    /**
     * Baraja regular de cartas activas.
     */
    private Baraja retos;
    private Baraja eventos;
    private Baraja preguntas;
    
    /**
     * Registra a un jugador en el juego.
     * @param j El jugador a registrar.
     */
    public void registrarJugador(Jugador j) {
        if (jugadores == null) {
            jugadores = new LinkedList<>();
        }
        jugadores.add(j);
    }

    /**
     * Inicia la partida.
     */
    public void iniciarPartida() {
        retos = new Baraja();
        retos.setBaraja(LectorPreguntas.getRetos());
        eventos = new Baraja();
        eventos.setBaraja(LectorPreguntas.getEventos());
        preguntas = new Baraja();
        preguntas.setBaraja(LectorPreguntas.getPreguntas());
    }

    public Tarjeta getTarjetaRetos() {
        return retos.getSiguienteTarjeta();
    }

    public Tarjeta getTarjetaEventos() {
        return eventos.getSiguienteTarjeta();
    }

    public Tarjeta getTarjetaPreguntas() {
        return preguntas.getSiguienteTarjeta();
    }

    public int getIndexRetos() {
        return retos.getIndex();
    }

    public int getIndexEventos() {
        return eventos.getIndex();
    }
    
    public int getIndexPreguntas() {
        return preguntas.getIndex();
    }

    public void notificar() {
    }
}