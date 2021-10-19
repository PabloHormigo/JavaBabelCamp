package entidad;

public class Periferico {
	
	private double precio;
	private String marca;
	private TipoPeriferico tipo;
	
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
	
	
	public TipoPeriferico getTipo() {
		return tipo;
	}

	public void setTipo(TipoPeriferico tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Periferico [precio=" + precio + ", marca=" + marca + ", tipo="+tipo+"]";
	}




}
