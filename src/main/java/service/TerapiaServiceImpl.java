package service;

import dao.FactoryDAO;
import dao.TerapiaDAO;

public class TerapiaServiceImpl implements TerapiaService {
    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    TerapiaDAO terapiaDAO =  factory.getTerapiaDAO();



}
