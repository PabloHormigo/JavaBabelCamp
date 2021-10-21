package es.curso.util;

import org.springframework.stereotype.Component;

@Component(value="generarNumeroAleatorio")
public class NumeroAleatorio {
	
	public int generarNumero(int min, int max) {
		int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
		return randomWithMathRandom;
	}
}
