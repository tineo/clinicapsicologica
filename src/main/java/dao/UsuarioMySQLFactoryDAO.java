package dao;

import entity.Usuario;

import java.sql.*;
import java.util.ArrayList;


public class UsuarioMySQLFactoryDAO implements UsuarioDAO{

    private Connection connection  = null;
    private Statement stmt = null;

    public UsuarioMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public boolean validarUsuario(String username, String password) {
        Connection connection  = null;
        PreparedStatement psmt= null;

        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM usuario WHERE username = ? AND password = ?");
            psmt.setString(1,username);
            psmt.setString(2,password);
            ResultSet rs = psmt.executeQuery();

            if (!rs.next()) {
                return false;
            }
            else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Usuario buscarUsuario(String nombre) {
        Connection connection  = null;
        Statement stmt = null;
        PreparedStatement psmt= null;

        Usuario usuario = null;

        try {
            connection = this.connection;

            stmt = connection.createStatement();
            //stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            //stmt.executeUpdate("INSERT INTO usuario VALUES ('debra','debra',987894)");
            //ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

            psmt = connection.prepareStatement("SELECT * FROM usuario WHERE username = ?");
            psmt.setString(1,nombre);
            ResultSet rs = psmt.executeQuery();


            ArrayList<String> output = new ArrayList<String>();

            while (rs.next()) {
                //output.add( "Read from DB: " + rs.getTimestamp("tick"));

                System.out.println(rs.getString(1));

                usuario =  new Usuario();
                usuario.setNombres(rs.getString(1));
                usuario.setUsername(rs.getString(2));
                usuario.setPassword(rs.getString(3));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        return usuario;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios(Usuario usuario){
        Connection connection  = null;
        Statement stmt = null;
        PreparedStatement psmt= null;

        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        connection = this.connection;

        return null;

    }

    @Override
    public int insertarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO usuario VALUES (NULL, ?,?,?,?,?,?,?,1,NOW(),?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,usuario.getNombres());
            ps.setString(2,usuario.getPassword());
            ps.setString(3,usuario.getApellido_paterno());
            ps.setString(4,usuario.getApellido_materno());
            ps.setDate(5, new Date(usuario.getFecha_nacimiento().getTime()));
            ps.setString(6,usuario.getDireccion());
            ps.setString(7,usuario.getEmail());
            ps.setString(8,usuario.getUsername());

            ps.executeUpdate();




            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(1);
            }
            System.out.println(last);
            usuario.setCodigo_usuario(last);





        } catch (SQLException e) {
            e.printStackTrace();
        }


        //psmt = connection.prepareStatement("SELECT * FROM usuario WHERE nombre = ?")

        return last;

    }

    @Override
    public void modificarUsuario(Usuario usuario) {

    }
}
