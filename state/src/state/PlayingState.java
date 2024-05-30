/*
 * PlayingState representa el estado de un reproductor multimedia cuando está reproduciendo una pista.
 * En este estado, el usuario puede pausar la reproducción, avanzar a la siguiente pista o retroceder a la pista anterior.
 */
package state;

public class PlayingState extends State {

    // Constructor de la clase PlayingState
    PlayingState(Player player) {
        // Llama al constructor de la superclase State y pasa el objeto player.
        super(player);
    }

    // Método llamado cuando se activa la acción de bloqueo.
    @Override
    public String onLock() {
        // Cambia el estado del reproductor a LockedState.
        player.changeState(new LockedState(player));
        // Establece la pista actual al principio después de detener la reproducción.
        player.setCurrentTrackAfterStop();
        // Devuelve un mensaje indicando que se ha detenido la reproducción.
        return "Dejar de reproducir";
    }

    // Método llamado cuando se activa la acción de reproducir.
    @Override
    public String onPlay() {
        // Cambia el estado del reproductor a ReadyState.
        player.changeState(new ReadyState(player));
        // Devuelve un mensaje indicando que la reproducción está en pausa.
        return "Pausado...";
    }

    // Método llamado cuando se activa la acción de siguiente.
    @Override
    public String onNext() {
        // Llama al método nextTrack() del reproductor para avanzar a la siguiente pista.
        return player.nextTrack();
    }

    // Método llamado cuando se activa la acción de anterior.
    @Override
    public String onPrevious() {
        // Llama al método previousTrack() del reproductor para retroceder a la pista anterior.
        return player.previousTrack();
    }
}
