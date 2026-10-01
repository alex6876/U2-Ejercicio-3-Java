public class ReproductorAudio {
    int volumenActual;
    String estado;

    public ReproductorAudio() {
        this.volumenActual = 50;
        this.estado = "Detenido";
    }

    public void play(){
        estado = "Reproduciendose";
        System.out.println("audio reproduciendose");
    }

    public void pause(){
        if (estado.equals("Reproduciendose")){
            estado = "Pausado";
            System.out.println("audio pausado");
        }else {
            estado = "no se peude pausar, porque está pausado";
        }
    }

    public void  cambiarVolume(int nuevoVolumen){
        if (volumenActual >= 0 && volumenActual <= 100){
            volumenActual = nuevoVolumen;
            System.out.println("Volumen cambiado a: " + volumenActual);
        }else  {
            System.out.println("El volumen debe ser de 0% a 100%");
        }
    }
}
