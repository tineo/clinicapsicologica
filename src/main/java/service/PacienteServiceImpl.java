package service;


import dao.FactoryDAO;
import dao.PacienteDAO;
import dao.UsuarioDAO;
import entity.Paciente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteServiceImpl implements PacienteService {


    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    PacienteDAO pacienteDAO = factory.getPacienteDAO();

    @Override
    public int insertarPaciente(Paciente paciente) throws Exception {
        return pacienteDAO.insertarPaciente(paciente);
    }

    @Override
    public List<Paciente> listarPaciente() throws Exception {
       return pacienteDAO.listarPacientes();
    }

    @Override
    public int eliminarPaciente(int codigo) throws Exception{
     
            return pacienteDAO.eliminarPaciente(codigo);
        
        
    }

    @Override
    public List<Paciente> buscarPacientes(Paciente paciente) throws Exception {
            return pacienteDAO.buscarPacientes(paciente);
    }
    
}
