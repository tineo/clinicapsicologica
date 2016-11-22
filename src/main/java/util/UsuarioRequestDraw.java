package util;

import entity.Usuario;
import spark.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioRequestDraw extends Usuario {

    private Request request;

    public UsuarioRequestDraw(Request request) throws ParseException {
        this.request = request;

        if(this.request.queryParams("codigo_usuario")!=null)
            super.setCodigo_usuario(Integer.parseInt(this.request.queryParams("codigo_usuario")));

        super.setUsername(this.request.queryParams("username"));

        super.setPassword(this.request.queryParams("password"));

        super.setNombres(this.request.queryParams("nombres"));

        super.setApellido_paterno(this.request.queryParams("apellido_paterno"));

        super.setApellido_materno(this.request.queryParams("apellido_materno"));

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        if(this.request.queryParams("fecha_nacimiento")!=null)
            super.setFecha_nacimiento(formatter.parse(this.request.queryParams("fecha_nacimiento")));

        super.setDireccion(this.request.queryParams("direccion"));

        super.setEmail(this.request.queryParams("email"));
    }
}
