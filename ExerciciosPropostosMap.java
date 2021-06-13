package maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class ExerciciosPropostosMap {
	public static void main(String[] args) {
		
		/*
		 * Dada a população estimada de alguns estados do NE brasileiro, faça:
		 * Estado = PE - População = 9.616.621
		 * Estado = AL - População = 3.351.543
		 * Estado = CE - População = 9.187.103
		 * Estado = RN - População = 3.534.265
		 * Crie um dicionário e relacione os estados e suas populações;
		 * Substitua a população do estado do RN por 3.534.165;
		 * Confira se o estado PB está no dicionário, caso não adicione: PB -
		 * 4.039.277;
		 * Exiba a população PE;
		 * Exiba todos os estados e suas populações na ordem que foi
		 * informado;
		 * Exiba os estados e suas populações em ordem alfabética;
		 * Exiba o estado com o menor população e sua quantidade;
		 * Exiba o estado com a maior população e sua quantidade;
		 * Exiba a soma da população desses estados;
		 * Exiba a média da população deste dicionário de estados;
		 * Remova os estados com a população menor que 4.000.000;
		 * Apague o dicionário de estados;
		 * Confira se o dicionário está vazio.
		 */
		
		System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
		Map<String, Integer> estados = new HashMap<String, Integer>(){{
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534265);
		}};
		for(Map.Entry<String, Integer> estado : estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Substitua a população do estado do RN por 3.534.165: ");
		estados.put("RN", 3534165);
		for(Map.Entry<String, Integer> estado : estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Confira se o estado PB está no dicionário: " + estados.containsKey("PB"));
		System.out.println("Caso não esteja adicione: PB - 4.039.277: ");
		estados.put("PB", 4039277);
		for(Map.Entry<String, Integer> estado : estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Exiba a população PE: " + estados.get("PE"));
		
		System.out.println("Exiba todos os estados e suas populações na ordem que foi informado: ");
		Map<String, Integer> estados2 = new LinkedHashMap<>(){{
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534265);
		}};
		for(Map.Entry<String, Integer> estado : estados2.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
		Map<String, Integer> estados3 = new TreeMap<>(estados2);
		for(Map.Entry<String, Integer> estado : estados3.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Exiba o estado com o menor população e sua quantidade: ");
		Integer menorPopulacao = Collections.min(estados.values());
		Set<Map.Entry<String, Integer>> entries = estados.entrySet();
		String estadoComMenorPopulacao = "";
		
		for(Map.Entry<String, Integer> entry : entries) {
			if(entry.getValue().equals(menorPopulacao)) { 
				estadoComMenorPopulacao = entry.getKey();
				System.out.println("Estado com menor população: " + estadoComMenorPopulacao + " - " + menorPopulacao);
			}				
		}
		
		System.out.println("Exiba o estado com a maior população e sua quantidade: ");
		Integer maiorPopulacao = Collections.max(estados.values());
		String estadoComMaiorPopulacao = "";
		
		for(Map.Entry<String, Integer> entry : entries) {
			if(entry.getValue().equals(maiorPopulacao)) { 
				estadoComMaiorPopulacao = entry.getKey();
				System.out.println("Estado com maior população: " + estadoComMaiorPopulacao + " - " + maiorPopulacao);
			}				
		}

		System.out.print("Exiba a soma da população desses estados: ");
		Iterator<Integer> iterator = estados.values().iterator();
		Integer soma = 0;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);
		
		System.out.println("Exiba a média da população deste dicionário de estados: " + (soma/estados.size()));


		System.out.println("Remova os estados com a população menor que 4.000.000: ");
		Iterator<Integer> iterator2 = estados.values().iterator();
		while(iterator2.hasNext()) {
			if(iterator2.next() < 4000000) {
				iterator2.remove();
			}
		}
		for(Map.Entry<String, Integer> estado : estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
		
		System.out.println("Apague o dicionário de estados: ");
		estados.clear();
		System.out.println(estados);


		System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());

	}

}

