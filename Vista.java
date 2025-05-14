import java.util.Scanner;

public class Vista{
    
    Controller controller;
    ModelInterface model;

    public Vista(Controller controller){
        this.controller = controller;
        this.model = controller.getModel();

    }

    public void start(){
        // Inicializa la vista
        System.out.println("BIENVENIDO A FUNADO\n");
        System.out.println("A lo largo del juego contestaran al azar sus propias preguntas y harán sus desafios");
        System.out.println("Si lo hacen ganaran puntos y si no seran castigados");
        System.out.println("Para ganar deberan juntar la mayor cantidad de puntos posibles");
        System.out.println("El juego termina cuando se agoten las preguntas o desafíos a realizar o sea acuerdo mutuo terminar");
        System.out.println("\nReglas del juego:");
        System.out.println("\nEn cada turno un jugador especifico recibe una pregunta o un desafío");
        System.out.println("Si se responde o se completa el reto se gana 1 punto");
        System.out.println("Si se decide no responder o completar el reto serán ccastigados");
        System.out.println("Un jugador castigado debe responder una pregunta Y completar un reto para ganar 1 punto");
        System.out.println("Tras dos turnos el jugador castigado se vuelve regular de nuevo");
        System.out.println("Cada cierta cantidad de turnos se activan eventos");
        System.out.println("Los eventos pueden afectar a todos los jugadores o un grupo selecto");
        System.out.println("Pueden ser cambios de estado, robo de puntos, retos especiales, etc");

        System.out.println("\nEl principal objetivo del juego es conocerse y formar lazos aún con desconocidos");
        System.out.println("por lo que la idea es sentirse comodos compartiendo sus experiencias");
        registrarJugadores();
    }

    private void registrarJugadores(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Agrega el nombre del jugador 1");
            String nombre = sc.nextLine();
            controller.registrarJugador(nombre);

            System.out.println("Agrega el nombre del jugador 2");
            nombre = sc.nextLine();
            controller.registrarJugador(nombre);

            int i = 3;
            while (true) {
                System.out.println(String.format("Agrega el nombre del jugador %d o escribe 'fin' para terminar", i));
                nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                controller.registrarJugador(nombre);
            }

            sc.close();

        } catch (Exception e) {
        }
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}