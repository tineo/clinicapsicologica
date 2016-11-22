package service;

import dao.FactoryDAO;
import dao.MedicamentoDAO;

public class MedicamentoServiceImpl implements MedicamentoService{

    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    MedicamentoDAO medicamentoDAO = factory.getMedicamentoDAO();





}
