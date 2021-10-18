
public class Superheroe {
	
	private int id;
	private String nombre;
	private String superNombre;
	private int poder;
	private String superPoder;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSuperNombre() {
		return superNombre;
	}
	
	public void setSuperNombre(String superNombre) {
		this.superNombre = superNombre;
	}
	
	public int getPoder() {
		return poder;
	}
	
	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	public String getSuperPoder() {
		return superPoder;
	}
	
	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}

	@Override
	public String toString() {
		return "Superheroe [id=" + id + ", nombre=" + nombre + ", superNombre=" + superNombre + ", poder=" + poder
				+ ", superPoder=" + superPoder + "]";
	}
	
	

}
