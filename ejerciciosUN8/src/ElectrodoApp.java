
public class ElectrodoApp {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instanciamos con un contructor concreto
		Electrodomesticos lavadora = new Electrodomesticos();
		Electrodomesticos lavavajillas = new Electrodomesticos(200,"rojo","F",30);
		
		System.out.println(lavavajillas.toString());
		

	}

}
