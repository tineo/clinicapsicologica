package dao;

import entity.Terapia;

import java.util.List;

public class TerapiaMySQLFactoryDAO implements TerapiaDAO {
    @Override
    public int insertar(Terapia terapia) throws Exception {
        return 0;
    }

    @Override
    public List<Terapia> listar() throws Exception {
        return null;
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        return 0;
    }

    @Override
    public List<Terapia> buscar(Terapia terapia) throws Exception {
        return null;
    }
}
