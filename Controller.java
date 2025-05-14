/**
 * Implementacion del controlador en el patron MVC para el juego.
 * Conecta la vista con el modelo y maneja las interacciones del usuario.
 */
public class Controller implements ControllerInterface {
    private final ModelInterface model;
    private final Vista vista;

    /**
     * Constructor del Controller.
     * Inicializa el controlador con una instancia del modelo y crea la vista.
     * Ademas, inicia la partida al ser creado.
     * @param model La instancia del modelo con la que interactuara el controlador.
     */
    public Controller(ModelInterface model) {
        this.model = model;
        this.vista = new Vista(this);
        iniciarPartida();
    }

    /**
     * Registra un nuevo jugador con el nombre proporcionado en el modelo.
     * Notifica a la vista que el jugador ha sido registrado.
     * @param nombre El nombre del jugador a registrar.
     */
    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre, model);
        model.registrarJugador(jugador);
        vista.mostrarMensaje("Jugador registrado: " + nombre);
    }

    /**
     * Procesa la respuesta de un jugador a una pregunta.
     * Si la respuesta es correcta, incrementa la puntuacion del jugador y refuerza su estado.
     * Si la respuesta es incorrecta, mueve al jugador al estado de castigado.
     * @param j El jugador que dio la respuesta.
     * @param r La respuesta dada por el jugador.
     */
    @Override
    public void procesarRespuesta(Jugador j, Respuesta r) {
        if (r.esCorrecta()) {
            j.incrementarPuntuacion(1);
            reforzarEstado(j);
            model.notificarTodos();
        } else {
            model.eliminarRegular(j);
            model.registrarCastigado(j);
            model.notificarCastigados();
        }
    }

    /**
     * Pasa el turno al siguiente jugador en el modelo.
     * Notifica a los jugadores regulares sobre el cambio de turno.
     */
    @Override
    public void pasarTurno() {
        model.obtenerSiguienteJugador();
        model.notificarRegulares();
    }

    /**
     * Refuerza el estado de un jugador, moviendolo de castigado a regular si corresponde.
     * @param j El jugador cuyo estado se reforzara.
     */
    @Override
    public void reforzarEstado(Jugador j) {
        model.eliminarCastigado(j);
        model.registrarRegular(j);
    }

    /**
     * Inicia la partida en el modelo.
     */
    @Override
    public void iniciarPartida() {
        model.iniciarPartida();
    }

    /**
     * Obtiene la instancia del modelo asociada a este controlador.
     * @return La instancia del modelo.
     */
    @Override
    public ModelInterface getModel() {
        return model;
    }
}