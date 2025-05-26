



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
        vista.mostrarBienvenida();
        registrarJugadores();
        model.iniciarPartida();
        juego();
    }

    public void ronda (String opcion){
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador jugador = model.obtenerSiguienteJugador();
            String turno = jugador.turnoSiguiente(opcion);
            String resultado = vista.mostrarTurno(turno);
            if (resultado.equalsIgnoreCase("si")){
                jugador.turnoLogrado();
                vista.mostrarMensaje("Turno logrado por " + jugador.getNombre() + ", Bien hecho!");
            }
            else {
                jugador.turnoFallido();
                vista.mostrarMensaje("Turno fallido por " + jugador.getNombre());
                vista.mostrarMensaje("Debes completar un desafio y responder una pregunta  por dos turnos seguidospara volver a ser regular.");
            }
        }
    }

    public void lanzarEvento(){

    }

    private void juego(){
        Boolean opcion = true;
        int rondas = 0;
        while (true){
            if (opcion) ronda("pregunta");
            else ronda("reto");
            opcion = !opcion; // Alterna entre pregunta y desafio
            if (rondas >= 2){
                rondas = 0;
                lanzarEvento();
            }
        }   
    }
}