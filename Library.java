package LibraryManagementSystem;

import MobilePhone.Contact;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> myBook;

    // constructor
    public Library(){
        this.myBook = new ArrayList<Book>();
    }
    // **** FUNCTIONALITIES OF THE LIBRARY ****

    /**
     * 1. FINDING A BOOK
     *  first method finds the index of the book
     */
    private int findBook(Book book){
        return this.myBook.indexOf(book);
    }

    public int findBook(String bookTitle){
        for(int i =0; i<myBook.size(); i++){
            Book book  = this.myBook.get(i);
            if(book.getTitle().equals(bookTitle)){
                return i;
            }
        }
        return -1;
    }

    // 2. ADD BOOK
    public boolean addNewBook(Book book){
        if(findBook(book.getTitle())>=0){
            System.out.println("Book Already Exist");
            return false;
        }
        myBook.add(book);
        return true;
    }

    // UPDATE A BOOK RECORD
    public boolean updateBook(Book oldBook, Book newBook){
        int findPosition = findBook(oldBook);
        if(findPosition<0){
            System.out.println(oldBook.getTitle() + "is not Available");
            return false;
        }else if(findBook(newBook.getTitle()) !=-1){
            System.out.println("Book with title: " + newBook.getTitle().toUpperCase() + " already Exists, " +
                    "Update not Successful");
            return false;
        }
        this.myBook.set(findPosition, newBook);
        System.out.println(oldBook.getTitle().toUpperCase() + " updated to " + newBook.getTitle().toUpperCase());
        return  true;
    }

    // REMOVE OR DELETE BOOK
    public boolean removeBook(Book book){
        int findPosition  = findBook(book);
        if(findPosition<0){
//            // book does not exist
            return false;
        }
        myBook.remove(findPosition);
        // book exist
//        System.out.println(book.getTitle().toUpperCase() + " was successfully removed");
        return true;
    }

    // QUERYING A BOOK  OVERWRITTEN
    public String queryBook(Book book){
        if(findBook(book)>=0){
            return book.getTitle();
        }
        return null;
    }

    public Book queryBook(String bookTitle){
        int position = findBook(bookTitle);
        if(position>=0){
            return this.myBook.get(position);
        }else{
            return null;
        }

    }

    public void viewBooks(){
        System.out.println("********** Lists of Available Books *********");
        for(int i=0; i<this.myBook.size(); i++){
            System.out.println(i+1 + ". Book Title: " + this.myBook.get(i).getTitle() + "\nAuthor" +
                    " Name: " + this.myBook.get(i).getAuthor() + "\nPublication Year: " +
                    this.myBook.get(i).getPublicationYear());
            System.out.println("********************************************");
        }
    }


}
