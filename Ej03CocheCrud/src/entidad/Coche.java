package entidad;

public class Coche {
	
	private int id;
	private String marca;
	private String modelo;
	private double numKM;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getNumKM() {
		return numKM;
	}
	public void setNumKM(double numKM) {
		this.numKM = numKM;
	}
	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", numKM=" + numKM + "]";
	}

}
