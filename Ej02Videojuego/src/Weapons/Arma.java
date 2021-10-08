package Weapons;

public abstract class Arma {
	
	public String tipo;
	public int danio;
	
	public abstract int usar();

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

}
