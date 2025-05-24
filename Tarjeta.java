/**
 * Representa una tarjeta en el juego, conteniendo una pregunta.
 * Implementa Cloneable para permitir la creacion de copias de las tarjetas.
 */
public class Tarjeta implements Cloneable {
    private String pregunta;

    /**
     * Constructor por defecto de la clase Tarjeta.
     */
    public Tarjeta() {
    }

    /**
     * Constructor de copia para crear una nueva tarjeta a partir de otra existente.
     * @param otra La tarjeta a copiar.
     */
    private Tarjeta(Tarjeta otra) {
        this.pregunta = otra.pregunta;
    }

    /**
     * Obtiene la pregunta asociada a esta tarjeta.
     * @return La cadena de texto de la pregunta.
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Establece la pregunta para esta tarjeta.
     * @param pregunta La cadena de texto de la pregunta a establecer.
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * Crea y devuelve una copia exacta de esta tarjeta.
     * @return Una nueva instancia de Tarjeta que es una copia de esta tarjeta.
     */
    @Override
    public Tarjeta clone() {
        return new Tarjeta(this);
    }
}