package dao;

import entity.Medicamento;

import java.util.List;

public interface MedicamentoDAO {
    int insertar(Medicamento medicamento) throws Exception;
    List<Medicamento> listar() throws Exception;
    int eliminar(int codigo) throws Exception;
    List<Medicamento> buscar(Medicamento medicamento) throws Exception;
}
