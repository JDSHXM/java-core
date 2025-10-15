package Lesson3;

import java.util.ArrayList;

public class Book {
    private static final ArrayList<Book> books = new ArrayList<Book>();


    private String isbn;
    private String name;
    private String author;
    private String year;
    private Boolean status;


    public Book(String isbn, String name, String author, String year, Boolean status) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    private String getBookInfo() {
        return "ISBN: " + isbn +
                "Название: " + name +
                "Автор: " + author +
                "Год издания: " + year +
                "Статус: " + status;
    }


    private void getBooks() {
        if (books.isEmpty()) {
            System.out.println("Пусто!");
        } else {
            for (Book book : books) {
                System.out.println("ISBN: " + book.isbn +
                        "Название: " + book.name +
                        "Автор: " + book.author +
                        "Год издания: " + book.year +
                        "Статус: " + book.status
                );
            }
        }
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("+");
    }

    public void reserveBooks(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                if (book.status.equals(true)) {
                    book.status = false;
                } else {
                    System.out.println("Уже занят!");
                }
                System.out.println("Такого book нету в списке");
            }
        }
    }
}
