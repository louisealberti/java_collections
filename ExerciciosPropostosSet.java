package sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExerciciosPropostosSet {
	public static void main(String[] args) {
		/*
		 *    Exercício 1) Crie um conjunto contendo as cores do arco-íris e:
		 * A. Exiba todas as cores uma abaixo da outra
		 * B. A quantidade de cores que o arco-íris tem
		 * C. Exiba as cores em ordem alfabética
		 * D. Exiba as cores na ordem inversa da que foi informada
		 * E. Exiba todas as cores que começam com a letra ”v”
		 * F. Remova todas as cores que não começam com a letra “v”
		 * G. Limpe o conjunto
		 * H. Confira se o conjunto está vazio
		 */
		
		Set<String> arcoIris = new HashSet<String>(){{
			add(new String("Vermelho"));
			add(new String("Laranja"));
			add(new String("Amarelo"));
			add(new String("Verde"));
			add(new String("Azul"));
			add(new String("Anil"));
			add(new String("Violeta"));
		}};
		
		System.out.println("A. Exiba todas as cores uma abaixo da outra");
		for(String cor: arcoIris) { System.out.println(cor); }
		
		System.out.println("B. A quantidade de cores que o arco-íris tem: " + arcoIris.size());

		System.out.println("C. Exiba as cores em ordem alfabética");
		Set<String> arcoIris2 = new TreeSet<String>(arcoIris);
		System.out.println(arcoIris2);
		
		System.out.println("D. Exiba as cores na ordem inversa da que foi informada");
		Set<String> arcoIris3 = new LinkedHashSet<String>();
		arcoIris3.add("Vermelho");
		arcoIris3.add("Laranja");
		arcoIris3.add("Amarelo");
		arcoIris3.add("Verde");
		arcoIris3.add("Azul");
		arcoIris3.add("Anil");
		arcoIris3.add("Violeta");
		List<String> arcoIrisList = new ArrayList<String>(arcoIris3);
		Collections.reverse(arcoIrisList);
		System.out.println(arcoIrisList);
		
		System.out.println("E. Exiba todas as cores que começam com a letra 'V'");
		Iterator<String> it = arcoIris3.iterator();
		while(it.hasNext()) {
			String next = it.next();
			if(next.startsWith("V")) { System.out.println(next);}
		}
		
		System.out.println("G. Limpe o conjunto");
		arcoIris.clear();
		arcoIris2.clear();
		arcoIris3.clear();
		System.out.println("arco-íris 1:" + arcoIris);
		System.out.println("arco-íris 2:" + arcoIris2);
		System.out.println("arco-íris 3:" + arcoIris3);

		System.out.println("H. Confira se o conjunto está vazio");
		System.out.println("arco-íris 1:" + arcoIris.isEmpty());
		System.out.println("arco-íris 2:" + arcoIris2.isEmpty());
		System.out.println("arco-íris 3:" + arcoIris3.isEmpty());


		/*
		 * Crie uma classe LinguagemFavorita que possua os atributos
		 * nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
		 * 3 linguagens e faça um programa que ordene esse conjunto
		 * por:
		 * A. Ordem de Inserção
		 * B. Ordem Natural (nome)
		 * C. IDE
		 * D. Ano de criação e nome
		 * E. Nome, ano de criacao e IDE
		 * Ao final, exiba as linguagens no console, um abaixo da outra.
		 */
		
		Set<LinguagemFavorita> minhasLinguagens = new HashSet<LinguagemFavorita>(){{
			add(new LinguagemFavorita("Java", 1995, "Eclipse"));
			add(new LinguagemFavorita("C", 1978, "vim"));
			add(new LinguagemFavorita("Phyton", 1991, "Atom"));
		}};
		
		System.out.println("A. Ordem de Inserção");
		Set<LinguagemFavorita> minhasLinguagens2 = new LinkedHashSet<LinguagemFavorita>();
		minhasLinguagens2.add(new LinguagemFavorita("Java", 1995, "Eclipse"));
		minhasLinguagens2.add(new LinguagemFavorita("C", 1978, "vim"));
		minhasLinguagens2.add(new LinguagemFavorita("Phyton", 1991, "Atom"));
		System.out.println(minhasLinguagens2);
		
		System.out.println("B. Ordem Natural (nome)");
		Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<LinguagemFavorita>(minhasLinguagens);
		for(LinguagemFavorita linguagem: minhasLinguagens3) { System.out.println(linguagem.getNome() + " - "
			+ linguagem.getAnoDeCriacao() + " - " + linguagem.getIDE()); }
		
		System.out.println("C. IDE");
		Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<LinguagemFavorita>(new ComparatorIDE());
		minhasLinguagens4.addAll(minhasLinguagens);
		for(LinguagemFavorita linguagem4: minhasLinguagens4) { System.out.println(linguagem4.getNome() + " - "
				+ linguagem4.getIDE() + " - " + linguagem4.getAnoDeCriacao()); }
		
		System.out.println("D. Ano de criação e nome");
		Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<LinguagemFavorita>(new ComparatorAnoDeCriacaoNome());
		minhasLinguagens5.addAll(minhasLinguagens);
		for(LinguagemFavorita linguagem5: minhasLinguagens5) { System.out.println(linguagem5.getNome() + " - "
				+ linguagem5.getIDE() + " - " + linguagem5.getAnoDeCriacao()); }
		
		
		System.out.println("E. Nome, ano de criacao e IDE");
		Set<LinguagemFavorita> minhasLinguagens6 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoDeCriacaoIDE());
		minhasLinguagens6.addAll(minhasLinguagens);
		for(LinguagemFavorita linguagem6: minhasLinguagens6) { System.out.println(linguagem6.getNome() + " - "
				+ linguagem6.getIDE() + " - " + linguagem6.getAnoDeCriacao()); }



	}

}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
	
	private String nome;
	private Integer anoDeCriacao;
	private String IDE;
	
	public LinguagemFavorita(String nome, Integer anoDeCriacao, String iDE) {
		super();
		this.nome = nome;
		this.anoDeCriacao = anoDeCriacao;
		IDE = iDE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnoDeCriacao() {
		return anoDeCriacao;
	}

	public void setAnoDeCriacao(Integer anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}

	public String getIDE() {
		return IDE;
	}

	public void setIDE(String iDE) {
		IDE = iDE;
	}

	@Override
	public String toString() {
		return "{ nome='" + nome + "', anoDeCriacao=" + anoDeCriacao + ", IDE='" + IDE + "']";
	}

	@Override
	public int compareTo(LinguagemFavorita linguagem) {
		return this.getNome().compareTo(linguagem.getNome());
	}
		
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {

	@Override
	public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
		return l1.getIDE().compareTo(l2.getIDE());
	}

}

class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {

	@Override
	public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
		int anoDeCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
		if(anoDeCriacao != 0) { return anoDeCriacao; }
		
		return l1.getNome().compareTo(l2.getNome());
	}
	
}

class ComparatorNomeAnoDeCriacaoIDE implements Comparator<LinguagemFavorita> {

	@Override
	public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
		int nome = l1.getNome().compareTo(l2.getNome());
		if( nome != 0) {return nome; }
		
		int anoDeCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
		if(anoDeCriacao != 0) { return anoDeCriacao; }
		
		return l1.getIDE().compareTo(l2.getIDE());
	}
	
}
