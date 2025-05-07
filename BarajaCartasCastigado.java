import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una baraja de tarjetas de castigo.
 */

import java.util.Objects;

public class BarajaCartasCastigado implements Iterable<Tarjeta>{
    /**
     * Lista de tarjetas en la baraja de castigo.
     */
    private List<Tarjeta> tarjetas;

    /**
     * Constructor para la baraja de castigo.
     */
    public BarajaCartasCastigado() {
        tarjetas = new ArrayList<>();
    }

    /**
     * Saca una tarjeta de la baraja de castigo.
     *
     * @return La tarjeta sacada de la baraja, o null si la baraja esta vacia.
     */
    public Tarjeta sacaTarjeta() {
        if (tarjetas.isEmpty()) {
            return null;
        }
        // Saca la ultima tarjeta de la lista
        return tarjetas.remove(tarjetas.size() - 1);
    }

    /**
     * Aniade una nueva tarjeta a la baraja de castigo con la pregunta especificada.
     *
     * @param pregunta La pregunta para la nueva tarjeta.
     */
    public void aniadeTarjeta(String pregunta) {
        Tarjeta nuevaTarjeta = new Tarjeta();
        nuevaTarjeta.setPregunta(pregunta);
        tarjetas.add(nuevaTarjeta);
    }

    /**
     * Elimina una tarjeta especifica de la baraja de castigo.
     *
     * @param tarjeta La tarjeta a eliminar.
     */
    public void eliminaTarjeta(Tarjeta tarjeta) {
        if (tarjetas.isEmpty()) {
            return;
        }

        for (int i = 0; i < tarjetas.size(); i++) {
            if (Objects.equals(tarjetas.get(i), tarjeta)) {
                tarjetas.remove(i);
                return;
            }
        }
    }

    @Override
    public Iterator<Tarjeta> iterator() {
        return tarjetas.iterator();
    }
}