package sets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
	public static void main(String[] args) {
		// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
		
		// Set notas = new HashSet(); // antes do java 5
		// HashSet<Double> notas =  new HashSet<>();
		// Set<Double> notas = new HashSet<>(); // Generic(JDK 5) - Diamond Operator(JDK 7)
		// Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
		// notas.add(1d);
		// notas.remove(5d);
		// System.out.println(notas));
		
		System.out.println("Crie um conjunto e adicione as notas: ");
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println(notas.toString());
		
		System.out.println("Exiba a posição da nota 5.0: ");
		System.out.println("O set não possui índices");
		
		System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
		System.out.println("O set não possui índices");

		
		System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
		System.out.println("Não é possível fazer em um set.");

		System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

		System.out.println("Exiba a terceira nota adicionada");
		System.out.println("Não é possível fazer em um set.");

		System.out.println("Exiba a menor nota: " + Collections.min(notas));

		System.out.println("Exiba a maior nota: " + Collections.max(notas));
		
		System.out.print("Exiba a soma dos valores: ");
		Iterator<Double> it = notas.iterator();
		Double soma = 0d;
		while(it.hasNext()) {
			Double next = it.next();
			soma += next;
		}
		System.out.println(soma);
		
		System.out.println("Exiba a média das notas: " + (soma/notas.size()));

		System.out.println("Remova a nota 0: ");
		notas.remove(0d);
		System.out.println(notas);

		System.out.println("Remova a nota da posição 0: ");
		System.out.println("O set não possui índices");


		System.out.println("Remova as notas menores que 7 e exiba a lista: ");
		Iterator<Double> iterator1 = notas.iterator();
		while(iterator1.hasNext()) {
			Double next = iterator1.next();
			if(next < 7) { iterator1.remove();}
		}
		System.out.println(notas);
		
		System.out.println("Exiba todas as notas na ordem que foram informadas: ");
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d);
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);
		
		System.out.println("Exiba todas as notas na ordem crescente: ");
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println(notas3);

		System.out.println("Apague todo o conjunto: ");
		notas.clear();
		System.out.println(notas);
		
		System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

	}

}
