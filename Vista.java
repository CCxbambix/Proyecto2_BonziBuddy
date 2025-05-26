import java.util.Scanner;

/**
 * Representa la interfaz de usuario del juego.
 * Se encarga de mostrar informacion y recibir entradas del usuario.
 */
public class Vista implements VistaInterface {
    private final ControllerInterface controller;
    private final ModelInterface model;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Construye la vista asociada al controlador dado.
     *
     * @param controller el controlador con el que interactuara la vista
     */
    public Vista(ControllerInterface controller) {
        this.controller = controller;
        this.model = controller.getModel();
    }

    /**
     * Muestra el mensaje de bienvenida y las reglas basicas del juego.
     */
    public void mostrarBienvenida() {
        System.out.println("BIENVENIDO A FUNADO");
        System.out.println("Objetivo: acumular la mayor cantidad de puntos posibles.");
        System.out.println("Reglas basicas:");
        System.out.println("- En cada turno, un jugador recibe una pregunta o un reto.");
        System.out.println("- Responder/completar vale 1 punto; si no, eres castigado.");
        System.out.println("- Un castigado debe responder pregunta Y completar un reto para ganar 1 punto.");
        System.out.println("- Tras 2 turnos seguidos ganando punto, un castigado vuelve a REGULAR.");
        System.out.println("- Ocasionalmente activamos eventos que afectan a jugadores.\n");
    }

    /**
     * Muestra un mensaje general al usuario.
     *
     * @param mensaje la cadena que se desea mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita el nombre del jugador numero i o la palabra "fin" para terminar.
     *
     * @param i el numero de orden del jugador
     * @return el nombre ingresado o "fin"
     */
    public String pedirNombre(int i) {
        System.out.print("Ingrese el nombre del jugador " + i + " o escriba \"fin\" para terminar:");
        return sc.nextLine();
    }

    /**
     * Solicita el nombre del primer jugador.
     *
     * @return el nombre ingresado
     */
    public String pedirNombre() {
        System.out.print("Ingrese el nombre del jugador 1:");
        return sc.nextLine();
    }

    /**
     * Muestra el contenido del turno y pregunta si fue completado correctamente.
     *
     * @param turno el mensaje con la tarjeta a mostrar
     * @return "Si" o "No" segun la respuesta valida del usuario
     */
    public String mostrarTurno(String turno) {
        System.out.println("\n" + turno);
        System.out.println("¿El jugador completo el turno satisfactoriamente? (Si/No)");
        while (true) {
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("Si") || respuesta.equalsIgnoreCase("No")) {
                return respuesta;
            } else {
                System.out.println("Respuesta invalida. Por favor, ingrese 'Si' o 'No'.");
            }
        }
    }

    /**
     * Pregunta si el evento especial fue completado por los jugadores.
     *
     * @return "Si" o "No" segun la respuesta valida del usuario
     */
    public String mostrarEvento() {
        System.out.println("Fue el evento completado por todos? (Si/No)");
        while (true) {
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("Si") || respuesta.equalsIgnoreCase("No")) {
                return respuesta;
            } else {
                System.out.println("Respuesta invalida. Por favor, ingrese 'Si' o 'No'.");
            }
        }
    }

    /**
     * Pregunta al anfitrion si desea continuar con el juego.
     *
     * @return "Si" o "No" segun la respuesta valida del usuario
     */
    public String continuarJuego() {
        System.out.println("¿Desea continuar con el juego? (Si/No)");
        while (true) {
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("Si") || respuesta.equalsIgnoreCase("No")) {
                return respuesta;
            } else {
                System.out.println("Respuesta invalida. Por favor, ingrese 'Si' o 'No'.");
            }
        }
    }
}
