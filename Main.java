//Esta es la clase principal que inicia el juego.
public class Main{
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);
        controller.iniciarPartida();
    }
}