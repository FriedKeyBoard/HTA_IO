package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 날짜를 'yyyy-MM-DD'
	 * @param date
	 * @return
	 */
	public static String toText(Date date) {
		if (date == null) {
			return "";
		}
		String formattedText = YYYYMMDD.format(date);
		return formattedText;
	}
	
	public static Date toDate(String text) {
		if(text == null) {
			return null;
		}
		try {
			return YYYYMMDD.parse(text);
		}catch(ParseException ex) {
			throw new RuntimeException("["+text+"]", ex);
		}
	}
}
