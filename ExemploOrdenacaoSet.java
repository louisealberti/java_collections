package sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
 * Dados as seguintes informações sobre minhas séries favoritas,
 * crie um conjunto e ordene este conjunto exibindo:
 * (nome - gênero - tempo de episódio)
 * 
 * serie_1 = nome: GoT, genero: fantasia, tempoEpisodio: 60
 * serie_2 = nome:Dark, genero: drama, tempoEpisodio: 60
 * serie_3 = nome: That 70's show, genero: comédia, tempoEpisodio: 25
 */

public class ExemploOrdenacaoSet {
	public static void main(String[] args) {
		
		Set<Serie> minhasSeries = new HashSet<Serie>(){{
			add(new Serie("GoT", "fantasia", 60));
			add(new Serie("Dark", "drama", 60));
			add(new Serie("That 70's Show", "comédia", 25));
		}};
		
		System.out.println("--\tOrdem aleatória\t---");
		for(Serie serie: minhasSeries) { System.out.println(serie.getNome() + " - "
				+ serie.getGenero() + " - " + serie.getTempoEpisodio()); }
		
		System.out.println("--\tOrdem inserção\t---");
		Set<Serie> minhasSeries2 = new LinkedHashSet<Serie>(){{
			add(new Serie("GoT", "fantasia", 60));
			add(new Serie("Dark", "drama", 60));
			add(new Serie("That 70's Show", "comédia", 25));
		}};
		for(Serie serie: minhasSeries) { System.out.println(serie.getNome() + " - "
				+ serie.getGenero() + " - " + serie.getTempoEpisodio()); }

		System.out.println("--\tOrdem Natural (tempoEpisodio)\t---");
		Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries);
		for(Serie serie: minhasSeries) { System.out.println(serie.getNome() + " - "
			+ serie.getGenero() + " - " + serie.getTempoEpisodio()); }
		
		
		System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t---");
		Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
		minhasSeries4.addAll(minhasSeries);
		for(Serie serie4: minhasSeries4) { System.out.println(serie4.getNome() + " - "
			+ serie4.getGenero() + " - " + serie4.getTempoEpisodio()); }
		
		System.out.println("--\tOrdem Gênero\t---");
		Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorGenero());
		minhasSeries5.addAll(minhasSeries);
		for(Serie serie5: minhasSeries5) { System.out.println(serie5.getNome() + " - "
				+ serie5.getGenero() + " - " + serie5.getTempoEpisodio()); }
		
		System.out.println("--\tOrdem TempoEpisodio\t---");
		Set<Serie> minhasSeries6 = new TreeSet<>(new ComparatorTempoEpisodio());
		minhasSeries6.addAll(minhasSeries);
		for(Serie serie6: minhasSeries6) { System.out.println(serie6.getNome() + " - "
				+ serie6.getGenero() + " - " + serie6.getTempoEpisodio()); }
		
	}

}

class Serie implements Comparable<Serie> {
	private String nome;
	private String genero;
	private Integer tempoEpisodio;
	
	public Serie(String nome, String genero, Integer tempoEpisodio) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getTempoEpisodio() {
		return tempoEpisodio;
	}

	public void setTempoEpisodio(Integer tempoEpisodio) {
		this.tempoEpisodio = tempoEpisodio;
	}

	@Override
	public String toString() {
		return "{" +
				"nome='" + nome + '\'' +
				", genero='" + genero + '\'' +
				", tempoEpisodio='" + tempoEpisodio + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, genero, tempoEpisodio);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null) { return false; }
		Serie serie = (Serie) o;
		return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
	}

	@Override
	public int compareTo(Serie serie) {
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if(tempoEpisodio != 0) { return tempoEpisodio; }
		return this.getGenero().compareTo(serie.getGenero());
	}
	
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if(nome != 0) { return nome; }
		
		int genero = s1.getGenero().compareTo(s2.getGenero());
		if(genero != 0) { return genero; }
		
		return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
	}
	
}

class ComparatorGenero implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		return s1.getGenero().compareTo(s2.getGenero());
	}

}

class ComparatorTempoEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
		if(tempoEpisodio != 0) { return tempoEpisodio; }
		return s1.getNome().compareTo(s2.getNome());
	}
	
}
