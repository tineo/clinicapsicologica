package service;


import dao.FactoryDAO;
import dao.SesionDAO;
import entity.Sesion;

import java.util.List;

public class SesionServiceImpl implements SesionService {

    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    SesionDAO sesionDAO = factory.getSesionDAO();

    @Override
    public int insertar(Sesion sesion) throws Exception {
        return sesionDAO.insertar(sesion);
    }

    @Override
    public List<Sesion> listar() throws Exception {
        return sesionDAO.listar();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        return sesionDAO.eliminar(codigo);
    }

    @Override
    public List<Sesion> buscar(Sesion sesion) throws Exception {
        return sesionDAO.buscar(sesion);
    }
}
