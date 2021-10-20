package entidad;

public class Procesador {
	
	private double precio;
	private double hz;
	private String marca;
	private TarjetaGrafica tarjetaGraficaIntegrada;
	
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
	
	public TarjetaGrafica getTarjetaGraficaIntegrada() {
		return tarjetaGraficaIntegrada;
	}
	
	public void setTarjetaGraficaIntegrada(TarjetaGrafica tarjetaIntegrada) {
		this.tarjetaGraficaIntegrada = tarjetaIntegrada;
	}

	@Override
	public String toString() {
		return "Procesador [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", tarjetaIntegrada="
				+ tarjetaGraficaIntegrada + "]";
	}
	

}
