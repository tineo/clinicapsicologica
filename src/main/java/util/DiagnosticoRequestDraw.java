package util;

import entity.Diagnostico;
import spark.Request;

public class DiagnosticoRequestDraw extends Diagnostico {

    private Request request;

    public DiagnosticoRequestDraw(Request request) {
        this.request = request;

        if(this.request.queryParams("fecha_nacimiento")!=null)
            super.setCodigo_diagnostico(Integer.parseInt(this.request.queryParams("codigo_diagnostico")));

        super.setDescripcion(this.request.queryParams("descripcion"));

        super.setSinopsis(this.request.queryParams("sinopsis"));

        if(this.request.queryParams("fecha_nacimiento")!=null)
            super.setCodigo_terapia(Integer.parseInt(this.request.queryParams("codigo_terapia")));
    }
}
