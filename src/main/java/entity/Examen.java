package entity;

import java.util.Date;


public class Examen {

    int codigo_examen;
    String tipo;
    String diagnostico;
    Date fecha_realizo;
    Date fecha_entrega;

    int codigo_sesion;


    public int getCodigo_examen() {
        return codigo_examen;
    }

    public void setCodigo_examen(int codigo_examen) {
        this.codigo_examen = codigo_examen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFecha_realizo() {
        return fecha_realizo;
    }

    public void setFecha_realizo(Date fecha_realizo) {
        this.fecha_realizo = fecha_realizo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getCodigo_sesion() {
        return codigo_sesion;
    }

    public void setCodigo_sesion(int codigo_sesion) {
        this.codigo_sesion = codigo_sesion;
    }
}
