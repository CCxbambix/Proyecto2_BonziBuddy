/**
 * Interfaz que define el rol de Observador en el patron Observer.
 * Un Observador es un objeto que desea ser notificado de los cambios en el estado de un Sujeto.
 * En este contexto, los Jugadores actuan como Observadores y el Modelo como Sujeto.
 */
public interface Observador{
    /**
     * Metodo llamado por el Sujeto para notificar al observador de un cambio en su estado.
     * El observador debe implementar la logica necesaria para responder a la actualizacion.
     */
    public void actualizar();

}