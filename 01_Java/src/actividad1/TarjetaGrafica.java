package actividad1;

public class TarjetaGrafica {
	
	private double precio;
	private String marca;
	private String modelo;
	private Ram ram;
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Ram getRam() {
		return ram;
	}
	
	public void setRam(Ram ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "TarjetaGrafica [precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + ", ram=" + ram + "]";
	}
	

}
