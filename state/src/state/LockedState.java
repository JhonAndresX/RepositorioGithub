
package state;

public class LockedState extends State {

    // Método constructor para crear una nueva instancia de LockedState.
    LockedState(Player player) {
        // Llama al constructor de la superclase State y pasa el objeto player.
        super(player);
        // Establece el atributo playing del objeto player en false, indicando que no está reproduciendo.
        player.setPlaying(false);
    }

    // Método llamado cuando se activa la acción de bloqueo.
    @Override
    public String onLock() {
        // Si el reproductor está reproduciendo actualmente
        if (player.isPlaying()) {
            // Cambia el estado del reproductor a ReadyState.
            player.changeState(new ReadyState(player));
            // Devuelve un mensaje indicando que el reproductor ha dejado de reproducir.
            return "Dejar de reproducir";
        } else {
            // Si el reproductor no está reproduciendo, devuelve un mensaje indicando que está bloqueado.
            return "Bloqueado...";
        }
    }

    // Método llamado cuando se activa la acción de reproducir.
    @Override
    public String onPlay() {
        // Cambia el estado del reproductor a ReadyState.
        player.changeState(new ReadyState(player));
        // Devuelve un mensaje indicando que el reproductor está listo.
        return "Listo";
    }

    // Método llamado cuando se activa la acción de siguiente.
    @Override
    public String onNext() {
        // Devuelve un mensaje indicando que el reproductor está bloqueado y no puede avanzar a la siguiente pista.
        return "Bloqueado...";
    }

    // Método llamado cuando se activa la acción de anterior.
    @Override
    public String onPrevious() {
        // Devuelve un mensaje indicando que el reproductor está bloqueado y no puede retroceder a la pista anterior.
        return "Bloqueado...";
    }
}
