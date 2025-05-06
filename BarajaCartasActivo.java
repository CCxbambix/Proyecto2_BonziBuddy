import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;


public class BarajaCartasActivo {
    private List<Tarjeta> tarjetas;

    public BarajaCartasActivo() {
        this.tarjetas = new ArrayList<>();
    }

    /**
     * Crea y regresa un nuevo iterador para la lista de tarjetas.
     * @return Un nuevo iterador para las tarjetas.
     */
    public Iterator<Tarjeta> crearIterador() {
        return new ListIterator(this.tarjetas);
    }

    public void eliminaTarjeta(Tarjeta tarjeta) {
        if (tarjetas.contains(tarjeta)) {
            tarjetas.remove(tarjeta);
        }
    }
}