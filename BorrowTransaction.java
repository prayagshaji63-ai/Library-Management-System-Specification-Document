import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class BorrowTransaction {

 private static int counter = 1000;

 private final int transactionId;

 private final Book book;

 private final Member member;

 private final LocalDate borrowDate;

 private final LocalDate dueDate;

 public BorrowTransaction(Book book, Member member, LocalDate borrowDate) {

 this.transactionId = counter++;
   this.book = book;

 this.member = member;

 this.borrowDate = borrowDate;

 this.dueDate = borrowDate.plusDays(member.getBorrowDurationDays());

 }

 public int getTransactionId() { return transactionId; }

 public Book getBook() { return book; }

 public Member getMember() { return member; }

 public LocalDate getBorrowDate() { return borrowDate; }

 public LocalDate getDueDate() { return dueDate; }

 public void printReceipt() {

 DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

 System.out.println("\n====== Borrow Receipt ======");

 System.out.println("Transaction ID: " + transactionId);

 System.out.println("Book: " + book.getTitle() + " (ID: " + book.getId() + ")");

 System.out.println("Member: " + member.getName() + " (ID: " + member.getId() + ")");

 System.out.println("Borrow Date: " + borrowDate.format(f));

 System.out.println("Due Date: " + dueDate.format(f));

 System.out.println("Stock Updated: " + book.getStock() + " remaining");

 System.out.println("============================\n");

 }

}
