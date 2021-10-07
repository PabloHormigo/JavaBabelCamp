package actividad1;

public class Procesador {
	
	private double precio;
	private double hz;
	private String marca;
	private TarjetaGrafica tarjetaIntegrada;
	
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
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public TarjetaGrafica getTarjetaIntegrada() {
		return tarjetaIntegrada;
	}
	
	public void setTarjetaIntegrada(TarjetaGrafica tarjetaIntegrada) {
		this.tarjetaIntegrada = tarjetaIntegrada;
	}

	@Override
	public String toString() {
		return "Procesador [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", tarjetaIntegrada="
				+ tarjetaIntegrada + "]";
	}
	

}
