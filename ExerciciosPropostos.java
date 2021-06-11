package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciciosPropostos {
	public static void main (String[] args) {
		
		/*
		 * Faça um programa que receba a temperatura média dos 6
		 * primeiros meses do ano e armazene-as em uma lista.
		 * Apos isto, calcule a média semestral das temperaturas e
		 * mostre todas as temperaturas acima desta média, e em que
		 * mês elas ocorreram (mostrar o mês por extenso: 1 - Janeiro, 2 
		 * - Fevereiro, etc.
		 */
		
//		// Get month temperature
		Scanner sc =  new Scanner(System.in);
//		List<Double> temperatures = new ArrayList<Double>();
//		
//		System.out.println("Janeiro: ");
//		temperatures.add(sc.nextDouble());
//		System.out.println("Fevereiro: ");
//		temperatures.add(sc.nextDouble());
//		System.out.println("Março: ");
//		temperatures.add(sc.nextDouble());
//		System.out.println("Abril: ");
//		temperatures.add(sc.nextDouble());
//		System.out.println("Maio: ");
//		temperatures.add(sc.nextDouble());
//		System.out.println("Junho: ");
//		temperatures.add(sc.nextDouble());
//		
//		
//		
//		// Calculate 6-month average temperature
//		Iterator<Double> it = temperatures.iterator();
//		Double sum = 0d;
//		while(it.hasNext()) {
//			Double next = it.next();
//			sum += next;
//		}
//		
//		Double average = sum/temperatures.size();
//		System.out.printf("Média Semestral: %.2f%n", average);
//		
//		// Print months above average
//		for(int i = 0; i < 6; i++) { 
//			if(temperatures.get(i) > average) {
//				switch(i) {
//				case 0:
//					System.out.println("{1 - Janeiro: " + temperatures.get(i) + "}");
//					break;
//				case 1:
//					System.out.println("{2 - Fevereiro: " + temperatures.get(i) + "}");
//					break;
//				case 2:
//					System.out.println("{3 - Março: " + temperatures.get(i) + "}");
//					break;
//				case 3:
//					System.out.println("{4 - Abril: " + temperatures.get(i) + "}");
//					break;
//				case 4:
//					System.out.println("{5 - Maio: " + temperatures.get(i) + "}");
//					break;
//				case 5:
//					System.out.println("{6 - Junho: " + temperatures.get(i) + "}");
//					break;
//				default:
//					System.out.println("ERROR");
//					break;
//				}
//			}
//		}
		
		/*
		 * Utilizando listas, faça um programa que faça 5 perguntas para
		 * uma pessoa sobre um crime. As perguntas são:
		 * 1."Telefonou para a vítima?"
		 * 2."Esteve no local do crime?"
		 * 3."Mora perto da vítima?"
		 * 4."Devia para a vítima?
		 * 5."Já trabalhou com a vítima?"
		 * Se a pessoa responder positivamente a 2 questões ela deve ser
		 * classificada como "Suspeita, entre 3 e 4 como "Cúmplice e 5 como
		 * "Assassina". Caso contrário, ela será classificada como "Inocente". 
		 */
		
		
		List<String> questions = new ArrayList<String>() {{
			add(new String("Telefonou para a vítima?"));
			add(new String("Esteve no local do crime?"));
			add(new String("Mora perto da vítima?"));
			add(new String("Devia para a vítima?"));
			add(new String("Já trabalhou com a vítima?"));
		}};
		int count = 0;
		
		
		System.out.println("Responda 's' para 'sim' e 'n' para 'não': ");

		for(String question : questions) {
			System.out.println(question);
			if(sc.nextLine().equals("s")) {
				count++;
			}
		}
		sc.close();
		
		if(count == 2) { System.out.println("SUSPEITA"); }
		else if(count > 2 && count < 5) { System.out.println("CÚMPLICE"); }
		else if(count > 4) { System.out.println("ASSASSINA! :X"); }
		else { System.out.println("INOCENTE"); }
	}
}
