package entity;

import java.text.ParseException;
import java.util.Date;

public class Terapia {
    int codigo_terapia;
    Date fecha_inicio;

    String codigo_paciente;
    int codigo_psicologo;

    public int getCodigo_terapia() {
        return codigo_terapia;
    }

    public void setCodigo_terapia(int codigo_terapia) {
        this.codigo_terapia = codigo_terapia;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) throws ParseException {
        this.fecha_inicio = fecha_inicio;
    }


    public String getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(String codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public int getCodigo_psicologo() {
        return codigo_psicologo;
    }

    public void setCodigo_psicologo(int codigo_psicologo) {
        this.codigo_psicologo = codigo_psicologo;
    }
}
