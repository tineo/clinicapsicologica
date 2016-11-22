package service;


import entity.Psicologo;
import java.util.List;

public interface PsicologoService {
    int insertarPsicologo(Psicologo psicologo) throws Exception;
        List<Psicologo> listarPsicologos() throws Exception;
        List<Psicologo> buscarPsicologos(Psicologo psicologo) throws Exception;
        int eliminarPsicologo(int codigo) throws Exception;
}
