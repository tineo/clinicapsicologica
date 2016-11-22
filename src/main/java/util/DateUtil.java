package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tineo on 26/06/16.
 */
public class DateUtil {

    public DateUtil(){

    }

    public List<Date> addMinutes(Date fecha, int minutes){

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MINUTE, minutes);
        //String newTime = df.format(cal.getTime());
        List<Date> lista = new ArrayList<Date>();
        lista.add(cal.getTime());
        return lista;

    }


}
