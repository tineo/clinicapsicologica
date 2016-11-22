package dao;

public class MySQLFactoryDAO extends FactoryDAO {

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new  UsuarioMySQLFactoryDAO();
    }

    @Override
    public PacienteDAO getPacienteDAO() {
        return new  PacienteMySQLFactoryDAO();
    }

    @Override
    public PsicologoDAO getPsicologoDAO() {
        return new PsicologoMySQLFactoryDAO();
    }

    @Override
    public DiagnosticoDAO getDiagnosticoDAO() {
        return new DiagnosticoMySQLFactoryDAO();
    }

    @Override
    public ExamenDAO getExamenDAO() {
        return new ExamenMySQLFactoryDAO();
    }

    @Override
    public MedicamentoDAO getMedicamentoDAO() {
        return new MedicamentoMySQLFactoryDAO();
    }

    @Override
    public ObservacionDAO getObservacionDAO() {
        return new ObservacionMySQLFactoryDAO();
    }

    @Override
    public SesionDAO getSesionDAO() {
        return new SesionMySQLFactoryDAO();
    }

    @Override
    public TerapiaDAO getTerapiaDAO() {
        return new TerapiaMySQLFactoryDAO();
    }

}
