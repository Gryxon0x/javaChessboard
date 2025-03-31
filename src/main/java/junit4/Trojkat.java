package junit4;

public class Trojkat {
    private final int a, b, c;
	
	public Trojkat(int a, int b, int c) throws IllegalArgumentException{
		this.a = a;
		this.b = b;
		this.c = c;
		
		if (a<=0 && b<=0 && c<=0)
			throw new IllegalArgumentException();
		
		if (a+b<c || a+c<b || b+c<a)
			throw new IllegalArgumentException();
	}
	
	@Override
	public String toString() {		
		if (a == b && b == c)
			return "trójkąt równoboczny";
		else if (a == b || a == c || b == c)
			return "trójkąt równoramienny";
		else if (a*a+b*b==c*c)
			return "trójkąt prostokątny";
		return "trójkąt równoboczny";
	}
}
