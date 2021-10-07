package basico;

public class Direccion {
	private String tipoVia;
	//los numeros en java que empieza por 0 estan en base octal
	//los numeros en java que empieza por 0x estan en hexadecimal
	//los numeros que empiezan en 0b estan en binario
	private String cp;
	private String nombreVia;
	private String ciudad;
	
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", cp=" + cp + ", nombreVia=" + nombreVia + ", ciudad=" + ciudad + "]";
	}
}
