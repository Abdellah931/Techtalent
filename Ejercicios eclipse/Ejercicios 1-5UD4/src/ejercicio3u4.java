
public class ejercicio3u4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = 5;
        int Y = 10;
        double N = 4.56;
        double M = 2.34;

        System.out.println("Variable X = " + X);
        System.out.println("Variable Y = " + Y);
        System.out.println("Variable N = " + N);
        System.out.println("Variable M = " + M);

        int sumaXY = X + Y;
        int diferenciaXY = X - Y;
        int productoXY = X * Y;
        double cocienteXY = (double) X / Y;
        int restoXY = X % Y;

        double sumaNM = N + M;
        double diferenciaNM = N - M;
        double productoNM = N * M;
        double cocienteNM = N / M;
        double restoNM = N % M;

        double sumaXN = X + N;
        double cocienteYM = (double) Y / M;
        double restoYM = Y % M;

        int dobleX = X * 4;
        int dobleY = Y * 23;
        double dobleN = N * 2.5;
        double dobleM = M * 9.4;

        int sumaTodas = (int) (X + Y + N + M);
        double productoTodas = X * Y * N * M;

        System.out.println("Suma X + Y = " + sumaXY);
        System.out.println("Diferencia X – Y = " + diferenciaXY);
        System.out.println("Producto X * Y = " + productoXY);
        System.out.println("Cociente X / Y = " + cocienteXY);
        System.out.println("Resto X % Y = " + restoXY);
        System.out.println("Suma N + M = " + sumaNM);
        System.out.println("Diferencia N – M = " + diferenciaNM);
        System.out.println("Producto N * M = " + productoNM);
        System.out.println("Cociente N / M = " + cocienteNM);
        System.out.println("Resto N % M = " + restoNM);
        System.out.println("Suma X + N = " + sumaXN);
        System.out.println("Cociente Y / M = " + cocienteYM);
        System.out.println("Resto Y % M = " + restoYM);
        System.out.println("Doble de X = " + dobleX);
        System.out.println("Doble de Y = " + dobleY);
        System.out.println("Doble de N = " + dobleN);
        System.out.println("Doble de M = " + dobleM);
        System.out.println("Suma de todas las variables = " + sumaTodas);
        System.out.println("Producto de todas las variables = " + productoTodas);
	}

}
