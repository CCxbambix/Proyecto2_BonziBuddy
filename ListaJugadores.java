import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Gestiona una lista de jugadores en una cola circular para controlar los turnos.
 * Implementa la interfaz Iterable para permitir la iteracion sobre los jugadores.
 */
public class ListaJugadores implements Iterable<Jugador> {
    
    //Atributos de la clase 

    /**
     * Representa a la cola de Jugadores para el juego
     */
    private Queue<Jugador> colaJugadores;


    public ListaJugadores() {
        colaJugadores = new LinkedList<>();
    }

    /**
     * Agrega un jugador al final de la cola de jugadores.
     * @param jugador El jugador a agregar.
     * @throws IllegalArgumentException si el jugador proporcionado es nulo.
     */
    public void agregarJugador(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException("Jugador no puede ser nulo");
        }
        colaJugadores.add(jugador);
    }

    /**
     * Obtiene el siguiente jugador en el turno. Mueve al jugador actual al final de la cola.
     * @return El jugador cuyo turno sigue.
     * @throws NoSuchElementException si la cola de jugadores esta vacia.
     */
    public Jugador obtenerSiguienteJugador() {
        if (colaJugadores.isEmpty()) {
            throw new NoSuchElementException("No hay jugadores en la cola");
        }
        Jugador siguiente = colaJugadores.poll();
        colaJugadores.add(siguiente);
        return siguiente;
    }

    /**
     * Verifica si la lista de jugadores esta vacia.
     * @return true si no hay jugadores, false en caso contrario.
     */
    public boolean estaVacia() {
        return colaJugadores.isEmpty();
    }

    /**
     * Obtiene el numero de jugadores en la lista.
     * @return El tamano de la lista de jugadores.
     */
    public int size() {
        return colaJugadores.size();
    }

    /**
     * Devuelve un iterador sobre los elementos de esta lista en la secuencia correcta.
     * La coleccion sobre la que itera es no modificable para proteger la estructura interna.
     * @return Un iterador sobre los jugadores en la lista.
     */
    @Override
    public Iterator<Jugador> iterator() {
        return Collections.unmodifiableCollection(colaJugadores).iterator();
    }
}