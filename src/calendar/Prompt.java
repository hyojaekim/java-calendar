package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		boolean result = true;
		while(result){
			System.out.println("명령(1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1" :
				cmdRegister(scanner, cal);
				break;
			case "2" :
				cmdSearch(scanner, cal);
				break;
			case "3" :
				printCal(scanner, cal);
				break;
			case "h" :
				printHelp();
				break;
			case "q" :
				result = false;
				break;
			}
		}
		System.out.println("exit!!");
		scanner.close();
	}

	private void printHelp() {
		// TODO Auto-generated method stub
		
	}

	private void cmdSearch(Scanner s, Calendar c) throws ParseException {
		System.out.println("날짜를 입력하세요(yyyy-mm-dd) : ");
		String strDate = s.next();
		
		c.getPlan(strDate);
	}

	private void cmdRegister(Scanner s, Calendar c) {
		System.out.println("날짜를 입력하세요(yyyy-mm-dd) : ");
		String strDate = s.next();
		System.out.println("일정을 등록하세요 : ");
		String plan = "";
		s.nextLine();
		plan = s.nextLine();
		c.setRegister(strDate, plan);
		System.out.println("일정이 등록되었습니다!");
	}

	private void printCal(Scanner s, Calendar c) {
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

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
