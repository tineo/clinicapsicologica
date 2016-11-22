package dao;

import java.sql.*;

import entity.Psicologo;
import entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PsicologoMySQLFactoryDAO implements PsicologoDAO {
    private Connection connection = null;
    private Statement stmt = null;

    public PsicologoMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertarPsicologo(Psicologo psicologo) throws Exception {
        PreparedStatement psp = null;
        int last = 0;

        try {
            psp = this.connection.prepareStatement("INSERT INTO psicologo VALUES (NULL, ?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            psp.setString(1, psicologo.getEspecialidad());
            psp.setInt(2, psicologo.getCodigo_usuario());
            psp.executeUpdate();

            ResultSet rs = psp.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last;
    }

    @Override
    public List<Psicologo> listarPsicologos() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        Usuario usuario = null;
        ArrayList<Psicologo> listado = new ArrayList<Psicologo>();


        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT*FROM psicologo");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Psicologo psicologo = new Psicologo();
                psicologo.setCodigo_psicologo(rs.getInt(1));
                psicologo.setEspecialidad(rs.getString(2));
                psicologo.setCodigo_usuario(rs.getInt(3));
                listado.add(psicologo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listado;
    }

    @Override
    public List<Psicologo> buscarPsicologos(Psicologo psicologo) throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        ArrayList<Psicologo> listado = new ArrayList<Psicologo>();
        try {

            connection = this.connection;

            String sql = "SELECT * FROM psicologo p INNER JOIN usuario u ON u.codigo_usuario = p.cod_usuario ";

            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();
            //String.join(" > ", new String[]{"foo", "bar"});

            if (psicologo.getEspecialidad() != null) {
                map.put("especialidad", psicologo.getEspecialidad());
            }

            if (psicologo.getApellido_paterno() != null) {
                map.put("apellido_paterno", psicologo.getApellido_paterno());
            }

            if (psicologo.getApellido_materno() != null) {
                map.put("apellido_materno", psicologo.getApellido_materno());
            }

            if (psicologo.getNombres() != null) {
                map.put("nombres", psicologo.getNombres());
            }

            for (String param : map.keySet()) {
                params.add(param + " LIKE ?");
            }

            String[] arrParams = new String[params.size()];
            arrParams = params.toArray(arrParams);

            if (arrParams.length > 0) {
                sql += " WHERE ";
                sql += String.join(" AND ", arrParams);
            }

            System.out.println(sql);

            psmt = connection.prepareStatement(sql);
            if (arrParams.length > 0) {

                int index = 1;
                for (String value : map.values()) {
                    psmt.setString(index, "%" + value + "%");
                    index++;

                }
            }

            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.println(12);

                Psicologo p = new Psicologo();
                p.setCodigo_psicologo(rs.getInt(1));
                p.setEspecialidad(rs.getString(2));
                p.setCodigo_usuario(rs.getInt(3));

                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));

                listado.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        return listado;
    }

    @Override
    public int eliminarPsicologo(int codigo) throws Exception {
        PreparedStatement ps = null;
        int valor;
        try {
            ps = this.connection.prepareStatement("DELETE u.* FROM psicologo p INNER JOIN usuario u ON u.codigo_usuario = p.cod_usuario"
                    + "WHERE codigo_psicologo=?");
            ps.setInt(1, codigo);
            valor = ps.executeUpdate();
            return valor;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}



    

    
