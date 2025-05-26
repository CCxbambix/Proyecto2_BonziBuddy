import java.util.Random;

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
    
    public Vista getVista() {
        return vista;
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
        model.iniciarPartida(this);
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

    private void eventoCaso0() {
        vista.mostrarMensaje("Los jugadores castigados participaran en un evento especial.");
        model.notificarCastigados();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, los castigados han completado el evento.");
            model.incrementarPuntosCastigado();
        } else {
            vista.mostrarMensaje("No se dara puntos a los castigados por no completar el evento.");
        }
    }

    private void eventoCaso1(){
        vista.mostrarMensaje("Los jugadores regulares participaran en un evento especial.");
        model.notificarRegulares();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, los regulares han completado el evento.");
            model.incrementarPuntosRegular();
        } else {
            vista.mostrarMensaje("No se dara puntos a los regulares por no completar el evento.");
        }
    }

    private void eventoCaso2(){
        vista.mostrarMensaje("Todos los jugadores participaran en un evento especial.");
        model.notificarTodos();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, todos los jugadores han completado el evento.");
            model.incrementarPuntosTodos();
        } else {
            vista.mostrarMensaje("No se dara puntos a los jugadores por no completar el evento.");
        }
    }

    private void eventoCaso3(){
        vista.mostrarMensaje("Todos los jugadores seran castigados");
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador j = model.obtenerSiguienteJugador();
            j.setEstadoActual(j.getEstadoCastigado());
        }
    }

    public void lanzarEvento(){
        Random random = new Random();
        model.setEventoActual();
        int evento = random.nextInt(4); // Genera un numero aleatorio entre 0 y 3
        switch (evento) {
            case 0:
                eventoCaso0();
                break;
            case 1:
                eventoCaso1();
                break;
            case 2:
                eventoCaso2();
                break;
            case 3:
                eventoCaso3();
                break;
            default:
        }
    }

    public void despedida(){
        vista.mostrarMensaje("Gracias por jugar FUNADO!");
        String puntajes = "Puntajes finales:\n";
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador j = model.obtenerSiguienteJugador();
            puntajes += j.getNombre() + ": " + j.getPuntos() + " puntos\n";
        }
        vista.mostrarMensaje(puntajes);
    }

    private void juego(){
        Boolean opcion = true;
        int rondas = 0;
        int rondasTotales = 0;
        while (true){
            if (opcion) ronda("pregunta");
            else ronda("reto");
            opcion = !opcion; // Alterna entre pregunta y desafio
            rondas++;
            rondasTotales++;
            if (rondas > 2){
                rondas = 0;
                lanzarEvento();
            }
            if (rondasTotales >=10){
                String decisionAnfitrion = vista.continuarJuego();
                if (decisionAnfitrion.equalsIgnoreCase("no")) {
                    despedida();
                    break;
                } else {
                    rondasTotales = 0; // Reinicia las rondas totales si se decide continuar
                }
            }
        }   
    }
}