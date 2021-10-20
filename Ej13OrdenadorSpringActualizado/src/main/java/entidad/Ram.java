package entidad;

public class Ram {

	private double precio;
	private double hz;
	private String generacion;
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getHz() {
		return hz;
	}
	
	public void setHz(double hz) {
		this.hz = hz;
	}
	
	public String getGeneracion() {
		return generacion;
	}
	
	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}
	
	@Override
	public String toString() {
		return "Ram [precio=" + precio + ", hz=" + hz + ", generacion=" + generacion + "]";
	}
}
