/**
 * Clase que representa el controlador en el patron MVC.
 */
public class Controller {
    /**
     * Interfaz del modelo que el controlador usa.
     */
    final private ModelInterface model;
    final private Vista vista;

    /**
     * Constructor del controlador.
     * @param model El modelo que el controlador usara.
     * @param vista La vista que el controlador usara.
     */
    public Controller(ModelInterface model) {
        this.model = model;
        this.vista = new Vista(this);
        model.iniciarPartida();
    }
}