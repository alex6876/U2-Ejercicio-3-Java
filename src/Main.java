public class Main {
    public static void main(String[] args) {
        ReproductorAudio reproductor = new ReproductorAudio();
        ControlRemoto control = new ControlRemoto(reproductor);

        System.out.println("=========== Sistema de Reproductor ============");

        control.play();
        control.volumen(75);
        control.pause();
    }
}