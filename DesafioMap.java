package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DesafioMap {
	public static void main(String[] args) {
		
		/*
		 * Faça um programa que simule um lançamento de dados.
		 * Lance o dado 100 vezes e armazene.
		 * Depois, mostre quantas vezes cada valor foi inserido.
		 */
		
		Map<Integer, Integer> results = new HashMap<>() {{
			put(1, 0);
			put(2, 0);
			put(3, 0);
			put(4, 0);
			put(5, 0);
			put(6, 0);
		}};
		
		Random randomGenerator = new Random();
		
		for(int i = 0; i < 100; i++) {
			int num = randomGenerator.nextInt(6) + 1;
			int add = results.get(num) + 1;
            results.put(num, add);
        }
		
		for(Map.Entry<Integer, Integer> result : results.entrySet()) {
			System.out.printf("%d - %02d vezes%n", result.getKey(), result.getValue());
		}

	}

}
