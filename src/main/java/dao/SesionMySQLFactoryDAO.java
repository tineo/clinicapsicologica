package dao;

import entity.Sesion;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SesionMySQLFactoryDAO implements SesionDAO {
    private Connection connection = null;
    private Statement stmt = null;

    public SesionMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertar(Sesion sesion) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO sesion VALUES (NULL, ?,?,?,?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, new java.sql.Timestamp(sesion.getFecha_creacion().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(sesion.getFecha_reunion().getTime()));

            ps.setString(3, sesion.getEstado());
            ps.setString(4, sesion.getLugar());
            ps.setInt(5, sesion.getCodigo_paciente());
            ps.setInt(6, sesion.getCodigo_psicologo());
            ps.setInt(7, sesion.getDuracion());

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
    public List<Sesion> listar() throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;

        ArrayList<Sesion> listado = new ArrayList<Sesion>();

        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM sesion");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {

                Sesion sesion = new Sesion();
                sesion.setCodigo_sesion(rs.getInt("codigo_sesion"));
                sesion.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                sesion.setFecha_reunion(rs.getTimestamp("fecha_reunion"));
                sesion.setEstado(rs.getString("estado"));
                sesion.setLugar(rs.getString("lugar"));
                sesion.setCodigo_paciente(rs.getInt("codigo_paciente"));
                sesion.setCodigo_psicologo(rs.getInt("codigo_psicologo"));
                sesion.setDuracion(rs.getInt("duracion"));

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
            ps = this.connection.prepareStatement("DELETE FROM sesion WHERE codigo_sesion = ?");
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
    public List<Sesion> buscar(Sesion sesion) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Sesion> listado = new ArrayList<Sesion>();
        try {
            connection = this.connection;
            String sql = "SELECT * FROM sesion ";
            ArrayList<String> params = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<>();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

            if (sesion.getFecha_creacion() != null) {
                map.put("fecha_creacion",  df2.format(sesion.getFecha_creacion()) );
            }

            if (sesion.getFecha_reunion() != null) {
                map.put("fecha_reunion",  df2.format(sesion.getFecha_reunion()) );
            }

            if (sesion.getEstado() != null) {
                map.put("estado", sesion.getEstado() );
            }

            if (sesion.getLugar() != null) {
                map.put("lugar", sesion.getLugar());
            }

            if (sesion.getCodigo_paciente() != 0) {
                map.put("codigo_paciente", String.valueOf(sesion.getCodigo_paciente()));
            }

            if (sesion.getCodigo_psicologo() != 0) {
                map.put("codigo_psicologo", String.valueOf(sesion.getCodigo_psicologo()));
            }
            if (sesion.getDuracion() != 0) {
                map.put("duracion", String.valueOf(sesion.getDuracion()));
            }
            for (String param : map.keySet()) {
                if(param.contains("codigo")){
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

            sql +=" ORDER BY fecha_reunion ASC";
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
                Sesion s = new Sesion();
                s.setCodigo_sesion(rs.getInt("codigo_sesion"));
                s.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                s.setFecha_reunion(rs.getTimestamp("fecha_reunion"));
                s.setEstado(rs.getString("estado"));
                s.setLugar(rs.getString("lugar"));
                s.setCodigo_paciente(rs.getInt("codigo_paciente"));
                s.setCodigo_psicologo(rs.getInt("codigo_psicologo"));
                s.setDuracion(rs.getInt("duracion"));
                listado.add(s);
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
