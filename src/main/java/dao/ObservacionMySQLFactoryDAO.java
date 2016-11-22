package dao;


import entity.Observacion;
import entity.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class ObservacionMySQLFactoryDAO implements ObservacionDAO {
    
    private Connection connection = null;
    private Statement stmt = null;

    public ObservacionMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }
    @Override
    public int insertar(Observacion observacion) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO sesion VALUES (NULL, ?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, observacion.getDescripcion());
            ps.setString(2, observacion.getNivel_importancia());            
            ps.setString(3, observacion.getSintoma());
            ps.setInt(4, observacion.getCodigo_sesion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last;
    }

    @Override
    public List<Observacion> listar() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        ArrayList<Observacion> listado = new ArrayList<Observacion>();

        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM paciente");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Observacion observacion = new Observacion();
                observacion.setCodigo_observacion(rs.getInt(1));
                observacion.setDescripcion(rs.getString(2));
                observacion.setNivel_importancia(rs.getString(3));
                observacion.setSintoma(rs.getString(4));
                observacion.setCodigo_sesion(rs.getInt(4));

                listado.add(observacion);

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
    public int eliminar(int codigo) throws Exception {
        PreparedStatement ps = null;
        int valor;
        try {
            ps = this.connection.prepareStatement("DELETE FROM observacion "
                    + "WHERE codigo_observacion = ?");
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
    public List<Observacion> buscar(Observacion observacion) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Observacion> listado = new ArrayList<Observacion>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM observacion";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();

            if (observacion.getDescripcion()!= null) {
                map.put("observacion", observacion.getDescripcion());
            }

            if (observacion.getNivel_importancia()!= null) {
                map.put("nivel_importancia", observacion.getNivel_importancia());
            }

            if (observacion.getSintoma()!= null) {
                map.put("sintoma", observacion.getSintoma());
            }

            if (observacion.getCodigo_sesion()!= 0) {
                map.put("codigo_sesion", String.valueOf(observacion.getCodigo_sesion()));
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
                Observacion o = new Observacion();
                o.setCodigo_observacion(rs.getInt("codigo"));
                o.setDescripcion(rs.getString("descripcion"));
                o.setNivel_importancia(rs.getString("Nivel deImportancia"));
                o.setSintoma(rs.getString("Sintomas"));
                o.setCodigo_sesion(rs.getInt("CodigoSecion"));
                

                listado.add(o);

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
