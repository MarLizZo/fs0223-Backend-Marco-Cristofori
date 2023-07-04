package Exercise_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rubrica {
	private static Map<String, String> contacts = new HashMap<String, String>();

	public static void getContacts() {
		contacts.forEach((name, number) -> System.out.println("Nome: " + name + " * * * Number: " + number));
	}

	public static void setContact(String name, String number) {
		contacts.put(name, number);
	}
	
	public static boolean nameExists(String name) {
		return contacts.containsKey(name);
	}
	
	public static boolean numberExists(String number) {
		return contacts.containsValue(number);
	}
	
	public static boolean deleteContact(String name) {
		boolean deleted;
		if (nameExists(name)) {
			contacts.remove(name);
			deleted = true;
		} else {
			deleted = false;
		}
		return deleted;
	}
	
	public static String getNumberByName(String name) {
		if (nameExists(name)) {
			return contacts.get(name);
		} else return "Not found..";
	}
	
	public static String getNameByNumber(String number) {
		String result = "Not found..";
		if (numberExists(number)) {
			Set<String> keyset = contacts.keySet();
			Object[] keys = (Object[]) keyset.toArray();
			for (int i = 0; i < keys.length; i++) {
				if (contacts.get(keys[i]).equals(number)) {
					result = (String) keys[i];
				}
			}
		}
		return result;
	}
}






















