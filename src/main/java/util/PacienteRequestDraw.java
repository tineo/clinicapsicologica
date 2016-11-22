package util;

import entity.Paciente;
import spark.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PacienteRequestDraw extends Paciente{
    private Request request;

    public PacienteRequestDraw(Request request) throws ParseException {
        this.request = request;

        if(this.request.queryParams("apellido_materno")!=null)
            super.setApellido_materno(this.request.queryParams("apellido_materno"));
        if(this.request.queryParams("nombres")!=null)
            super.setNombres(this.request.queryParams("nombres"));
        if(this.request.queryParams("apellido_paterno")!=null)
            super.setApellido_paterno(this.request.queryParams("apellido_paterno"));

        if(this.request.queryParams("codigo_paciente")!=null)
            super.setCodigo_paciente(Integer.parseInt(this.request.queryParams("codigo_paciente")));
        super.setTipo(this.request.queryParams("tipo"));
        if(this.request.queryParams("codigo_usuario")!=null)
            super.setCodigo_usuario(Integer.parseInt(this.request.queryParams("codigo_usuario")));
        super.setUsername(this.request.queryParams("username"));
        super.setPassword(this.request.queryParams("password"));


        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        if(this.request.queryParams("fecha_nacimiento")!=null)
            super.setFecha_nacimiento(formatter.parse(this.request.queryParams("fecha_nacimiento")));

        super.setDireccion(this.request.queryParams("direccion"));
        super.setEmail(this.request.queryParams("email"));

    }
}
