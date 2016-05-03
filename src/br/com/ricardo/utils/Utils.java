package br.com.ricardo.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

	public static String FormataDataBanco(String data) {
		Date dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataBanco = new SimpleDateFormat("yyyy-mm-dd").format(dateFormat);		
		return dataBanco;
	}
		
	public static String FormataDataApp(String data) {
		Date dateFormat = null;
		
		try {
			dateFormat = new SimpleDateFormat("yyyy-mm-dd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String dataApp = new SimpleDateFormat("dd/mm/yyyy").format(dateFormat);
		return dataApp;
	}

}
