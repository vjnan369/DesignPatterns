package com.OOOPS.composition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//https://www.geeksforgeeks.org/composition-in-java/
//The composition is a design technique in java to implement a has-a relationship.
//Java Inheritance is used for code reuse purposes and the same we can do by using composition
//https://www.infoworld.com/article/3409071/java-challenger-7-debugging-java-inheritance.html
//https://medium.com/learn-and-grow/association-aggregation-and-composition-in-oop-58e4e879c07f
//ASSOCIATION
// AGGREGATION -> weakly coupled
//COMPOSITION -> tightly coupled
class Book{
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

class Library{
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getListOfBooks(){
        return books;
    }
}
public class Compoisition {
    public static void main(String[] args) {
        Book b1 = new Book("effective java", "joshuva bloch");
        Book b2 = new Book("Java reference", "Herbert schildt");
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);

        Library library = new Library(books);
        List<Book> bookList = library.getListOfBooks();
        for(Book book : bookList){
            System.out.println(book);
        }
    }
}
