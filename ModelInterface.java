import java.util.List;
import java.util.Iterator;

/**
 * Interfaz que define las operaciones que debe realizar el modelo.
 */
public interface ModelInterface {
     * Registra a un jugador en el modelo.
     *
     * @param j El jugador a registrar.
     */
    void registrarJugador(Jugador j);

    /**
     * Inicia la partida.
     */
    void iniciarPartida();

    /**
     * Genera una baraja de cartas con la dificultad especificada.
     *
     * @param dificultad La dificultad 
     * @return Un iterador sobre las cartas generadas.
     */
    Iterator<Carta> generarBaraja(int dificultad);

    /**
     * Notifica a los observadores de un cambio en el modelo.
     */
    void iniciarPartida();
    Iterator<Carta> generarBaraja(int dificultad);
    void notificar();
}