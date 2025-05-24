import com.funado.util.LectorPreguntas;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa la interfaz ModelInterface y Sujeto en el patron MVC y Observer.
 * Gestiona el estado del juego, la lista de jugadores (regulares y castigados)
 * y las barajas de preguntas, retos y eventos. Notifica a los observadores sobre cambios.
 */
public class Model implements ModelInterface, Sujeto {
    private final List<Jugador> todos = new ArrayList<>();
    private final List<Jugador> regulares = new ArrayList<>();
    private final List<Jugador> castigados = new ArrayList<>();

    private Baraja retos;
    private Baraja eventos;
    private Baraja preguntas;

    // ——— Sujeto —————————————————————————————————————————————

    /**
     * Registra un jugador en la lista de todos los jugadores y en la lista de regulares.
     * No agrega al jugador si ya existe en la lista 'todos'.
     * @param jugador El jugador a registrar.
     */
    @Override
    public void registrarJugador(Jugador jugador) {
        if (!todos.contains(jugador)) {
            todos.add(jugador);
            regulares.add(jugador);
        }
    }

    /**
     * Registra un jugador en la lista de jugadores regulares.
     * No agrega al jugador si ya existe en la lista 'regulares'.
     * @param jugador El jugador a registrar como regular.
     */
    @Override
    public void registrarRegular(Jugador jugador) {
        if (!regulares.contains(jugador)) {
            regulares.add(jugador);
        }
    }

    /**
     * Registra un jugador en la lista de jugadores castigados.
     * No agrega al jugador si ya existe en la lista 'castigados'.
     * @param jugador El jugador a registrar como castigado.
     */
    @Override
    public void registrarCastigado(Jugador jugador) {
        if (!castigados.contains(jugador)) {
            castigados.add(jugador);
        }
    }

    /**
     * Elimina un jugador de la lista de jugadores regulares.
     * @param jugador El jugador a eliminar de la lista de regulares.
     */
    @Override
    public void eliminarRegular(Jugador jugador) {
        regulares.remove(jugador);
    }

    /**
     * Elimina un jugador de la lista de jugadores castigados.
     * @param jugador El jugador a eliminar de la lista de castigados.
     */
    @Override
    public void eliminarCastigado(Jugador jugador) {
        castigados.remove(jugador);
    }

    /**
     * Notifica a todos los jugadores (observadores) sobre un cambio en el modelo.
     */
    @Override
    public void notificarTodos() {
        for (Jugador j : todos) {
            j.actualizar();
        }
    }

    /**
     * Notifica solo a los jugadores en estado regular sobre un cambio en el modelo.
     */
    @Override
    public void notificarRegulares() {
        for (Jugador j : regulares) {
            j.actualizar();
        }
    }

    /**
     * Notifica solo a los jugadores en estado castigado sobre un cambio en el modelo.
     */
    @Override
    public void notificarCastigados() {
        for (Jugador j : castigados) {
            j.actualizar();
        }
    }

    // ——— ModelInterface —————————————————————————————————————

    /**
     * Inicializa la partida cargando las barajas de preguntas, retos y eventos.
     * Notifica a todos los jugadores que la partida ha iniciado.
     */
    @Override
    public void iniciarPartida() {
        retos = new Baraja(LectorPreguntas.getRetos());
        eventos = new Baraja(LectorPreguntas.getEventos());
        preguntas = new Baraja(LectorPreguntas.getPreguntas());
        notificarTodos();
    }

    /**
     * Obtiene la siguiente tarjeta de la baraja de retos.
     * Notifica a los jugadores regulares despues de obtener la tarjeta.
     * @return La siguiente tarjeta de retos.
     */
    @Override
    public Tarjeta getTarjetaRetos() {
        Tarjeta t = retos.getSiguienteTarjeta();
        notificarRegulares();
        return t;
    }

    /**
     * Obtiene la siguiente tarjeta de la baraja de eventos.
     * Notifica a todos los jugadores despues de obtener la tarjeta.
     * @return La siguiente tarjeta de eventos.
     */
    @Override
    public Tarjeta getTarjetaEventos() {
        Tarjeta t = eventos.getSiguienteTarjeta();
        notificarTodos();
        return t;
    }

    /**
     * Obtiene la siguiente tarjeta de la baraja de preguntas.
     * Notifica a los jugadores regulares despues de obtener la tarjeta.
     * @return La siguiente tarjeta de preguntas.
     */
    @Override
    public Tarjeta getTarjetaPreguntas() {
        Tarjeta t = preguntas.getSiguienteTarjeta();
        notificarRegulares();
        return t;
    }

    /**
     * Obtiene el siguiente jugador en el turno utilizando la cola de jugadores.
     * @return El siguiente Jugador en la secuencia de turnos.
     * @throws NoSuchElementException si no hay jugadores en la cola de turnos.
     */
    @Override
    public Jugador obtenerSiguienteJugador() {
        return ordenTurnos.obtenerSiguienteJugador();
    }
}
