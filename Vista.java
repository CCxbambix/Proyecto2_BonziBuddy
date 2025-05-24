import java.util.Scanner;

/**
 * La clase Vista representa la interfaz de usuario del juego.
 * Se encarga de interactuar con el usuario, mostrar informacion
 * y recibir entradas.
 */
public class Vista implements VistaInterface, Observador {
    private final ControllerInterface controller;
    private final ModelInterface model;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Vista.
     * @param controller El controlador con el que interactuara la vista.
     */
    public Vista(ControllerInterface controller) {
        this.controller = controller;
        this.model      = controller.getModel();
        this.model.registrarObserver(this);
    }

    /**
     * Inicia el flujo principal de la aplicacion de la vista.
     */
    public void start() {
        mostrarBienvenida();
        registrarJugadores();
        controller.iniciarPartida();
        loopPrincipal();
        sc.close();
    }

    /**
     * Muestra el mensaje de bienvenida y las reglas del juego.
     */
    private void mostrarBienvenida() {
        System.out.println("BIENVENIDO A FUNADO");
        System.out.println("Objetivo: acumular la mayor cantidad de puntos posibles.");
        System.out.println("Reglas basicas:");
        System.out.println("- En cada turno, un jugador recibe una pregunta o un reto.");
        System.out.println("- Responder/completar vale 1 punto; si no, eres castigado.");
        System.out.println("- Un castigado debe responder Y completar para ganar 1 punto.");
        System.out.println("- Tras 2 turnos, un castigado vuelve a REGULAR.");
        System.out.println("- Ocasionalmente activamos eventos que afectan a jugadores.");
    }

    /**
     * Solicita al usuario el numero y nombre de los jugadores y los registra.
     */
    private void registrarJugadores() {
        System.out.print("¿Cuantos jugadores van a jugar? ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= n; i++) {
            System.out.printf("Nombre del jugador %d: ", i);
            String nombre = sc.nextLine().trim();
            controller.registrarJugador(nombre);
        }
    }

    /**
     * Ejecuta el bucle principal del juego, gestionando los turnos de los jugadores.
     */
    private void loopPrincipal() {
        while (true) {
            Jugador actual = model.obtenerSiguienteJugador();
            if (actual == null) break;
            System.out.printf("Turno de %s (%s). Elige [q]uestion, [r]eto o [p]asar:%n",
                              actual.getNombre(), actual.getEstado());
            String opt = sc.nextLine().trim().toLowerCase();
            switch (opt) {
                case "q":
                    Tarjeta tp = model.getTarjetaPreguntas();
                    mostrarPregunta(tp);
                    controller.procesarRespuesta(actual, new Respuesta(sc.nextLine()));
                    break;
                case "r":
                    Tarjeta tr = model.getTarjetaRetos();
                    mostrarPregunta(tr);
                    controller.procesarRespuesta(actual, new Respuesta(sc.nextLine()));
                    break;
                case "p":
                    controller.pasarTurno();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        System.out.println("¡Juego terminado!");
    }

    /**
     * Metodo llamado por el modelo para notificar cambios.
     * Actualiza la informacion mostrada al usuario.
     */
    @Override
    public void actualizar() {
        System.out.println("-- Modelo actualizado --");
        System.out.println("Jugador actual: " + model.obtenerSiguienteJugador().getNombre());
    }

    /**
     * Muestra una pregunta o reto al usuario.
     * @param tarjeta La tarjeta que contiene la pregunta o reto.
     */
    @Override
    public void mostrarPregunta(Tarjeta tarjeta) {
        System.out.println("--- TARJETA ---");
        System.out.println(tarjeta.getPregunta());
        System.out.print("> Respuesta: ");
    }

    /**
     * Muestra un mensaje general al usuario.
     * @param mensaje El mensaje a mostrar.
     */
    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}