/*
 * State es una clase abstracta que define los métodos necesarios para gestionar los distintos estados de un reproductor multimedia.
 */
package state;

public abstract class State {

    Player player; // El reproductor asociado a este estado

    // Constructor de la clase State
    State(Player player) {
        this.player = player;
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    public abstract String onLock(); // Acción de bloqueo

    public abstract String onPlay(); // Acción de reproducción

    public abstract String onNext(); // Acción de siguiente

    public abstract String onPrevious(); // Acción de anterior
}
