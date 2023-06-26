package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

		public static void main (String[] args)
		{
				System.out.println("Hello World!");
				System.out.println(moltiplica(2, 5));
				System.out.println(concatena("Quanti anni ho? ", 28));
				System.out.println(inserisciInArray(new String[] {"Num 1", "Num 2", "Num 3", "Num 4", "Num 5"}, "Test inserimento")[2]);
				
				Scanner sc = new Scanner(System.in);
				System.out.print("Il tuo nome: ");
				String name = sc.nextLine();
				System.out.print("Il tuo cognome: ");
				String lastname = sc.nextLine();
				System.out.print("La tua eta': ");
				String age = sc.nextLine();
				
				System.out.println("Nome " + name + " - Cognome " + lastname + " - Anni " + age);
				System.out.println("Anni " + age + " - Nome " + name + " - Cognome " + lastname);
				
				System.out.println("Ora calcoliamo il perimetro di un rettangolo.");
				System.out.print("La base del rettangolo: ");
				double br = sc.nextDouble();
				System.out.print("L'altezza del rettangolo: ");
				double hr = sc.nextDouble();
				System.out.println("Il perimetro è " + perimetroRettangolo(br, hr));
				
				System.out.println("Ora calcoliamo l'area di un triangolo.");
				System.out.print("La base del triangolo: ");
				double bt = sc.nextDouble();
				System.out.print("L'altezza del triangolo: ");
				double ht = sc.nextDouble();
				System.out.println("L'area è " + areaTriangolo(bt, ht));
				sc.close();
				System.out.print("Grazie e arriivederci.. :)");
		}
		
		public static int moltiplica (int x, int y) {
			return x + y;
		}
		
		public static String concatena (String str, int num) {
			return str + num;
		}
		
		public static String[] inserisciInArray (String[] arr, String val) {
			String[] newArr = {arr[0], arr[1], val, arr[2], arr[3], arr[4]};
			return newArr;
		}
		
		public static double perimetroRettangolo (double b, double h) {
			return 2 * (b + h);
		}
		
		public static int pariDispari(int num) {
			int res;
			int module = num % 2;
			if (module == 0)
				res = 0;
			else
				res = 1;
			return res;
		}
		
		public static double areaTriangolo(double b, double h) {
			return (b * h) / 2;
		}
}















