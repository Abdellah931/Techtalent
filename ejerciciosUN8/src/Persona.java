
public class Persona {

	private String nombre;
	private int edad;
	private String DNI;
	private String sexo;
	private int peso;
	private int altura;
	
	public Persona(){

	this.nombre="";
	this.edad=0;
	this.DNI="XXXXXX";
	this.sexo="H";
	this.peso=0;
	this.altura=0;
	
	}
	public Persona(String name, int age,String DNI, String sex) {
		this.nombre=name;
		this.edad=age;
		this.sexo=sex;
		this.DNI="XXXXXX";
		this.peso=0;
		this.altura=0;
		
	}
	public Persona(String name, int age,String DNI, String sex, int weight, int inch ) {
		this.nombre=name;
		this.edad=age;
		this.DNI="XXXXXX";
		this.sexo=sex;
		this.peso=weight;
		this.altura=inch;
	}
	}
