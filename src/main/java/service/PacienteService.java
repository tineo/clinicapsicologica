package service;

import entity.Paciente;
import java.util.List;

public interface PacienteService {

    int insertarPaciente(Paciente paciente) throws Exception;
    List<Paciente> listarPaciente() throws Exception;
    int eliminarPaciente(int codigo)throws Exception;
    List<Paciente> buscarPacientes(Paciente paciente) throws Exception;
}
