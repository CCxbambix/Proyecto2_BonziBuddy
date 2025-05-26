import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implementa ModelInterface y Sujeto en el patron MVC y Observer.
 * Gestiona el estado del juego, las listas de jugadores y las barajas de retos,
 * eventos y preguntas. Notifica a los observadores sobre cambios.
 */
public class Model implements ModelInterface, Sujeto {
    private final List<Jugador> todos = new ArrayList<>();
    private final List<Jugador> regulares = new ArrayList<>();
    private final List<Jugador> castigados = new ArrayList<>();

    private Baraja retos;
    private Baraja eventos;
    private Baraja preguntas;

    private final Queue<Jugador> colaJugadores = new LinkedList<>();

    private ControllerInterface controller;
    private String eventoActual;

    // —— Sujeto ——————————————————————————————————————————

    /**
     * Registra un jugador en la lista de todos y en la de regulares
     * si no existe previamente.
     *
     * @param jugador el jugador a registrar
     */
    @Override
    public void registrarJugador(Jugador jugador) {
        if (!todos.contains(jugador)) {
            todos.add(jugador);
            regulares.add(jugador);
        }
    }

    /**
     * Devuelve el controlador asociado al modelo.
     *
     * @return el controlador
     */
    public ControllerInterface getController() {
        return controller;
    }

    /**
     * Obtiene la descripcion del ultimo evento ejecutado.
     *
     * @return la descripcion del evento actual
     */
    public String getEventoActual() {
        return eventoActual;
    }

    /**
     * Selecciona la siguiente tarjeta de eventos y actualiza eventoActual.
     */
    public void setEventoActual() {
        this.eventoActual = eventos.getSiguienteTarjeta().getPregunta();
    }

    /**
     * Incrementa puntos de todos los jugadores castigados.
     */
    public void incrementarPuntosCastigado() {
        for (Jugador j : castigados) {
            j.incrementarPuntos();
        }
    }

    /**
     * Incrementa puntos de todos los jugadores regulares.
     */
    public void incrementarPuntosRegular() {
        for (Jugador j : regulares) {
            j.incrementarPuntos();
        }
    }

    /**
     * Incrementa puntos de todos los jugadores.
     */
    public void incrementarPuntosTodos() {
        for (Jugador j : todos) {
            j.incrementarPuntos();
        }
    }

    /**
     * Agrega un jugador a la lista de regulares si no existe y
     * su estado es REGULAR.
     *
     * @param jugador el jugador a agregar como regular
     */
    @Override
    public void registrarRegular(Jugador jugador) {
        if (!regulares.contains(jugador) && jugador.getEstado() == Estado.REGULAR) {
            regulares.add(jugador);
            eliminarCastigado(jugador);
        }
    }

    /**
     * Agrega un jugador a la lista de castigados si no existe y
     * su estado es CASTIGADO.
     *
     * @param jugador el jugador a agregar como castigado
     */
    @Override
    public void registrarCastigado(Jugador jugador) {
        if (!castigados.contains(jugador) && jugador.getEstado() == Estado.CASTIGADO) {
            castigados.add(jugador);
            eliminarRegular(jugador);
        }
    }

    /**
     * Elimina un jugador de la lista de regulares.
     *
     * @param jugador el jugador a eliminar
     */
    @Override
    public void eliminarRegular(Jugador jugador) {
        regulares.remove(jugador);
    }

    /**
     * Elimina un jugador de la lista de castigados.
     *
     * @param jugador el jugador a eliminar
     */
    @Override
    public void eliminarCastigado(Jugador jugador) {
        castigados.remove(jugador);
    }

    /**
     * Notifica a todos los jugadores registrados.
     */
    @Override
    public void notificarTodos() {
        for (Jugador j : todos) {
            j.actualizar();
        }
    }

    /**
     * Notifica solamente a los jugadores regulares.
     */
    @Override
    public void notificarRegulares() {
        for (Jugador j : regulares) {
            j.actualizar();
        }
    }

    /**
     * Notifica solamente a los jugadores castigados.
     */
    @Override
    public void notificarCastigados() {
        for (Jugador j : castigados) {
            j.actualizar();
        }
    }

    // —— ModelInterface ————————————————————————————————————

    /**
     * Inicializa la partida cargando las barajas de retos, eventos y preguntas.
     * Agrega todos los jugadores a la cola de turnos.
     *
     * @param controller el controlador que maneja el flujo del juego
     */
    @Override
    public void iniciarPartida(ControllerInterface controller) {
        this.controller = controller;
        retos    = new Baraja(LectorPreguntas.getRetos());
        eventos  = new Baraja(LectorPreguntas.getEventos());
        preguntas= new Baraja(LectorPreguntas.getPreguntas());
        for (Jugador jugador : todos) {
            colaJugadores.add(jugador);
        }
    }

    /**
     * Obtiene una tarjeta de retos aleatoria.
     *
     * @return la siguiente tarjeta de retos
     */
    @Override
    public Tarjeta getTarjetaRetos() {
        return retos.getTarjetaRandom();
    }

    /**
     * Obtiene una tarjeta de eventos aleatoria.
     *
     * @return la siguiente tarjeta de eventos
     */
    @Override
    public Tarjeta getTarjetaEventos() {
        return eventos.getTarjetaRandom();
    }

    /**
     * Obtiene una tarjeta de preguntas aleatoria.
     *
     * @return la siguiente tarjeta de preguntas
     */
    @Override
    public Tarjeta getTarjetaPreguntas() {
        return preguntas.getTarjetaRandom();
    }

    /**
     * Devuelve el numero total de jugadores registrados.
     *
     * @return cantidad de jugadores
     */
    public int getTotalJugadores() {
        return todos.size();
    }

    /**
     * Obtiene el siguiente jugador en la secuencia de turnos.
     *
     * @return el jugador cuyo turno es siguiente
     * @throws NoSuchElementException si la cola de turnos esta vacia
     */
    @Override
    public Jugador obtenerSiguienteJugador() {
        if (colaJugadores.isEmpty()) {
            throw new NoSuchElementException("No hay jugadores en la cola de turnos");
        }
        Jugador siguiente = colaJugadores.poll();
        colaJugadores.offer(siguiente);
        return siguiente;
    }
}
