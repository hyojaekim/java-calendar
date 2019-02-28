package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] Max_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int getMaxDaysOfMonth(int month) {
		return Max_days[month-1];
	}
	
	public static void SamepleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while(true){
			System.out.println("월을 입력하세요.");
			System.out.print("input> ");
			int month = scanner.nextInt();
			if(month < 1) {
				System.out.println("end!!");
				break;
			}else if(month > 12) {
				continue;
			}else {
				System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
			}
		}
		
		scanner.close();
		
	}
}
