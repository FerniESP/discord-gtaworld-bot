package util;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reloj {
	
	Calendar calendario = new GregorianCalendar();
	DecimalFormat format = new DecimalFormat("00");
	
	int horas = calendario.get(Calendar.HOUR_OF_DAY);
	int minutos = calendario.get(Calendar.MINUTE);
	int segundos = calendario.get(Calendar.SECOND);
	
	public String getHora() {
		return "[" + format.format(horas) + ":" + format.format(minutos) + ":" + format.format(segundos) + "]"; 
	}
	
	
	
}
