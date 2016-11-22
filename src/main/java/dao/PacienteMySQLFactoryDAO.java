package dao;

import entity.Paciente;
import entity.Psicologo;
import entity.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PacienteMySQLFactoryDAO implements PacienteDAO {
    private Connection connection = null;
    private Statement stmt = null;

    public PacienteMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertarPaciente(Paciente paciente) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO paciente VALUES (NULL, ?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getTipo());
            ps.setInt(2, paciente.getCodigo_usuario());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(1);
            }

            paciente.setCodigo_usuario(last);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //psmt = connection.prepareStatement("SELECT * FROM usuario WHERE nombre = ?")

        return last;
    }

    @Override
    public List<Paciente> listarPacientes() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        ArrayList<Paciente> listado = new ArrayList<Paciente>();


        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM paciente");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodigo_paciente(rs.getInt(1));
                paciente.setTipo(rs.getString(2));
                paciente.setCodigo_usuario(rs.getInt(3));

                listado.add(paciente);

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
    public int eliminarPaciente(int codigo) throws Exception {

        PreparedStatement ps = null;
        int valor;
        try {
            ps = this.connection.prepareStatement("DELETE u.*,p.* FROM usuario u INNER JOIN paciente p ON u.codigo_usuario= p.codigo_usuario  "
                    + "WHERE codigo_paciente = ?");
            ps.setInt(1, codigo);
            valor = ps.executeUpdate();
            if (valor > 0) {
                //el valor se ha eliminado
                return valor;
            } else return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public List<Paciente> buscarPacientes(Paciente paciente) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Paciente> listado = new ArrayList<Paciente>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM paciente p INNER JOIN usuario u ON u.codigo_usuario= p.codigo_usuario";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();

            if (paciente.getNombres() != null) {
                map.put("nombres", paciente.getNombres());
            }

            if (paciente.getApellido_paterno() != null) {
                map.put("apellido_paterno", paciente.getApellido_paterno());
            }

            if (paciente.getApellido_materno() != null) {
                map.put("apellido_materno", paciente.getApellido_materno());
            }

            if (paciente.getTipo() != null) {
                map.put("tipo", paciente.getTipo());
            }

            if (paciente.getCodigo_paciente() != 0) {
                map.put("codigo_paciente", String.valueOf(paciente.getCodigo_paciente()));

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
            System.out.printf(sql);
            ps = connection.prepareStatement(sql);
            if (arrParams.length > 0) {
                int index = 1;
                for (String value : map.values()) {
                    ps.setString(index, "%" + value + "%");
                    index++;

                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setCodigo_paciente(rs.getInt(1));
                p.setTipo(rs.getString(2));
                p.setCodigo_usuario(3);

                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setEmail(rs.getString("email"));

                listado.add(p);

            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listado;
        }


    }


}
