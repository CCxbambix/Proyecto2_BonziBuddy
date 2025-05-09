import java.util.Random;
/**
 * Clase que representa a el estado Castigado del jugador
 */
public class Castigado implements EstadoJugador{
 
    /**
     * Atributo que representa a el jugador
     */
    private Jugador jugador;

    /**Instancia de la clase Random */
    private Random random = new Random();

    /**
     * Metodo constructor de la clase
     * @param Jugador para crear es estado Castigado
     */
    public Castigado (Jugador jugador){
        this.jugador = jugador;
    }

    /**
     * Metodo que obtiene la siguiente pregunta para el jugador de la baraja Castigado
     * Se obtiene la lista de Tarjeta para obtener un elemento de la lista, se usa un metodo que devuelve un numero
     * random entre 0 y la longitud de la lista, se usa el +1 porque el metodo no incluye el ultimo numero,
     * asi se asegura que pueda salir tambien la ultima Tarjeta
     * @return Tarjeta de la baraja Castigado 
     */
    public Tarjeta obtenerSiguientePregunta(){
        Tarjeta siguienteTarjeta = jugador.getBarajaCastigado().get(random.nextInt(jugador.getBarajaRegular().size()+1));
        return siguienteTarjeta;
    }

    /**
     * Metodo que borrar la pregunta mostrada del mazo
     */
    public void borrarPregunta(Tarjeta tarjeta){
        jugador.getBarajaCastigado().remove(tarjeta);
    }

    
}