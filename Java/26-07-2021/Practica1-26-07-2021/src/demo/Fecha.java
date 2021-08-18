package demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar fecha;

    public Fecha(GregorianCalendar fecha)
    {
        this.fecha = fecha;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public String verificacionFecha(GregorianCalendar fecha)
    {
        String fechaCorrecta = "correcta";

        if(!this.fecha.equals(fecha)) fechaCorrecta = "incorrecta";

        return fechaCorrecta;
    }

    public GregorianCalendar adicionDia()
    {
        this.fecha.add(Calendar.DAY_OF_MONTH,1);

        return this.fecha;
    }
}
