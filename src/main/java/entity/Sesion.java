package entity;

import java.util.Date;

public class Sesion {
    int codigo_sesion;
    Date fecha_creacion;
    Date fecha_reunion;
    String estado;
    String lugar;
    int duracion;

    int codigo_paciente;
    int codigo_psicologo;


    public int getCodigo_sesion() {
        return codigo_sesion;
    }

    public void setCodigo_sesion(int codigo_sesion) {
        this.codigo_sesion = codigo_sesion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_reunion() {
        return fecha_reunion;
    }

    public void setFecha_reunion(Date fecha_reunion) {
        this.fecha_reunion = fecha_reunion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getDuracion() { return duracion; }

    public void setDuracion(int duracion) { this.duracion = duracion; }


    public int getCodigo_paciente() { return codigo_paciente; }

    public void setCodigo_paciente(int codigo_paciente) { this.codigo_paciente = codigo_paciente; }

    public int getCodigo_psicologo() {
        return codigo_psicologo;
    }

    public void setCodigo_psicologo(int codigo_psicologo) {
        this.codigo_psicologo = codigo_psicologo;
    }
}
