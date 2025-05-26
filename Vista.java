import java.util.Scanner;

/**
 * La clase Vista representa la interfaz de usuario del juego.
 * Se encarga de interactuar con el usuario, mostrar informacion
 * y recibir entradas.
 */
public class Vista implements VistaInterface{
    private final ControllerInterface controller;
    private final ModelInterface model;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Vista.
     * @param controller El controlador con el que interactuara la vista.
     */
    public Vista(ControllerInterface controller) {
        this.controller = controller;
        this.model = controller.getModel();
    }

    /**
     * Muestra el mensaje de bienvenida y las reglas del juego.
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
     * Metodo llamado por el modelo para notificar cambios.
     * Actualiza la informacion mostrada al usuario.
     */
    // @Override
    // public void actualizar() {
    //     System.out.println("-- Modelo actualizado --");
    //     System.out.println("Jugador actual: " + model.obtenerSiguienteJugador().getNombre());
    // }

    // /**
    //  * Muestra una pregunta o reto al usuario.
    //  * @param tarjeta La tarjeta que contiene la pregunta o reto.
    //  */ 
    // public void mostrarPregunta(Tarjeta tarjeta) {
    //     System.out.println("--- TARJETA ---");
    //     System.out.println(tarjeta.getPregunta());
    //     System.out.print("> Respuesta: ");
    // }

    /**
     * Muestra un mensaje general al usuario.
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirNombre(int i){
        System.out.print("Ingrese el nombre del jugador " + i + " o escriba \"fin\" para terminar:");
        String nombre = sc.nextLine();
        return nombre;
    }

    public String pedirNombre(){
        System.out.print("Ingrese el nombre del jugador 1:");
        String nombre = sc.nextLine();
        return nombre;
    }

    public String mostrarTurno(String turno){
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