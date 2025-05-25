

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
    
    /**
     * Obtiene la instancia del modelo asociada a este controlador.
     * @return La instancia del modelo.
     */
    @Override
    public ModelInterface getModel() {
        return model;
    }
    
    private void registrarJugadores() {
        String nombre;
        nombre = vista.pedirNombre(); 
        model.registrarJugador(new Jugador(nombre, model));
        
        int jugadorNumero = 2;
        while (true) {
            nombre = vista.pedirNombre(jugadorNumero);
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }
            model.registrarJugador(new Jugador(nombre, model));
            jugadorNumero++;
        }
    }  

    @Override
    public void iniciarPartida() {
        System.out.println("Iniciando partida...");
        model.iniciarPartida();
        vista.mostrarBienvenida();
        registrarJugadores();
        
    }
}