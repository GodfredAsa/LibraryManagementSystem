package LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    private static Scanner  scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean quit = false;
        startLibrary();
        libraryActivities();

        while(!quit){
            System.out.print("Enter 6, View Library Activities: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting Close Library ...");
                    quit = true;
                    break;
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    queryBook();
                    break;
                case 6:
                    libraryActivities();
                    break;
            }
        }

    }

    // CASE 1: PRINT CONTACTS DONE IN THE MOBILE PHONE CLASS

    // CASE 2: ADD NEW CONTACT
    private static void addNewBook(){
        //taking attributes of the book class: title, author, and publication year
        System.out.print("Enter Book Title: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter Publication Year: ");
        String publicationYear = scanner.nextLine();

        Book newBook = Book.createBook(bookTitle, authorName, publicationYear);
        if(library.addNewBook(newBook)){
//            System.out.println("Successfully Added Contact" + name + " phone --> " + phone);
            System.out.println("Book Successfully Added");
        }else{
            System.out.println("Cannot Add " + bookTitle + " author " + authorName + " of " +
                    "publication year: " + publicationYear);
        }
    }

    // CASE 3: UPDATE A CONTACT
    private static void updateBook(){
        System.out.print("Enter Existing Book Title: ");
        String bookTitle  = scanner.nextLine();
        Book exitingBookRecord =  library.queryBook(bookTitle);
        if(exitingBookRecord==null){
            System.out.println("Book Not Found");
            //return;
        }

        System.out.print("Enter New Book Title: ");
        String newBookTitle = scanner.nextLine();
        System.out.print("Enter New Author: ");
        String newAuthor = scanner.nextLine();

        System.out.print("Enter New Publication Year: ");
        String publicationYear = scanner.nextLine();

        //#### *****
        Book newBookRecord = Book.createBook(newBookTitle,newAuthor, publicationYear);
        if(library.updateBook(exitingBookRecord, newBookRecord)){
            System.out.println("Successfully Updated Records");
        }else{
            System.out.println("Record Not Updated");
        }
    }

    // CASE 4: DELETED A BOOk
    private static void deleteBook() {
        System.out.print("Enter Book Title: ");
        String bookTitle = scanner.nextLine();
        Book exitingBookRecord = library.queryBook(bookTitle);
        if (exitingBookRecord == null) {
            System.out.println("Book Not Found");
            //return; //not necessary
        }else if(library.removeBook(exitingBookRecord)){
            System.out.println( bookTitle.toUpperCase()+ ", Successfully Deleted");
        }else{
            System.out.println("Error Deleting Book " + bookTitle.toUpperCase());
        }
    }
    // CASE 5: QUERY A CONTACT
    private static void queryBook() {
        System.out.print("Enter Book Title: ");
        String bookTitle = scanner.nextLine();
        Book exitingBookRecord = library.queryBook(bookTitle);
        if (exitingBookRecord == null) {
            System.out.println("Book Not Found");
            //return;
        }
        System.out.println("\nBook Title: " + exitingBookRecord.getTitle() +
                "\nAuthor: " + exitingBookRecord.getAuthor() + "\nPublication Year: " +
                exitingBookRecord.getPublicationYear());
    }

    private static void startLibrary(){
        System.out.println("Opening Library ... ");
    }
    //CASE 6 AVAILABLE ACTIONS
    private static void libraryActivities(){
        System.out.println("\nAvailable Actions\nPress");
        System.out.println(
                "0 - Shutdown\n" +
                        "1 - View Books\n" +
                        "2 - Add a Book\n" +
                        "3 - Update an Existing Book\n" +
                        "4 - Delete a Book\n" +
                        "5 - Search for a Book\n" +
                        "6 - View Library Activities"
        );
        System.out.println("Select Activity: ");

    }
}
