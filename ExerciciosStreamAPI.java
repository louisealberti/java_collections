package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
	public static void main(String[] args) {
		
		List<String> numerosAleatorios =
				Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
		
		List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		System.out.println("Imprima todos os elementos dessa lista de String: ");
		numerosAleatorios.stream().forEach(s -> System.out.println(s));
	
		System.out.println("Pegue os 5 primeiros números e coloque em um Set: ");
		numerosAleatorios.stream()
			.limit(5)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
		List<Integer> numerosAleatorios2 = numerosAleatorios.stream()
				.map(Integer::parseInt).collect(Collectors.toList());
		numerosAleatorios2.forEach(System.out::println);

		System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
		numerosAleatorios.stream()
			.map(Integer::parseInt)
			.filter(i -> i % 2 == 0 && i > 2)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("Mostre a lista na ordem numérica: ");
		numerosAleatorios2.stream()
			.sorted(Comparator.naturalOrder())
			.forEach(System.out::println);
		
		System.out.println("Mostre a média dos números: ");
		numerosAleatorios.stream()
			.mapToInt(Integer::parseInt)
			.average()
			.ifPresent(System.out::println);
		
		System.out.println("Remova os valores ímpares: ");
		numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);
		System.out.println(numerosAleatoriosInteger);

	}

}
