
import java.util.Queue;

/**
 * Clase que implementa la interfaz Iterator para una cola de Cartas.
 */
public class QueueIterator implements Iterator<Tarjeta> { 
    
    /**
     * Cola de cartas que se van a iterar.
     */
    private Queue<Tarjeta> queue;

    /**
     * Verifica si hay una siguiente carta en la cola.
     * @return true si hay una siguiente carta, false si no.
     */
    public boolean hasNext() {
        if(queue.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * Retorna la siguiente carta en la cola.
     * @return La siguiente carta en la cola.
     */
    public Tarjeta next() {
        if(queue.isEmpty()){
            return null;
        }else{
            return queue.poll();
        }
        
    }

    /**
     * Remueve la ultima carta retornada por next().
     */
    public void remove() {
    }
}