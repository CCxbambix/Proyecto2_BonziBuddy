/**
 * Implementacion del controlador para el juego. Actua como anfitrion de la partida.
 */
public class Anfitrion implements ControllerInterface {
    private final ModelInterface model;

    /**
     * Constructor del Anfitrion.
     * @param model La instancia del modelo con la que interactuara el anfitrion.
     */
    public Anfitrion(ModelInterface model) {
        this.model = model;
    }

    /**
     * Registra un nuevo jugador en el modelo.
     * @param j El jugador a registrar.
     */

    public void registrarJugador(Jugador j) {
        model.registrarJugador(j);
    }

    // /**
    //  * Procesa la respuesta de un jugador a una pregunta.
    //  * Si la respuesta es correcta, incrementa la puntuacion del jugador y refuerza su estado.
    //  * Si la respuesta es incorrecta, mueve al jugador al estado de castigado.
    //  * @param j El jugador que dio la respuesta.
    //  * @param r La respuesta dada por el jugador.
    //  */
    // @Override
    // public void procesarRespuesta(Jugador j, Respuesta r) {
    //     if (r.esCorrecta()) {
    //         j.incrementarPuntuacion(1);
    //         reforzarEstado(j);
    //         model.notificarTodos();
    //     } else {
    //         model.eliminarRegular(j);
    //         model.registrarCastigado(j);
    //         model.notificarCastigados();
    //     }
    // }

    /**
     * Pasa el turno al siguiente jugador en el modelo.
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