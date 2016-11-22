package dao;



public abstract class FactoryDAO {

    public static final int TXT_FACTORY = 1;
    public static final int MYSQL_FACTORY = 2;

    public abstract UsuarioDAO getUsuarioDAO();
    public abstract PacienteDAO getPacienteDAO();
    public abstract PsicologoDAO getPsicologoDAO();

    public abstract DiagnosticoDAO getDiagnosticoDAO();
    public abstract ExamenDAO getExamenDAO();
    public abstract MedicamentoDAO getMedicamentoDAO();
    public abstract ObservacionDAO getObservacionDAO();
    public abstract SesionDAO getSesionDAO();
    public abstract TerapiaDAO getTerapiaDAO();


    public static FactoryDAO getFactory(int claveFactory){
        switch(claveFactory){
            case TXT_FACTORY:
                return null;//new TxtFactoryDao();
            case MYSQL_FACTORY:
                return new MySQLFactoryDAO();
            default:
                throw new IllegalArgumentException();
        }
    }
}
