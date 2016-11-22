package service;

import entity.Usuario;

import java.util.ArrayList;


public interface UsuarioService {

    public abstract Usuario buscarUsuario(String username) throws Exception;

    public abstract ArrayList<Usuario> listarUsuarios(Usuario usuario) throws Exception;

    public abstract int insertarUsuario(Usuario usuario) throws Exception;

    public abstract void modificarUsuario(Usuario usuario) throws Exception;

    public abstract boolean validarUsuario(String username, String password) throws Exception;
}
