package calendar;

import java.util.Scanner;

public class Prompt {
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = -1;
		int year = -1;

		while(true){
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if(year == -1)
				break;
			
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			
			if(month == -1 || month > 12)
				break;
			
			cal.printCalendar(year, month);
		}
		System.out.println("exit!!");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
