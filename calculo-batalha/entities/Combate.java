package entities;

import java.util.Random;

public class Combate {

	public double atqA;
	public double defB;
	public int critA;
	
	//Metodo Construtor
	public  Combate (double atqA, double defB, int critA) {
		this.atqA = atqA;
		this.defB = defB;
		this.critA = critA;
	}
	
	//Cauculo do dano quando defesa maior que ataque.
	public float reducHP() {
		if(defB > atqA) {
			return (float) ((atqA / 2) - (defB / 4)) / 4;
		}
	//Cauculo do dano quando ataque maior que defesa.	
		return (float) ((atqA / 2) - (defB / 4));
	}

	//Formula "Range".
	Random range = new Random();
	static int low = 80;
	static int high = 120;
	
	public int result() {
		return range.nextInt(high - low) + low;
	}
	
	//Formula de Dano Final após todas as condições consideradas.
	public int danoFinal() {
		return (int) ((reducHP() * result()) / 100);

	}

}
