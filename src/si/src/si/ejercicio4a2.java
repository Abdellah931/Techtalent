package si;

public class ejercicio4a2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int operador1=10;
	        int operador2=20;
	        int operador3=10;
	        boolean resultado1;
	        boolean resultado2;
	        boolean resultado3;
	        boolean resultado4;
	        boolean resultado5;
	        boolean resultado6;
	        boolean resultado7;
	        boolean resultado8;

	        resultado1=operador1==operador2; //¿10 es igual a 20? resultado=false
	        resultado2=operador1==operador3; //¿10 es igual a 10? resultado=true
	        resultado3=operador1!=operador2; //¿10 es distinto a 20? resultado=true
	        resultado4=operador1>operador2; //¿10 es mayor que 20? resultado=false
	        resultado5=operador1>operador3; //¿10 es mayor que 10? resultado=false
	        resultado6=operador1<operador2; //¿20 es mayor que 10? resultado=true
	        resultado7=operador1<=operador3; //¿10 es mayor o igual que 10? resultado=true
	        resultado8=operador1>=operador2; //¿10 es mayor o igual que 20? resultado=false

	        System.out.println("¿" + operador1 + " es igual a" + operador1 + "?" +resultado1);
	        System.out.println("¿" + operador1 + " es igual a " + operador2 + "?" +resultado2);
	        System.out.println("¿" + operador1 + " es distinto a " + operador2 + "? " +resultado3);
	        System.out.println("¿" + operador1 + " es mayor que " + operador2 + "? " +resultado4);
	        System.out.println("¿" + operador1 + " es mayor que " + operador3 + "? " +resultado5);
	        System.out.println("¿" + operador2 + " es mayor que " + operador3 + "? " +resultado6);
	        System.out.println("¿" + operador1 + " es mayor o igual que " + operador3 + "? " +resultado7);
	        System.out.println("¿" + operador1 + " es mayor o igual a " + operador2 + "? " +resultado8);
	        System.out.printf("¿%d es mayor o igual a %d %b/n?" operador1, operador2, resultado1);
	}

}
