package util;

import entity.Medicamento;
import spark.Request;

public class MedicamentoRequestDraw extends Medicamento {

    private Request request;

    public MedicamentoRequestDraw(Request request) {
        this.request = request;

        if(this.request.queryParams("codigo_medicamento")!=null)
            super.setCodigo_medicamento(Integer.parseInt(this.request.queryParams("codigo_medicamento")));

        super.setNombre(this.request.queryParams("nombre"));

        super.setDosis(this.request.queryParams("dosis"));

        super.setUnidad(this.request.queryParams("unidad"));

        if(this.request.queryParams("lapso")!=null)
            super.setLapso(Integer.parseInt(this.request.queryParams("lapso")));

        super.setIntervalo(this.request.queryParams("intervalo"));

        if(this.request.queryParams("codigo_observacion")!=null)
            super.setCodigo_observacion(Integer.parseInt(this.request.queryParams("codigo_observacion")));
    }
}
