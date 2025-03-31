package junit4;

public class Main {

	public static void main(String[] args) {		
		Trojkat trojkat = new Trojkat(2, 2, 2);
		System.out.println(trojkat.toString());

		trojkat = new Trojkat(5, 10, 7);
		System.out.println(trojkat.toString());
		
		trojkat = new Trojkat(3, 4, 5);
		System.out.println(trojkat.toString());
	}
}
