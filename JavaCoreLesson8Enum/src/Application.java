import java.util.Scanner;

import com.javacore.l9.customException.WrongInputConsoleParametersException;

/**
 * @since java 1.8
 * @author annashcherbyna
 * @version 1.1
 */

public class Application {
	
	/**
	 * @param no input params
	 * @exception WrongInputConsoleParametersException
	 * @author Anna Shcherbyna
	 * @return results of methods in menu
	 * @see java code covention
	 **/
	
	/*var num of days in a month*/
	private int day;
	
	/*var for season*/
	Season season;
	

	public static void menu() {
		System.out.println("0. If month exist");
		System.out.println("1. All month with the same season");
		System.out.println("2. All month with the same number of days");
		System.out.println("3. All month with less number of days");
		System.out.println("4. All month with more number of days");
		System.out.println("5. Next season");
		System.out.println("6. Previous season");
		System.out.println("7. Even days month");
		System.out.println("8. Odd days month");
		System.out.println("9. If month has even days");
		System.out.println("==========================================");
	}
	
	public static void caseTwo(Month[] monthArray) throws WrongInputConsoleParametersException{
		System.out.println("Enter a number of days");
		
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(System.in);
		int numOfDays = sc.nextInt();
		
		if(numOfDays>=28 && numOfDays<=31) {
			for (Month m : monthArray) {
				if (m.getDay() == numOfDays) {
					System.out.println(m.name());
				}
			}
		}else {
			throw new WrongInputConsoleParametersException("There is no month with " + numOfDays + " days.");
		}
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		int choice;
		Month[] monthArray = Month.values();
		Season[] seasonArray = Season.values();
		Scanner sc = new Scanner(System.in);


		while (true) {
			menu();
			boolean flag = false;
			
			switch (sc.next()) {
			case "0":
				System.out.println("Enter a month");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();
				for (Month m : monthArray) {
					if (m.name().equals(month)) {
						System.out.println("Month " + m.name() + " exists");
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("Month DOESN'T exist");
				}
				break;
				
			case "1":
				System.out.println("Enter a season");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();
				for (Month m : monthArray) {
					if (m.getSeason().name().equals(season)) {
						System.out.println(m.name());
					}
				}
				break;

			// the same num of days
			case "2":
				caseTwo(monthArray);
				break;

			// the less num of days
			case "3":
				System.out.println("Enter a number of days");
				sc = new Scanner(System.in);
				int numOfDays = sc.nextInt();
				numOfDays = sc.nextInt();
				for (Month m : monthArray) {
					if (m.getDay() < numOfDays) {
						System.out.println(m.name());
					}
				}
				break;
				
			// more days
			case "4":
				System.out.println("Enter a number of days");
				sc = new Scanner(System.in);
				numOfDays = sc.nextInt();
				for (Month m : monthArray) {
					if (m.getDay() > numOfDays) {
						System.out.println(m.name());
					}
				}
				break;

			// the next season
			case "5":
				System.out.println("Enter a season");
				sc = new Scanner(System.in);
				season = sc.next().toUpperCase();
				Season s = Season.valueOf(season);
				if (s.ordinal() < seasonArray.length - 1) {
					System.out.println(seasonArray[s.ordinal() + 1]);
				} else {
					System.out.println(seasonArray[s.ordinal() - 3]);
				}
				break;
				
			// the previous season
			case "6":
				System.out.println("Enter a season");
				sc = new Scanner(System.in);
				season = sc.next().toUpperCase();
				s = Season.valueOf(season);
				if (s.ordinal() == 0) {
					System.out.println(seasonArray[seasonArray.length - 1]);
				} else {
					System.out.println(seasonArray[s.ordinal() - 1]);
				}
				break;
			
			// months which have even num of days
			case "7":
				for (Month m : monthArray) {
					if ((m.getDay() % 2) == 0) {
						System.out.println(m.name());
					}
				}
				break;
				
			// months which have odd num of days
			case "8":
				for (Month m : monthArray) {
					if ((m.getDay() % 2) != 0) {
						System.out.println(m.name());
					}
				}
				break;
				
			case "9":
				System.out.println("Enter a month to check if it has even num od fays");
				sc = new Scanner(System.in);
				month = sc.next().toUpperCase();
				Month m = Month.valueOf(month);
				if ((m.getDay() % 2) == 0) {
					System.out.println(m.name() + "has even num of days - " + m.getDay());
				} else {
					System.out.println(m.name() + " DOESN'T even num of days - " + m.getDay());
				}
				break;
			}
		}
	}
}
