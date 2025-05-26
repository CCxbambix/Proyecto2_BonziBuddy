/**
 * Interfaz que define las operaciones de la capa de vista en el juego.
 * Es implementada por la clase Vista para mostrar informacion
 * y recibir entradas del usuario.
 */
public interface VistaInterface {

    /**
     * Muestra el mensaje de bienvenida y las reglas basicas del juego.
     */
    void mostrarBienvenida();

    /**
     * Muestra un mensaje general al usuario.
     *
     * @param mensaje el texto a mostrar
     */
    void mostrarMensaje(String mensaje);

    /**
     * Solicita el nombre del primer jugador.
     *
     * @return el nombre ingresado por el usuario
     */
    String pedirNombre();

    /**
     * Solicita el nombre del jugador numero i o la palabra "fin" para terminar.
     *
     * @param i el numero de orden del jugador
     * @return el nombre ingresado o "fin"
     */
    String pedirNombre(int i);

    /**
     * Muestra el contenido del turno (pregunta o reto) y
     * pregunta si fue completado correctamente.
     *
     * @param turno el texto con la tarjeta a mostrar
     * @return "Si" o "No" segun la respuesta del usuario
     */
    String mostrarTurno(String turno);

    /**
     * Pregunta si el evento especial fue completado por los jugadores.
     *
     * @return "Si" o "No" segun la respuesta del usuario
     */
    String mostrarEvento();

    /**
     * Pregunta al anfitrion si desea continuar con el juego.
     *
     * @return "Si" o "No" segun la respuesta del usuario
     */
    String continuarJuego();
}
