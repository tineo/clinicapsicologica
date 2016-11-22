package dao;


import entity.Terapia;

import java.util.List;

public interface TerapiaDAO {
    int insertar(Terapia terapia) throws Exception;
    List<Terapia> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Terapia> buscar(Terapia terapia) throws Exception;

}
