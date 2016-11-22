package dao;


import entity.Medicamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentoMySQLFactoryDAO implements MedicamentoDAO {

    private Connection connection = null;
    private Statement stmt = null;

    public MedicamentoMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }


    @Override
    public int insertar(Medicamento medicamento) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO medicamento VALUES (NULL,?,?,?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medicamento.getNombre());
            ps.setString(2, medicamento.getDosis());
            ps.setString(3, medicamento.getUnidad());
            ps.setInt(4, medicamento.getLapso());
            ps.setString(5, medicamento.getIntervalo());
            ps.setInt(6, medicamento.getCodigo_observacion());
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
    public List<Medicamento> listar() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;

        ArrayList<Medicamento> listado = new ArrayList<Medicamento>();

        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM medicamento ");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {

                Medicamento sesion = new Medicamento();
                sesion.setCodigo_medicamento(rs.getInt("codigo_mantenimiento"));
                sesion.setNombre(rs.getString("nombre"));
                sesion.setDosis(rs.getString("dosis"));
                sesion.setUnidad(rs.getString("unidad"));
                sesion.setLapso(rs.getInt("lapso"));
                sesion.setIntervalo(rs.getString("intervalo"));
                sesion.setCodigo_observacion(rs.getInt("codigo_observacion"));
                listado.add(sesion);

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
            ps = this.connection.prepareStatement("DELETE FROM medicamento WHERE codigo_medicamento = ?");
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
    public List<Medicamento> buscar(Medicamento medicamento) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Medicamento> listado = new ArrayList<Medicamento>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM medicamento ";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();

            if (medicamento.getCodigo_medicamento() != 0) {
                map.put("codigo_medicamento", String.valueOf(medicamento.getCodigo_medicamento()));
            }

            if (medicamento.getNombre() != null) {
                map.put("nombre", medicamento.getNombre() );
            }

            if (medicamento.getDosis() != null) {
                map.put("dosis", medicamento.getDosis());
            }

            if (medicamento.getUnidad() != null) {
                map.put("unidad", medicamento.getUnidad() );
            }

            if (medicamento.getLapso() != 0) {
                map.put("lapso", String.valueOf(medicamento.getLapso()));
            }

            if (medicamento.getIntervalo() != null) {
                map.put("intervalo", medicamento.getIntervalo() );
            }

            if (medicamento.getCodigo_observacion() != 0) {
                map.put("codigo_observacion", String.valueOf(medicamento.getCodigo_observacion()));
            }

            for (String param : map.keySet()) {
                if(param.contains("codigo")||params.contains("lapso")){
                    params.add(param + " = ?");
                }else{
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
                for (Map.Entry<String, String> entry  : map.entrySet()) {
                    if(entry.getKey().contains("codigo")){
                        ps.setString(index, entry.getValue());
                    }else{
                        ps.setString(index, "%" + entry.getValue() + "%");
                    }
                    index++;
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento m = new Medicamento();
                m.setCodigo_medicamento(rs.getInt("codigo_medicamento"));
                m.setNombre(rs.getString("nombre"));
                m.setDosis(rs.getString("dosis"));
                m.setUnidad(rs.getString("unidad"));
                m.setLapso(rs.getInt("lapso"));
                m.setIntervalo(rs.getString("intervalo"));
                m.setCodigo_observacion(rs.getInt("codigo_observacion"));
                listado.add(m);
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
