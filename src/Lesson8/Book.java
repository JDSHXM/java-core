package Lesson8;

public class Book {
    private String name;
    private String author;
    private String isbn;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Название: " + name + ", Автор: " + author + ", ISBN: " + isbn;
    }
}
