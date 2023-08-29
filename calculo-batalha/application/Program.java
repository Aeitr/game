package application;

import java.util.Random;
import java.util.Scanner;
import entities.Combate;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		
		//Entrada de dados
		System.out.print("Valor do ataque de A: ");
		double atqA = sc.nextDouble();//Variavel temporaria
		System.out.print("Valor da defesa de B: ");
		double defB = sc.nextDouble();//Variavel temporaria
		System.out.println("Digite taxa de crítico do atacante ");
		int critA = sc.nextInt();     //Variavel temporaria
		Combate combate = new Combate(atqA, defB, critA);

		//Formula para chance de acerto critico
		Random aleatorio = new Random();
		int critico = aleatorio.nextInt(combate.critA) + 1;

		//Saída dos dados após tratamento
		System.out.printf("O dano causado, sem flutuação, foi de %.0f%n", combate.reducHP()); // dano sem calculo de range																							
		System.out.println(combate.result() + "% de flutuação de dano"); // valor da flutuação
	 	
		//Saída condicionada ao acerto crítico
		if (combate.critA == critico) {
			System.out.println("Dano real recebido: " + combate.danoFinal() * 3 + " ATAQUE CRITICO"); // dano final com critico																							
		} else {
			System.out.println("Dano real recebido: " + combate.danoFinal()); // dano real recebido sem acerto critico
		}
		sc.close();
	}
}
