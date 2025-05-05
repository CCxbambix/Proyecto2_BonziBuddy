import java.util.Iterator;

public interface ModelInterface {
    void registrarJugador(Jugador j);
    void iniciarPartida();
    Iterator<Carta> generarBaraja(int dificultad);
    void notificar();
}