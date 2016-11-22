package util;

import entity.Paciente;
import entity.Psicologo;
import entity.Terapia;
import spark.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TerapiaRequestDraw extends Terapia {

    private Request request;

    public TerapiaRequestDraw(Request request) throws ParseException {
        this.request = request;

        if(this.request.queryParams("codigo_terapia")!=null)
            super.setCodigo_terapia(Integer.parseInt(this.request.queryParams("codigo_terapia")));

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        if(this.request.queryParams("fecha_inicio")!=null)
            super.setFecha_inicio(formatter.parse(this.request.queryParams("fecha_inicio")));

        super.setCodigo_paciente(this.request.queryParams("codigo_paciente"));

        if(this.request.queryParams("codigo_psicologo")!=null)
            super.setCodigo_psicologo(Integer.parseInt(this.request.queryParams("codigo_psicologo")));
    }
}
