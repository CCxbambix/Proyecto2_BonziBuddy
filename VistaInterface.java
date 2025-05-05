/**
 * Esta interfaz define los metodos que debe tener la vista en el patron MVC.
 */
public interface VistaInterface {
    /**
     * Este metodo actualiza la vista.
     */
    void actualizar();

    /**
     * Este metodo muestra una pregunta.
     * @param p la pregunta que se va a mostrar.
     */
    void mostrarPregunta(Pregunta p);
}