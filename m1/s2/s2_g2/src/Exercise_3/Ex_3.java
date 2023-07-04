package Exercise_3;

public class Ex_3 {

	public static void main(String[] args) {
		Rubrica.setContact("Marko", "3336669990");
		Rubrica.setContact("LizZo", "6669990001");
		Rubrica.setContact("Umberto", "7445732214");
		Rubrica.setContact("Emanuele", "0352278550");
		
		Rubrica.getContacts();
		System.out.println();
		if (Rubrica.deleteContact("LizZo")) {
			System.out.println("Contact succesfully deleted!");
		} else {
			System.out.println("Error.. Can't find the contact.");
		}
		System.out.println();
		Rubrica.getContacts();
		System.out.println();
		
		System.out.println("Ecco il numero di Umberto: " + Rubrica.getNumberByName("Umberto"));
		System.out.println();
		System.out.println("Ecco il contatto associato al numero: " + Rubrica.getNameByNumber("3336669990"));
	}
}






















