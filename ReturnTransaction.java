import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class ReturnTransaction {

 private static int counter = 2000;

 private final int transactionId;

 private final Book book;

 private final Member member;

 private final LocalDate returnDate;

 private double fine;

 public ReturnTransaction(Book book, Member member, LocalDate returnDate) {

 this.transactionId = counter++;

 this.book = book;

 this.member = member;
 this.returnDate = returnDate;

 this.fine = 0.0;

 }

 public void setFine(double fine) { this.fine = fine; }

 public double getFine() { return fine; }

 public void printReceipt() {

 DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

 System.out.println("\n====== Return Receipt ======");

 System.out.println("Transaction ID: " + transactionId);

 System.out.println("Book: " + book.getTitle() + " (ID: " + book.getId() + ")");

 System.out.println("Member: " + member.getName() + " (ID: " + member.getId() + ")");

 System.out.println("Return Date: " + returnDate.format(f));

 System.out.printf("Fine: \u20B9%.2f\n", fine);

 System.out.println("Stock Updated: " + book.getStock() + " available");

 System.out.println("============================\n");

 }

}  
