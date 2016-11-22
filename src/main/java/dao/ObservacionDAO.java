package dao;

import entity.Observacion;

import java.util.List;

public interface ObservacionDAO {
    int insertar(Observacion observacion) throws Exception;
    List<Observacion> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Observacion> buscar(Observacion observacion) throws Exception;
}
