package entity;


public class Paciente extends Usuario {

    int codigo_paciente;
    String tipo;


    public int getCodigo_paciente() { return codigo_paciente; }

    public void setCodigo_paciente(int codigo_paciente) { this.codigo_paciente = codigo_paciente; }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
