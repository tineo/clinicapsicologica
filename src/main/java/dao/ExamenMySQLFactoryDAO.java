package dao;

import entity.Examen;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamenMySQLFactoryDAO implements ExamenDAO {

    private Connection connection = null;
    private Statement stmt = null;

    public ExamenMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertar(Examen examen) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO examen VALUES (NULL, ?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, examen.getTipo());
            ps.setString(2, examen.getDiagnostico());
            ps.setDate(3, new Date(examen.getFecha_realizo().getTime()));
            ps.setDate(4, new Date(examen.getFecha_entrega().getTime()));
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
    public List<Examen> listar() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Examen> listado = new ArrayList<Examen>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM examen ";

            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Examen d = new Examen();
                d.setCodigo_examen(rs.getInt("codigo_examen"));
                d.setTipo(rs.getString("tipo"));
                d.setFecha_realizo(rs.getDate("fecha_realizo"));
                d.setFecha_entrega(rs.getDate("fecha_entrega"));
                listado.add(d);
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

    @Override
    public int eliminar(int codigo) throws Exception {
        PreparedStatement ps = null;
        int valor;
        try {
            ps = this.connection.prepareStatement("DELETE FROM examen WHERE codigo_examen = ?");
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
    public List<Examen> buscar(Examen examen) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Examen> listado = new ArrayList<Examen>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM examen ";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();


            if (examen.getCodigo_examen() != 0) {
                map.put("codigo_examen", String.valueOf(examen.getCodigo_examen()));
            }

            if (examen.getTipo() != null) {
                map.put("tipo", examen.getTipo());
            }

            if (examen.getDiagnostico() != null) {
                map.put("diagnostico", examen.getDiagnostico());
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (examen.getFecha_realizo() != null) {
                map.put("fecha_realizo",  df.format(examen.getFecha_realizo()) );
            }

            if (examen.getFecha_entrega() != null) {
                map.put("fecha_entrega", df.format(examen.getFecha_entrega()) );
            }

            for (String param : map.keySet()) {
                if (param.contains("codigo")) {
                    params.add(param + " = ?");
                } else {
                    params.add(param + " LIKE ?");
                }
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
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().contains("codigo")) {
                        ps.setString(index, entry.getValue());
                    } else {
                        ps.setString(index, "%" + entry.getValue() + "%");
                    }
                    index++;
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Examen d = new Examen();
                d.setCodigo_examen(rs.getInt("codigo_examen"));
                d.setTipo(rs.getString("tipo"));
                d.setFecha_realizo(rs.getDate("fecha_realizo"));
                d.setFecha_entrega(rs.getDate("fecha_entrega"));
                listado.add(d);
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
