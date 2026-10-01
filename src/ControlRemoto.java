public class ControlRemoto {
    ReproductorAudio reproductorAudio;

    public ControlRemoto(ReproductorAudio reproductorAudio) {
        this.reproductorAudio = reproductorAudio;
    }

    public void play() {
        reproductorAudio.play();
    }
    public void pause() {
        reproductorAudio.pause();
    }

    public void volumen(int volumenNuevo) {
        reproductorAudio.cambiarVolume(volumenNuevo);
    }
}
