package Exercise_2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ex_2 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Ex_2.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvenuto!");
		
		while (true) {
			System.out.print("Inserisci quanti elementi dovrà avere l'array: ");
			String input = sc.nextLine();
			
			try {
				int inputValue = Integer.parseInt(input);
				if (inputValue == 0) {
					System.out.println("Arrivederci!");
					break;
				} else {
					List<String> myList = createList(inputValue);
					System.out.println("Ecco la lista appena creata");
					myList.forEach(element -> System.out.print(element + " "));
					System.out.println();
					System.out.println();
					
					List<String> mySecondList = addAndReverse(myList);
					System.out.println("Ecco la tua lista + la tua lista in ordine inverso");
					mySecondList.forEach(el -> System.out.print(el + " "));
					System.out.println();
					System.out.println();
					
					logList(myList, true);
					System.out.println();
					System.out.println();
					logList(myList, false);
					System.out.println();
					System.out.println();
					System.out.println("FINE, Altro giro?");
				}
				System.out.println();
				
			} catch (NumberFormatException ex) {
				log.error("Input non valido!");
			}
		}
	}
	
	public static List<String> createList(int len) {
		List<String> l = new ArrayList<String>();
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			l.add(Integer.toString(rand.nextInt(100)));
		}
		return l;
	}
	
	public static List<String> addAndReverse(List<String> inputList) {
		List<String> outputList = new ArrayList<String>();
		int len = inputList.size();
		outputList = inputList;
		
		for (int i = len - 1; i >= 0; i--) {
			outputList.add(inputList.get(i));
		}
		
		return outputList;
	}
	
	public static void logList(List<String> inputList, boolean flag) {
		int len = inputList.size();
		
		if (flag) {
			System.out.println("Ecco gli elementi in posizione pari della tua lista");
			for (int i = 0; i < len; i++) {
				if (i % 2 == 0 || i == 0) {
					System.out.print(inputList.get(i) + " ");
				}
			}
		} else {
			System.out.println("Ecco gli elementi in posizione dispari della tua lista");
			for (int i = 0; i < len; i++) {
				if (i % 2 != 0) {
					System.out.print(inputList.get(i) + " ");
				}
			}
		}
	}
}





















