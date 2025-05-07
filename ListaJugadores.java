import java.util.LinkedList;
import java.util.Queue;

public class ListaJugadores {
    private Queue<Jugador> colaJugadores;

    public ListaJugadores() {
        colaJugadores = new LinkedList<>();
    }

    /**
     * Agrega un jugador a la cola de jugadores.
     * @param jugador El jugador a agregar.
     */
    public void agregarJugador(Jugador jugador) {
        colaJugadores.add(jugador);
    }

    /**
     * Obtiene el siguiente jugador de la cola, lo vuelve a encolar al final y lo regresa.
     * @return El siguiente jugador en la cola.
     */
    public Jugador obtenerSiguienteJugador() {
        Jugador siguienteJugador = colaJugadores.poll();
        colaJugadores.add(siguienteJugador);
        return siguienteJugador;
    }
    
    public boolean estaVacia(){
        return colaJugadores.isEmpty();
    }
}