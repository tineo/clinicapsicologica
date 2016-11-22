package entity;


public class Observacion {
    int codigo_observacion;
    String descripcion;
    String nivel_importancia;
    String sintoma;

    int codigo_sesion;


    public int getCodigo_observacion() { return codigo_observacion; }

    public void setCodigo_observacion(int codigo_observacion) { this.codigo_observacion = codigo_observacion; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel_importancia() {
        return nivel_importancia;
    }

    public void setNivel_importancia(String nivel_importancia) {
        this.nivel_importancia = nivel_importancia;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getCodigo_sesion() {
        return codigo_sesion;
    }

    public void setCodigo_sesion(int codigo_sesion) {
        this.codigo_sesion = codigo_sesion;
    }
}
