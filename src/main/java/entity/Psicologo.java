package entity;


public class Psicologo extends Usuario{
    int codigo_psicologo;
    String especialidad;

    public int getCodigo_psicologo() {
        return codigo_psicologo;
    }

    public void setCodigo_psicologo(int codigo_psicologo) {
        this.codigo_psicologo = codigo_psicologo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
