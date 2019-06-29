package com.algorithmforum.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {

	private final String title;
	private final BigDecimal price;

	public Book(String title, BigDecimal price) {
		this.title = title;
		this.price = price;
	}

	public String title() {
		return title;
	}

	public BigDecimal price() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("(%s : %s)", title, price);
	}
}

public class ComparatorUsingLambdas {
	// Creating Comparator to compare Price of training courses
	private static Comparator<Book> PRICE_COMPARATOR = new Comparator<Book>() {
		@Override
		public int compare(Book t1, Book t2) {
			return t1.price().compareTo(t2.price());
		}
	};

	/**
	 * Comparator to compare title of courses using lambda expression of Java 8, in
	 * place of anonymous class we don't need an extra line to declare comparator.
	 */
	private static Comparator<Book> TITLE_COMPARATOR = (c1, c2) -> c1.title().compareTo(c2.title());

	public static void main(String args[]) {
		// list of book to sort these books based upon their price or title
		List<Book> books = new ArrayList<>();
		books.add(new Book("Spring", new BigDecimal("150")));
		books.add(new Book("NoSQL", new BigDecimal("250")));
		books.add(new Book("Java", new BigDecimal("100")));
		books.add(new Book("Scala", new BigDecimal("400")));

		// sorting objects using Comparator by price
		System.out.println("List of training courses, before sorting");
		System.out.println(books);

		Collections.sort(books, PRICE_COMPARATOR);
		System.out.println("After sorting by price, increasing order");
		System.out.println(books);

		// Lambda expression based comparator.
		System.out.println("Sorting list by title ");
		Collections.sort(books, TITLE_COMPARATOR);
		System.out.println(books);
	}
}
