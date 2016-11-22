package service;

import dao.FactoryDAO;
import dao.ObservacionDAO;
import entity.Observacion;

public class ObservacionServiceImpl implements ObservacionService {

    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    ObservacionDAO observacionDAO = factory.getObservacionDAO();

    public Object insertar(Observacion observacion) throws Exception {
        return observacionDAO.insertar(observacion);
    }

    public Object buscar(Observacion observacion)throws Exception {
        return observacionDAO.buscar(observacion); //To change body of generated methods, choose Tools | Templates.
    }

    public Object listar() throws Exception {
        return observacionDAO.listar(); //To change body of generated methods, choose Tools | Templates.
    }

    public Object eliminar(int codigo) throws Exception {
        return observacionDAO.eliminar(codigo); //To change body of generated methods, choose Tools | Templates.
    }



}
