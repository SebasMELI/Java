package clases;

public class Time {

    private long horaInicio;
    private long horaFinal;

    public long getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    public long getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(long horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void start(){
        this.horaInicio = System.currentTimeMillis();
    }

    public void stop(){
        this.horaFinal = System.currentTimeMillis();
    }

    public long elapsedTime(){
        return this.horaInicio - this.horaFinal;
    }
}
