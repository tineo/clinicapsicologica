package entity;


public class Diagnostico {

    int codigo_diagnostico;
    String descripcion;
    String sinopsis;

    int codigo_terapia;

    public int getCodigo_diagnostico() {
        return codigo_diagnostico;
    }

    public void setCodigo_diagnostico(int codigo_diagnostico) {
        this.codigo_diagnostico = codigo_diagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getCodigo_terapia() {
        return codigo_terapia;
    }

    public void setCodigo_terapia(int codigo_terapia) {
        this.codigo_terapia = codigo_terapia;
    }
}
