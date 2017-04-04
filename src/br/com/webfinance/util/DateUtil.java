package br.com.webfinance.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {

	/**
	 * 
	 * @return day
	 */
	public static int getDayCurrent(){
		int day;
		GregorianCalendar date = new GregorianCalendar();
		day = date.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 
	 * @return month
	 */
	public static int getMonthCurrent(){
		int month;
		GregorianCalendar date = new GregorianCalendar();
		month = date.get(Calendar.MONTH);
		month = month + 1;
		return month;
	}
	
	/**
	 * 
	 * @return year
	 */
	public static int getYearCurrent(){
		int year;
		GregorianCalendar date = new GregorianCalendar();
		year = date.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 
	 * @param date in format yyyy-MM-dd
	 * @return Calendar
	 */
	public static Calendar formatDate(String date){
		if(date == null || date.equals("")){
			throw new NullPointerException("Não foi inserido a data...");
		}
		
		Calendar calendar = Calendar.getInstance();
		
		try{
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
			calendar.setTime(format.parse(date));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return calendar;
	}
	
	public static String formatDate(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Calendar c = (Calendar) obj;
		
		String formattedTime = sdf.format(c.getTime());
		
		int colon = formattedTime.length()-2;
		
		formattedTime = formattedTime.substring(0,colon) + formattedTime.substring(colon);
		
		return formattedTime;
	}
}
