package dao;

import entity.Examen;

import java.util.List;

public interface ExamenDAO {
    int insertar(Examen examen) throws Exception;
    List<Examen> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Examen> buscar(Examen examen) throws Exception;
}
