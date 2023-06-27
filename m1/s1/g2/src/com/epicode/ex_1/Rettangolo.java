package com.epicode.ex_1;

public class Rettangolo {
		private double height;
		private double width;
		
		public Rettangolo(double _height, double _width) {
			this.height = _height;
			this.width = _width;
		}
		
		public static void stampaRettangolo(Rettangolo r) {
			System.out.println("Perimetro: " + ((r.height + r.width) * 2));
			System.out.println("Area: " + (r.height * r.width));
		}
		
		public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
			System.out.println("Primo rettangolo: ");
			stampaRettangolo(r1);
			System.out.println("Secondo rettangolo: ");
			stampaRettangolo(r2);
			System.out.println("***********");
			double perim = ((r1.height + r1.width) * 2) + ((r2.height + r2.width) * 2);
			double area = (r1.height * r1.width) + (r2.height * r2.width);
			System.out.println("Somma dei perimetri: " + perim);
			System.out.println("Somma delle aree:  " + area);
		}
}
















