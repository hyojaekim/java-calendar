package calendar;

import java.util.Scanner;

public class Prompt {
	
	public int parseDay(String week) {
		if(week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else 
			return 0;
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = -1;
		int year = -1;
		int weekday = 0;
		while(true){
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if(year == -1) {
				break;
			}
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			System.out.println("요일을 입력하세요.(su, mo, tu, we, th, fr, sa)");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			
			if(month == -1) {
				break;
			}
			if(month > 12) {
				continue;
			}
			
			cal.printCalendar(year, month, weekday);
		}
		
		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
