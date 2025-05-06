/**
 * Clase que representa una tarjeta con una pregunta.
 */
public class Tarjeta implements Clonable {

    /**
     * La pregunta contenida en la tarjeta.
     */
    private String pregunta;

    /**
     * Obtiene la pregunta contenida en la tarjeta.
     * @return La pregunta de la tarjeta.
     */
    public String getPregunta(){
        return this.pregunta;
    }

    /**
     * Establece la pregunta de la tarjeta.
     * @param pregunta La nueva pregunta para la tarjeta.
     */
    public void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }

    /**
     * Otorga puntos al jugador especificado.
     * @param jugador El jugador al que se le daran los puntos.
     */
    public void darPuntos(Jugador jugador) {
    }

    /**
     * Crea una copia de esta tarjeta.
     * @return Una copia de esta tarjeta.
     */
    @Override
    public Object clone() {
        return null;
    }
}