package com.mkyong.test;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class TimeMilisecond {
  public static void main(String[] argv) throws ParseException, InterruptedException {
 
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String dateInString = "10-03-2015 10:20:56";
	Date date = sdf.parse(dateInString);
 
	System.out.println(dateInString);
	System.out.println("Date - Time in milliseconds : " + date.getTime());
 
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	System.out.println("Calender - Time in milliseconds : " + date.getTime());
    System.out.println(System.currentTimeMillis());

	Thread.sleep(1000);
    System.out.println(System.currentTimeMillis());

	System.out.println("Calender - Time in milliseconds : " + date.getTime());
 
  }
}