package dao;

import entity.Psicologo;
import java.util.List;

public interface PsicologoDAO {
    int insertarPsicologo(Psicologo psicologo) throws Exception;
    List<Psicologo> listarPsicologos() throws Exception;
    int eliminarPsicologo(int codigo) throws Exception;
    List<Psicologo> buscarPsicologos(Psicologo psicologo) throws Exception;

}