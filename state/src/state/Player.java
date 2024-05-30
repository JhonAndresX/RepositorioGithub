/*
 * Player representa un reproductor multimedia con capacidad para cambiar de estado, reproducir, pausar y avanzar o retroceder entre pistas.
 */
package state;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private State state; // Estado actual del reproductor
    private boolean playing = false; // Indica si el reproductor está reproduciendo
    private List<String> playlist = new ArrayList<>(); // Lista de pistas en la lista de reproducción
    private int currentTrack = 0; // Índice de la pista actual

    // Constructor de la clase Player
    public Player() {
        // Establece el estado inicial del reproductor como ReadyState
        this.state = new ReadyState(this);
        // Inicializa el reproductor en estado de reproducción
        setPlaying(true);
        // Crea una lista de reproducción con 12 pistas
        for (int i = 1; i <= 12; i++) {
            playlist.add("Pista " + i);
        }
    }

    // Método para cambiar el estado del reproductor
    public void changeState(State state) {
        this.state = state;
    }

    // Método para obtener el estado actual del reproductor
    public State getState() {
        return state;
    }

    // Método para establecer si el reproductor está reproduciendo
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    // Método para verificar si el reproductor está reproduciendo
    public boolean isPlaying() {
        return playing;
    }

    // Método para iniciar la reproducción de la pista actual
    public String startPlayback() {
        return "Reproduciendo " + playlist.get(currentTrack);
    }

    // Método para avanzar a la siguiente pista en la lista de reproducción
    public String nextTrack() {
        currentTrack++;
        // Si se llega al final de la lista de reproducción, se vuelve al principio
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Reproduciendo " + playlist.get(currentTrack);
    }

    // Método para retroceder a la pista anterior en la lista de reproducción
    public String previousTrack() {
        currentTrack--;
        // Si se está en el inicio de la lista de reproducción, se pasa al final
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Reproduciendo " + playlist.get(currentTrack);
    }

    // Método para establecer la pista actual al principio después de detener la reproducción
    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
