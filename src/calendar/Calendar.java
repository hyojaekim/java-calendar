package calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String SAVE_FILE = "calendar.dat";
	private HashMap<Date, planItem> map;
	
	public Calendar() {
		map = new HashMap<Date, planItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists()) {
			System.err.println("No File!!");
			return;
		}
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(", ");
				String date = words[0];
				String detail = words[1];
				planItem p = new planItem(date, detail);
				map.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean isLeapYear(int year) {
		if(year%4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		}else {
			return MAX_DAYS[month-1];
		}
	}
	
	public void printCalendar(int year, int month) {
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR ST");
		System.out.println("----------------------");
		int MaxDay = getMaxDaysOfMonth(year, month);
		
		int weekday = getWeekDay(year, month);
		for(int i=0; i<weekday; i++) {
			System.out.print("   ");
		}
		
		for(int i=1; i<=MaxDay; i++) {
			System.out.printf("%3d", i);
			if((i+weekday)%7 ==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public int getWeekDay(int year, int month) {
		int syear = 1970;
		int cnt = 0;
		for(int i=syear; i<year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			cnt+=delta;
		}
		for(int i=1; i<month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			cnt += delta;
		}
		cnt = cnt + 1;
		int weekday = (cnt+3)%7;
		
		return weekday;
	}
	
	void printCal(Scanner s, Calendar c) {
		int month = 1;
		int year = 2017;
			
		System.out.print("YEAR> ");
		year = s.nextInt();
			
		System.out.print("MONTH> ");
		month = s.nextInt();
			
		if(month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
		}else {
			c.printCalendar(year, month);
		}
	}
	
	public void setRegister(String strDate, String plan) {
		planItem p = new planItem(strDate, plan);
		map.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public planItem getPlan(String strDate){
		Date date = planItem.getDateFromPlan(strDate);
		return map.get(date);
	}
}
