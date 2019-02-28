package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] Max_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int getMaxDaysOfMonth(int month) {
		return Max_days[month-1];
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR ST");
		System.out.println("--------------------");
		Calendar cal = new Calendar();
		int MaxDay = cal.getMaxDaysOfMonth(month);
		// 4 o , 4 o/100 x, 4 o/100 x/400 o
		if((year%4==0 && year%100!=0) || (year%4==0 && year%100==0 && year%400==0)) {
			if(month == 2) {
				MaxDay = 29;
			}
		}
		for(int i=1; i<=MaxDay; i++) {
			System.out.printf("%3d", i);
			if(i%7 ==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
