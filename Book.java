package LibraryManagementSystem;

import MobilePhone.Contact;

public class Book {

    private String title;
    private String author;
    private String publicationYear;

// CONSTRUCTOR
    public Book(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public static Book createBook(String bookTitle, String author, String pubYear){
        return new Book(bookTitle , author, pubYear);
    }

    // GETTERS

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }
}
