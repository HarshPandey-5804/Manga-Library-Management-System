import java.util.Scanner;

public class LibraryManagementSystem {

    // ADD BOOKS
    public static String[] addBook(String[] books) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of books you want to add: ");
        int num = sc.nextInt();
        sc.nextLine();

        // Create a new array with updated size
        String[] updatedBooks = new String[books.length + num];

        // Copy existing books to the new array
        for (int i = 0; i < books.length; i++) {
            updatedBooks[i] = books[i];
        }

        // Add new books
        for (int i = books.length; i < updatedBooks.length; i++) {
            System.out.println("Enter the name of book " + (i - books.length + 1) + ": ");
            updatedBooks[i] = sc.nextLine();
        }

        System.out.println("Books added successfully!");
        return updatedBooks;
    }

    // DELETE BOOK
    public static String[] deleteBook(String[] books) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book to delete: ");
        String bookToDelete = sc.nextLine();

        boolean found = false;
        int index = -1;

        // Find the book to delete
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(bookToDelete)) {
                found = true;
                index = i;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
            return books; 
        }

        // Create a new array without the deleted book
        String[] updatedBooks = new String[books.length - 1];
        int j = 0;
        for (int i = 0; i < books.length; i++) {
            if (i != index) {
                updatedBooks[j++] = books[i];
            }
        }

        System.out.println("Book deleted successfully!");
        return updatedBooks; // Return updated list of books
    }

    // SEARCH BOOK
    public static void searchBook(String[] books) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book to search: ");
        String bookToSearch = sc.nextLine();

        boolean found = false;
        for (String book : books) {
            if (book.equalsIgnoreCase(bookToSearch)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Book found: " + bookToSearch);
        } else {
            System.out.println("Book not found!");
        }
    }

    // DISPLAY ALL BOOKS
    public static void displayAllBooks(String[] books) {
        System.out.println("Books in the library:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] books = {"DAN DA DAN", "JUJUTSU KAISEN", "NARUTO", "ONE PIECE", "BLACK CLOVER"};
        int choice;

        do {
            System.out.println("\n<-------------------- MANGA LIBRARY MANAGEMENT SYSTEM -------------------->");
            System.out.println("Choose an option for the task to perform:");
            System.out.println("1. To add book\n2. To delete book\n3. To search book\n4. To display all books\n5. Exit");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    books = addBook(books);
                    break;
                case 2:
                    books = deleteBook(books);
                    break;
                case 3:
                    searchBook(books);
                    break;
                case 4:
                    displayAllBooks(books);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
