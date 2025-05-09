import java.util.Random;
/**
 * Clase que representa a el estado regular de un usuario
 */
public class Regular implements EstadoJugador{

    /**Atributo que representa a el jugador  */
    private Jugador jugador;

    /**Instancia de la clase Random */
    private Random random = new Random();

    /**
     * Constructor de la clase
     * @param Jugador 
     */
    public Regular (Jugador jugador){
        this.jugador = jugador;
    }

    /**
     * Metodo que obtiene la siguiente pregunta para el jugador de la baraja Regular
     * Se obtiene la lista de Tarjeta para obtener un elemento de la lista, se usa un metodo que devuelve un numero
     * random entre 0 y la longitud de la lista, se usa el +1 porque el metodo no incluye el ultimo numero,
     * asi se asegura que pueda salir tambien la ultima Tarjeta
     * @return Tarjeta de la baraja Regular
     */
    public Tarjeta obtenerSiguientePregunta(){
        Tarjeta siguienteTarjeta = jugador.getBarajaRegular().get(random.nextInt(jugador.getBarajaRegular().size()+1));
        return siguienteTarjeta;
    }

    /**
     * Borra la Tarjeta que se mostro de la baraja correspondiente
     */
    public void borrarPregunta(Tarjeta tarjeta){
        jugador.getBarajaRegular().remove(tarjeta);
    }
}