package service;

import dao.FactoryDAO;
import dao.PsicologoDAO;
import entity.Psicologo;
import java.util.List;

public class PsicologoServiceImpl implements PsicologoService{

    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    PsicologoDAO psicologoDAO = factory.getPsicologoDAO();


    @Override
    public int insertarPsicologo(Psicologo psicologo)  throws Exception{
        return psicologoDAO.insertarPsicologo(psicologo);
    }

    @Override
    public List<Psicologo> listarPsicologos() throws Exception {
       return psicologoDAO.listarPsicologos();}

    @Override
    public List<Psicologo> buscarPsicologos(Psicologo psicologo) throws Exception {
        return psicologoDAO.buscarPsicologos(psicologo);
    }

    @Override
    public int eliminarPsicologo(int codigo) throws Exception {
       return psicologoDAO.eliminarPsicologo(codigo);
    }
}
