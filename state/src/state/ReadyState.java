/*
 * ReadyState representa el estado de un reproductor multimedia cuando está listo para reproducir una pista.
 * En este estado, el usuario puede bloquear el reproductor, iniciar la reproducción de una pista o detener la reproducción.
 */
package state;

public class ReadyState extends State {

    // Constructor de la clase ReadyState
    public ReadyState(Player player) {
        // Llama al constructor de la superclase State y pasa el objeto player.
        super(player);
    }

    // Método llamado cuando se activa la acción de bloqueo.
    @Override
    public String onLock() {
        // Cambia el estado del reproductor a LockedState.
        player.changeState(new LockedState(player));
        // Devuelve un mensaje indicando que el reproductor está bloqueado.
        return "Bloqueado...";
    }

    // Método llamado cuando se activa la acción de reproducir.
    @Override
    public String onPlay() {
        // Obtiene la acción de inicio de reproducción del reproductor.
        String action = player.startPlayback();
        // Cambia el estado del reproductor a PlayingState.
        player.changeState(new PlayingState(player));
        // Devuelve la acción de inicio de reproducción.
        return action;
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
