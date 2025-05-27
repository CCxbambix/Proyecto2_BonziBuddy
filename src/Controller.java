import java.util.Random;

/**
 * Implementacion del controlador en el patron MVC para el juego.
 * Conecta la vista con el modelo y maneja las interacciones del usuario.
 */
public class Controller implements ControllerInterface {
    private final ModelInterface model;
    private final Vista vista;

    /**
     * Construye un nuevo Controller con el modelo proporcionado.
     * Crea la vista asociada.
     *
     * @param model la instancia del modelo con la que interactuara el controlador
     */
    public Controller(ModelInterface model) {
        this.model = model;
        this.vista = new Vista(this);
    }

    /**
     * Registra un nuevo jugador en el modelo e informa a la vista.
     *
     * @param nombre el nombre del jugador a registrar
     */
    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre, model);
        model.registrarJugador(jugador);
        vista.mostrarMensaje("Jugador registrado: " + nombre);
    }

    /**
     * Refuerza el estado de un jugador moviendolo de castigado a regular.
     *
     * @param j el jugador cuyo estado se reforzara
     */
    @Override
    public void reforzarEstado(Jugador j) {
        model.eliminarCastigado(j);
        model.registrarRegular(j);
    }

    /**
     * Devuelve el modelo asociado al controlador.
     *
     * @return la instancia del modelo
     */
    @Override
    public ModelInterface getModel() {
        return model;
    }
    
    /**
     * Devuelve la vista asociada al controlador.
     *
     * @return la instancia de la vista
     */
    public Vista getVista() {
        return vista;
    }

    /**
     * Solicita los nombres de los jugadores hasta que se ingrese "fin"
     * y los registra en el modelo.
     */
    private void registrarJugadores() {
        String nombre;
        int jugadorNumero = 1;
        while (true) {
            if (jugadorNumero == 1) {
                nombre = vista.pedirNombre();
            } else {
                nombre = vista.pedirNombre(jugadorNumero);
            }
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }
            model.registrarJugador(new Jugador(nombre, model));
            jugadorNumero++;
        }
    }

    /**
     * Inicia la partida: muestra bienvenida, registra jugadores,
     * lanza el modelo y comienza el bucle de juego.
     */
    @Override
    public void iniciarPartida() {
        vista.mostrarBienvenida();
        registrarJugadores();
        model.iniciarPartida(this);
        juego();
    }

    /**
     * Ejecuta una ronda de turnos, alternando entre preguntas y retos.
     *
     * @param opcion indica si es turno de "pregunta" o "reto"
     */
    public void ronda(String opcion) {
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador jugador = model.obtenerSiguienteJugador();
            String turno = jugador.turnoSiguiente(opcion);
            String resultado = vista.mostrarTurno(turno);
            if (resultado.equalsIgnoreCase("si")) {
                jugador.turnoLogrado();
                vista.mostrarMensaje("Turno logrado por " + jugador.getNombre() + ", bien hecho!");
            } else {
                jugador.turnoFallido();
                vista.mostrarMensaje("Turno fallido por " + jugador.getNombre());
                vista.mostrarMensaje("Debes completar un desafio y responder una pregunta por dos turnos seguidos para volver a ser regular.");
            }
        }
    }

    /**
     * Evento especial para jugadores castigados.
     */
    private void eventoCaso0() {
        vista.mostrarMensaje("Los jugadores castigados participaran en un evento especial.");
        model.notificarCastigados();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, los castigados han completado el evento.");
            model.incrementarPuntosCastigado();
        } else {
            vista.mostrarMensaje("No se daran puntos a los castigados por no completar el evento.");
        }
    }

    /**
     * Evento especial para jugadores regulares.
     */
    private void eventoCaso1() {
        vista.mostrarMensaje("Los jugadores regulares participaran en un evento especial.");
        model.notificarRegulares();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, los regulares han completado el evento.");
            model.incrementarPuntosRegular();
        } else {
            vista.mostrarMensaje("No se daran puntos a los regulares por no completar el evento.");
        }
    }

    /**
     * Evento especial para todos los jugadores.
     */
    private void eventoCaso2() {
        vista.mostrarMensaje("Todos los jugadores participaran en un evento especial.");
        model.notificarTodos();
        String completado = vista.mostrarEvento();
        if (completado.equalsIgnoreCase("si")) {
            vista.mostrarMensaje("Bien hecho, todos los jugadores han completado el evento.");
            model.incrementarPuntosTodos();
        } else {
            vista.mostrarMensaje("No se daran puntos a los jugadores por no completar el evento.");
        }
    }

    /**
     * Evento que castiga a todos los jugadores.
     */
    private void eventoCaso3() {
        vista.mostrarMensaje("Todos los jugadores seran castigados");
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador j = model.obtenerSiguienteJugador();
            j.setEstadoActual(j.getEstadoCastigado());
        }
    }

    /**
     * Lanza un evento aleatorio entre cuatro posibles.
     */
    public void lanzarEvento() {
        Random random = new Random();
        model.setEventoActual();
        int evento = random.nextInt(4);
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

    /**
     * Muestra la despedida con puntajes finales.
     */
    public void despedida() {
        vista.mostrarMensaje("Gracias por jugar FUNADO!");
        StringBuilder puntajes = new StringBuilder("Puntajes finales:\n");
        for (int i = 0; i < model.getTotalJugadores(); i++) {
            Jugador j = model.obtenerSiguienteJugador();
            puntajes.append(j.getNombre())
                    .append(": ")
                    .append(j.getPuntos())
                    .append(" puntos\n");
        }
        vista.mostrarMensaje(puntajes.toString());
    }

    /**
     * Bucle principal de juego que alterna rondas de preguntas y retos,
     * lanza eventos cada tres rondas, y permite continuar o terminar tras diez rondas.
     */
    private void juego() {
        boolean opcion = true;
        int rondas = 0;
        int rondasTotales = 0;
        while (true) {
            ronda(opcion ? "pregunta" : "reto");
            opcion = !opcion;
            rondas++;
            rondasTotales++;
            if (rondas > 2) {
                rondas = 0;
                lanzarEvento();
            }
            if (rondasTotales >= 10) {
                String decision = vista.continuarJuego();
                if (decision.equalsIgnoreCase("no")) {
                    despedida();
                    break;
                } else {
                    rondasTotales = 0;
                }
            }
        }
    }
}
