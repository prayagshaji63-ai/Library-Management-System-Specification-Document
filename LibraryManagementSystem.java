import java.util.Scanner;

public class LibraryManagementSystem {

 public static void main(String[] args) {

 Scanner sc = new Scanner(System.in);

 Library library = new Library();

 Author a1 = new Author("James Gosling", "Java creator");

 Author a2 = new Author("Guido van Rossum", "Python creator");

 library.addBook("Java Programming", a1, 3);

 library.addBook("Python Basics", a2, 5);

 library.addMember("Abhishek", false);

 library.addMember("Sakshi", true);

 boolean exit = false;

 while (!exit) {

 printMenu();

 System.out.print("Enter choice: ");

 String choice = sc.nextLine().trim();

 switch (choice) {

 case "1":

 System.out.print("Enter book title: ");

 String title = sc.nextLine();

 System.out.print("Enter author name: ");

 String authorName = sc.nextLine();
     System.out.print("Enter author bio: ");

 String bio = sc.nextLine();

 System.out.print("Enter stock: ");

 int stock = Integer.parseInt(sc.nextLine());

 Author author = new Author(authorName, bio);

 Book b = library.addBook(title, author, stock);

 System.out.println("Added: " + b);

 break;

 case "2":

 System.out.print("Enter member name: ");

 String name = sc.nextLine();

 System.out.print("Is premium? (y/n): ");

 boolean premium = sc.nextLine().trim().equalsIgnoreCase("y");

 Member m = library.addMember(name, premium);

 System.out.println("Added: " + m);

 break;

 case "3":

 library.displayAvailableBooks();

 library.displayMembers();

 System.out.print("Book ID: ");

 int bid = Integer.parseInt(sc.nextLine());

 System.out.print("Member ID: ");

 int mid = Integer.parseInt(sc.nextLine());

 library.borrowBook(bid, mid);

 break;

 case "4":

 library.displayMembers();

 System.out.print("Enter Member ID: ");

 int memId = Integer.parseInt(sc.nextLine());

 library.listActiveBorrowsForMember(memId);

 System.out.print("Enter Transaction ID: ");

 int tid = Integer.parseInt(sc.nextLine());

 library.returnBook(tid);

 break;

 case "5":

 library.displayAvailableBooks();

 break;

 case "6":

 exit = true;

 System.out.println("Exiting. Goodbye!");

 break;

 default:

 System.out.println("Invalid choice.");

 }
   }

 sc.close();

 }

 private static void printMenu() {

 System.out.println("\n===== Library Menu =====");

 System.out.println("1. Add Book");

 System.out.println("2. Add Member");

 System.out.println("3. Borrow Book");

 System.out.println("4. Return Book");

 System.out.println("5. Display Available Books");

 System.out.println("6. Exit");

 }

}
