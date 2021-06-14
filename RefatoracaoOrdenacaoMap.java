package streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap {
	public static void main(String[] args) {
		
		System.out.println("--\tOrdem aleatória\t--");
		Map<Integer, Contato> agenda = new HashMap<>() {{
			put(1, new Contato ("Simba", 5555));
			put(4, new Contato ("Felipa", 1111));
			put(3, new Contato ("Kamala", 2222));
		}};
		for(Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}
		
		System.out.println("--\tOrdem inserção\t--");
		
		Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
			put(1, new Contato ("Simba", 5555));
			put(4, new Contato ("Felipa", 1111));
			put(3, new Contato ("Kamala", 2222));
		}};
		for(Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}
		
		System.out.println("--\tOrdem ID\t--");
		Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
		for(Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
		}
		
		System.out.println("--\tOrdem Telefone\t--");
//		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//			@Override
//			public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
//				return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
//			}
//		});
		
//		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
//					new Function<Map.Entry<Integer, Contato>, Integer>() {
//
//						@Override
//						public Integer apply(Entry<Integer, Contato> c) {
//							return c.getValue().getNumero();
//						}
//		}));
		
		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
				c -> c.getValue().getNumero()));
		
		set.addAll(agenda.entrySet());
		for(Map.Entry<Integer, Contato> entry: set) {
			System.out.println(entry.getValue().getNumero() + " - " + entry.getValue().getNome());
		}
		
		System.out.println("--\tOrdem Nome\t--");
		Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(
				c -> c.getValue().getNome()));
		set2.addAll(agenda.entrySet());
		for(Map.Entry<Integer, Contato> entry: set2) {
			System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
		}

	}

}

class Contato {
	private String nome;
	private Integer numero;
	
	public Contato(String nome, Integer numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contato{nome='" + nome + "', numero=" + numero + "}";
	}
	
	
	
}
