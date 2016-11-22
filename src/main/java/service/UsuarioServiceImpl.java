package service;

import dao.FactoryDAO;
import dao.UsuarioDAO;
import entity.Usuario;

import java.util.ArrayList;


public class UsuarioServiceImpl implements  UsuarioService{

    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    UsuarioDAO usuarioDAO = factory.getUsuarioDAO();


    @Override
    public Usuario buscarUsuario(String username) throws Exception {
        return usuarioDAO.buscarUsuario(username);
    }

    @Override
    public ArrayList<Usuario> listarUsuarios(Usuario usuario) throws Exception {
        return usuarioDAO.listarUsuarios(usuario);
    }

    @Override
    public int insertarUsuario(Usuario usuario) throws Exception {
        return usuarioDAO.insertarUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws Exception {
        usuarioDAO.modificarUsuario(usuario);

    }

    @Override
    public boolean validarUsuario(String username, String password) throws Exception {
        return usuarioDAO.validarUsuario(username, password);
    }
}
