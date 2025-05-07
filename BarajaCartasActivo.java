
import java.util.ArrayList;
import java.util.List;


public class BarajaCartasActivo {
    private List<Tarjeta> tarjetas;

    public BarajaCartasActivo() {
        this.tarjetas = new ArrayList<>();
    }

    /**
     * Elimina una tarjeta de la baraja.
     *
     * @param tarjeta La tarjeta a eliminar.
     */
    public void eliminaTarjeta(Tarjeta tarjeta) {
        tarjetas.remove(tarjeta);
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public int tamanio() {
        return tarjetas.size();
    }
    public Tarjeta obtenerTarjeta(int index) {
        if (index >= 0 && index < tarjetas.size()) {
            return tarjetas.get(index);
            }
        return null;
    }
}