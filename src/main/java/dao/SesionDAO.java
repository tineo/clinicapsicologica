package dao;

import entity.Sesion;

import java.util.List;

public interface SesionDAO {
    int insertar(Sesion sesion) throws Exception;
    List<Sesion> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Sesion> buscar(Sesion sesion) throws Exception;
}
