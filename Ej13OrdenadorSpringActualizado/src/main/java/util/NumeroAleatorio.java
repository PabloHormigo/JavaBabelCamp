package util;

public class NumeroAleatorio {
	
	public int generarNumero(int min, int max) {
		int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
		return randomWithMathRandom;
	}
}
