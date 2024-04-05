
public class Libro {

	protected String ISBN;
	protected String titulo;
	protected String autor;
	protected int numPaginas;

	
public Libro(String ISBN,String titulo,String autor,int numPaginas) {
	this.ISBN=ISBN;
	this.titulo=titulo;
	this.autor=autor;
	this.numPaginas=numPaginas;
}
	public String getIsbn() {
		return ISBN;
	}
	
	public String getTitulo() {
		return titulo;
		
	}
	public String Autor() {
		return autor;
	}
	public int NumPaginas() {
		return numPaginas;
		
	}


	@Override
	public String toString() {
		return "ISBN: "+ISBN+"\ntitulo: "+titulo+ "\nAutor: "+autor+ "\nNumero de paginas: "+numPaginas;
		
	}
	
}
