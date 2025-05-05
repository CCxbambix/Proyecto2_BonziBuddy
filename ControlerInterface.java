public interface ControlerInterface {
    void procesadorRespuesta(Jugador j, Respuesta r);
    void pasarTurno();
    void reforzarEstado(Jugador j);
}