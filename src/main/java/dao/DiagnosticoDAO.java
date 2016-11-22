package dao;

import entity.Diagnostico;

import java.util.List;

public interface DiagnosticoDAO {
    int insertar(Diagnostico diagnostico) throws Exception;
    List<Diagnostico> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Diagnostico> buscar(Diagnostico diagnostico) throws Exception;
}
