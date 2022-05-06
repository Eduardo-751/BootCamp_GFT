package DIO;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exemple_Sorting {
	public static void main(String[] args) {
		
		System.out.println("-- Ordem aleatória --");
		Map<String, Book> bookMap = new HashMap<>() {{
			put("Schwab, Victoria", new Book("Tons de Magia", 425));
			put("J. R. R. Tolkien", new Book("O Silmarilion", 495));
			put("Clare, Cassandra", new Book("Cidade dos Ossos", 459));
		}};
		for(Map.Entry<String, Book> book : bookMap.entrySet()) 
			System.out.println(book.getKey() + " - " + book.getValue().getName() + " - " +  book.getValue().getPages());
		
		System.out.println("\n-- Ordem inserção --");
		Map<String, Book> bookLinkedMap = new LinkedHashMap<>() {{
			put("Clare, Cassandra", new Book("Cidade dos Ossos", 459));
			put("Schwab, Victoria", new Book("Tons de Magia", 425));
			put("J. R. R. Tolkien", new Book("O Silmarilion", 495));
		}};
		for(Map.Entry<String, Book> book : bookLinkedMap.entrySet()) 
			System.out.println(book.getKey() + " - " + book.getValue().getName() + " - " + book.getValue().getPages());
		
		System.out.println("\n-- Ordem alfabética autores--");
		Map<String, Book> bookTreeMap = new TreeMap<>(bookMap);
		for(Map.Entry<String, Book> book : bookTreeMap.entrySet()) 
			System.out.println(book.getKey() + " - " + book.getValue().getName() + " - " +  book.getValue().getPages());
		
		System.out.println("\n-- Ordem alfabética livros--");
		Set<Map.Entry<String, Book>> bookTreeSet1 = new TreeSet<>(new ComparatorName());
		bookTreeSet1.addAll(bookMap.entrySet());
		for(Map.Entry<String, Book> book : bookTreeSet1) 
			System.out.println(book.getKey() + " - " + book.getValue().getName() + " - " +  book.getValue().getPages());
		
		System.out.println("\n-- Ordem numero paginas--");
		Set<Map.Entry<String, Book>> bookTreeSet2 = new TreeSet<>(new ComparatorPages());
		bookTreeSet2.addAll(bookMap.entrySet());
		for(Map.Entry<String, Book> book : bookTreeSet2) 
			System.out.println(book.getKey() + " - " + book.getValue().getName() + " - " + book.getValue().getPages());
	}
}

class Book{
	private String name;
	private Integer pages;
	
	public Book(String name, Integer pages) {
		this.name = name;
		this.pages = pages;
	}
	
	
	//Gets and Sets
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(name, pages);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Book other = (Book) obj;
		return Objects.equals(name, other.name) && Objects.equals(pages, other.pages);
	}
	
	//ToString
	@Override
	public String toString() {
		return "Book [author=" + name + ", pages=" + pages + "]";
	}
	
}

class ComparatorName implements Comparator<Map.Entry<String, Book>>{
	@Override
	public int compare(Entry<String, Book> b1, Entry<String, Book> b2) {
		return b1.getValue().getName().compareToIgnoreCase(b2.getValue().getName());
	}
}

class ComparatorPages implements Comparator<Map.Entry<String, Book>>{
	@Override
	public int compare(Entry<String, Book> b1, Entry<String, Book> b2) {
		return b1.getValue().getPages().compareTo(b2.getValue().getPages());
	}
}
