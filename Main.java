

public class Main{
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);
        controller.iniciarPartida();
    }
}