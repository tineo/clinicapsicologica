package service;


import dao.DiagnosticoDAO;
import dao.FactoryDAO;

public class DiagnosticoServiceImpl implements DiagnosticoService {
    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    DiagnosticoDAO diagnosticoDAO = factory.getDiagnosticoDAO();




}
