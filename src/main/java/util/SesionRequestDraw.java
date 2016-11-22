package util;

import entity.Sesion;
import spark.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class SesionRequestDraw extends Sesion {
    Request request;

    public SesionRequestDraw(Request request) throws ParseException {
        this.request = request;

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        if (this.request.queryParams("codigo_sesion") != null)
            super.setCodigo_sesion(Integer.parseInt(this.request.queryParams("codigo_sesion")));


        if (this.request.queryParams("fecha_creacion") != null)
            super.setFecha_creacion(formatter.parse(this.request.queryParams("fecha_creacion")));

        if (this.request.queryParams("fecha_reunion") != null)
            super.setFecha_reunion(formatter.parse(this.request.queryParams("fecha_reunion")));

        super.setEstado(this.request.queryParams("estado"));

        super.setLugar(this.request.queryParams("lugar"));

        if (this.request.queryParams("duracion") != null)
            super.setDuracion(Integer.parseInt(this.request.queryParams("duracion")));

        if (this.request.queryParams("codigo_paciente") != null)
            super.setCodigo_paciente(Integer.parseInt(this.request.queryParams("codigo_paciente")));

        if (this.request.queryParams("codigo_psicologo") != null)
            super.setCodigo_psicologo(Integer.parseInt(this.request.queryParams("codigo_psicologo")));

    }
}
