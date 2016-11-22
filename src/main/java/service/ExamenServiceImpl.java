package service;

import dao.ExamenDAO;
import dao.FactoryDAO;


public class ExamenServiceImpl implements ExamenService {
    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    ExamenDAO examenDAO = factory.getExamenDAO();





}
