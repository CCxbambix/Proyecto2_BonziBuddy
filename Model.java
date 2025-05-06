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
    private BarajaRegular barajaActiva;

    /**
     * Baraja de castigo.
     */
    private BarajaCastigo barajaCastigado;

    /**
     * Iterador para recorrer las cartas.
     */
    private Iterator<Carta> iterador;

    /**
     * Lista de observadores que serán notificados de cambios en el modelo.
     */
    private List<Observador> observers;

    /**
     * Registra a un jugador en el juego.
     * @param j El jugador a registrar.
     */
    public void registrarJugador(Jugador j) {
    }

    /**
     * Inicia la partida.
     */
    public void iniciarPartida() {
    }

    /**
     * Genera la baraja de cartas con una dificultad especificada.
     * @param dificultad La dificultad para generar la baraja.
     * @return Un iterador para recorrer la baraja de cartas.
     */
    public Iterator<Carta> generarBaraja(int dificultad) {
        return null;
    }

    /**
     * Notifica a los observadores sobre los cambios.
     */
    public void notificar() {
    }
}