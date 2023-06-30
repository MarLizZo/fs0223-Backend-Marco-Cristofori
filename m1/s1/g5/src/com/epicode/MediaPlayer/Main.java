package com.epicode.MediaPlayer;

public class Main {
	
	static String title = "";
	static int durata = 0;
	static int volume = 0;
	static int luminosita = 0;

	public static void main(String[] args) {
		System.out.println("Benvenuto Umberto Emanuele.. Emanuele Umberto..?");
		System.out.println("Benvenuto Umbenuele! Cominciamo!!");
		
		System.out.println("**********************************");
		
		int firstChoice = Functions.chooseFrom(0);
		
		Functions.createObject(firstChoice, 0);
		
		int secondChoice = Functions.chooseFrom(1);
		
		Functions.createObject(secondChoice, 1);
		
		int thirdChoice = Functions.chooseFrom(2);
		
		Functions.createObject(thirdChoice, 2);
		
		int fourthChoice = Functions.chooseFrom(3);
		
		Functions.createObject(fourthChoice, 3);
		
		int fifthChoice = Functions.chooseFrom(4);
		
		Functions.createObject(fifthChoice, 4);
		
		
		System.out.println("**********************************");
		System.out.println("Bene! Ora puoi visionare i tuoi elementi!!");
		System.out.println("**********************************");
		System.out.println();
		
		Functions.logObjects();
	}
}
























