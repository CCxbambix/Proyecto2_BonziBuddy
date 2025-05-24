/**
 * Interfaz que define el rol de Sujeto en el patron Observer.
 * Un Sujeto es un objeto que mantiene una lista de observadores y les notifica automaticamente
 * de cualquier cambio en su estado, generalmente llamando a uno de sus metodos.
 * En este contexto, el Modelo actua como Sujeto, y los Jugadores actuan como Observadores.
 */
public interface Sujeto {
    /**
     * Registra un observador (Jugador) para recibir notificaciones de cambios en el estado del sujeto.
     * @param jugador El jugador que desea registrarse como observador.
     */
    public void registrarJugador(Jugador jugador);
    /**
     * Registra un observador (Jugador) especificamente en la lista de regulares para notificaciones dirigidas.
     * @param jugador El jugador que desea registrarse en la lista de regulares.
     */
    public void registrarRegular(Jugador jugador);
    /**
     * Registra un observador (Jugador) especificamente en la lista de castigados para notificaciones dirigidas.
     * @param jugador El jugador que desea registrarse en la lista de castigados.
     */
    public void registrarCastigado(Jugador jugador);
    /**
     * Elimina un observador (Jugador) de la lista de regulares para que deje de recibir notificaciones dirigidas a ese grupo.
     * @param jugador El jugador que desea ser eliminado de la lista de regulares.
     */
    public void eliminarRegular(Jugador jugador);
    /**
     * Elimina un observador (Jugador) de la lista de castigados para que deje de recibir notificaciones dirigidas a ese grupo.
     * @param jugador El jugador que desea ser eliminado de la lista de castigados.
     */
    public void eliminarCastigado(Jugador jugador);
    /**
     * Notifica a todos los observadores registrados (Jugadores) sobre un cambio en el estado del sujeto.
     * Cada observador respondera a la notificacion llamando a su metodo de actualizacion.
     */
    public void notificarTodos();
    /**
     * Notifica solo a los observadores (Jugadores) registrados como regulares sobre un cambio.
     */
    public void notificarRegulares();
    /**
     * Notifica solo a los observadores (Jugadores) registrados como castigados sobre un cambio.
     */
    public void notificarCastigados();
}