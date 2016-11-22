package util;

import entity.Examen;
import spark.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ExamenRequestDraw extends Examen{
    private Request request;

    public ExamenRequestDraw(Request request) throws ParseException {
        this.request = request;

        if(this.request.queryParams("codigo_examen")!=null)
            super.setCodigo_examen(Integer.parseInt(this.request.queryParams("codigo_examen")));

        super.setTipo(this.request.queryParams("tipo"));

        super.setDiagnostico(this.request.queryParams("diagnostico"));

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        if(this.request.queryParams("fecha_realizo")!=null)
            super.setFecha_realizo(formatter.parse(this.request.queryParams("fecha_realizo")));

        if(this.request.queryParams("fecha_entrega")!=null)
            super.setFecha_entrega(formatter.parse(this.request.queryParams("fecha_entrega")));

        if(this.request.queryParams("codigo_examen")!=null)
            super.setCodigo_sesion(Integer.parseInt(this.request.queryParams("codigo_examen")));
    }
}
