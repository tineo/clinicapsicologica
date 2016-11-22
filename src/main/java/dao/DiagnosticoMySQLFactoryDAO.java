package dao;

import entity.Diagnostico;
import entity.Sesion;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagnosticoMySQLFactoryDAO implements DiagnosticoDAO {
    private Connection connection = null;
    private Statement stmt = null;


    public DiagnosticoMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertar(Diagnostico diagnostico) throws Exception {
        PreparedStatement psp = null;
        int last = 0;

        try {
            psp = this.connection.prepareStatement("INSERT INTO diagnostico VALUES (NULL, ?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            psp.setString(1, diagnostico.getDescripcion());
            psp.setString(2, diagnostico.getSinopsis());
            psp.setInt(3, diagnostico.getCodigo_terapia());
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
    public List<Diagnostico> listar() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        ArrayList<Diagnostico> listado = new ArrayList<Diagnostico>();


        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM diagnostico");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.setCodigo_diagnostico(rs.getInt(1));
                diagnostico.setDescripcion(rs.getString(2));
                diagnostico.setSinopsis(rs.getString(3));
                diagnostico.setCodigo_terapia(rs.getInt(4));
                listado.add(diagnostico);
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
            ps = this.connection.prepareStatement("DELETE FROM diagnostico WHERE codigo_diagnostico=?");
            ps.setInt(1, codigo);
            valor = ps.executeUpdate();
            return valor;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Diagnostico> buscar(Diagnostico diagnostico) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Diagnostico> listado = new ArrayList<Diagnostico>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM diagnostico ";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();


            if (diagnostico.getCodigo_diagnostico() != 0) {
                map.put("codigo_diagnostico", String.valueOf(diagnostico.getCodigo_diagnostico()));
            }

            if (diagnostico.getDescripcion() != null) {
                map.put("descripcion", diagnostico.getDescripcion());
            }

            if (diagnostico.getSinopsis() != null) {
                map.put("sinopsis", diagnostico.getSinopsis());
            }

            if (diagnostico.getCodigo_terapia() != 0) {
                map.put("codigo_terapia", String.valueOf(diagnostico.getCodigo_terapia()));
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
                Diagnostico d = new Diagnostico();
                d.setCodigo_diagnostico(rs.getInt("codigo_diagnostico"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setSinopsis(rs.getString("sinopsis"));
                d.setCodigo_terapia(rs.getInt("codigo_terapia"));

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
