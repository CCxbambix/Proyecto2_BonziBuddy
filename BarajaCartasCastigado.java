import java.util.Arrays;

public class BarajaCartasCastigado {
    /**
     * Array de tarjetas en la baraja de castigo.
     */
    private Tarjeta[] tarjetas;

    /**
     * Crea y devuelve un nuevo objeto ArrayIterator<Tarjeta>.
     * @return un nuevo objeto ArrayIterator<Tarjeta>.
     */
    public Iterator<Tarjeta> crearIterador() {
        return new ArrayIterator(tarjetas);
    }
/**
 * Elimina una tarjeta específica de la baraja de castigo.
 *
 * @param tarjeta La tarjeta a eliminar.
 */
public void eliminaTarjeta(Tarjeta tarjeta) {
    if (tarjetas == null) {
        return; // No hay tarjetas para eliminar
    }
    for (int i = 0; i < tarjetas.length; i++) {
        if (tarjetas[i] != null && tarjetas[i].equals(tarjeta)) {
            for (int j = i; j < tarjetas.length - 1; j++) {
                tarjetas[j] = tarjetas[j + 1];
            }
            tarjetas[tarjetas.length - 1] = null; 
            break;
        }
    }
}
}