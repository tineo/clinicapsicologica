package dao;

import entity.Paciente;
import java.util.List;

public interface PacienteDAO {

    int insertarPaciente(Paciente paciente) throws Exception;
    List<Paciente> listarPacientes() throws Exception;
    int eliminarPaciente(int codigo) throws Exception;
    List<Paciente> buscarPacientes(Paciente paciente) throws Exception;
    
    
}
