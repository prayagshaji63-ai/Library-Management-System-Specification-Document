import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;

import java.util.*;

public class Library {

 private Map<Integer, Book> books = new HashMap<>();

 private Map<Integer, Member> members = new HashMap<>();

 private Map<Integer, BorrowTransaction> activeBorrows = new HashMap<>();

 private Map<Integer, List<Integer>> memberBorrowMap = new HashMap<>();

 private List<ReturnTransaction> returnHistory = new ArrayList<>();

 private final double finePerDay = 10.0;

 public Book addBook(String title, Author author, int stock) {

 Book b = new Book(title, author, stock);

 books.put(b.getId(), b);

 return b;

 }
  public Member addMember(String name, boolean premium) {

 Member m = premium ? new PremiumMember(name) : new Member(name);

 members.put(m.getId(), m);

 memberBorrowMap.put(m.getId(), new ArrayList<>());

 return m;

 }

 public void displayAvailableBooks() {

 System.out.println("\nAvailable Books:");

 if (books.isEmpty()) {

 System.out.println("No books in library.");

 return;

 }

 books.values().stream()

 .sorted(Comparator.comparingInt(Book::getId))

 .forEach(System.out::println);

 System.out.println();

 }

 public void borrowBook(int bookId, int memberId) {

 Book book = books.get(bookId);

 Member member = members.get(memberId);

 if (book == null || member == null) {

 System.out.println("Invalid Book or Member.");

 return;

 }

 if (!book.isAvailable()) {

 System.out.println("Sorry, the book is not available in stock.");

 return;

 }

 List<Integer> borrowed = memberBorrowMap.get(memberId);

 if (borrowed.size() >= member.getMaxBooks()) {

 System.out.println("Member has reached maximum borrowed books limit.");

 return;

 }

 book.reduceStock();

 BorrowTransaction bt = new BorrowTransaction(book, member, LocalDate.now());

 activeBorrows.put(bt.getTransactionId(), bt);

 borrowed.add(bt.getTransactionId());

 bt.printReceipt();

 }

public void returnBook(int transactionId) {

 BorrowTransaction bt = activeBorrows.get(transactionId);

 if (bt == null) {

 System.out.println("Transaction not found.");

 return;

 }

 Book book = bt.getBook();

 Member member = bt.getMember();

 LocalDate due = bt.getDueDate();

 LocalDate returned = LocalDate.now();

 long daysLate = ChronoUnit.DAYS.between(due, returned);

 double fine = 0.0;

 if (daysLate > 0) {

 fine = daysLate * finePerDay;

 if (member instanceof PremiumMember pm) {

 fine *= (1 - pm.getFineDiscountRate());

 }

 }

 book.increaseStock();

 activeBorrows.remove(transactionId);

 memberBorrowMap.get(member.getId()).remove(Integer.valueOf(transactionId));

 ReturnTransaction rt = new ReturnTransaction(book, member, returned);

 rt.setFine(fine);

 returnHistory.add(rt);

 rt.printReceipt();

 }

 public void listActiveBorrowsForMember(int memberId) {

 List<Integer> borrowed = memberBorrowMap.get(memberId);

 if (borrowed == null || borrowed.isEmpty()) {

 System.out.println("No active borrow transactions.");

 return;

 }

 System.out.println("Active borrow transactions:");

 borrowed.forEach(tid -> {

 BorrowTransaction bt = activeBorrows.get(tid);

 if (bt != null) {

 System.out.printf("TID: %d | Book: %s | Due: %s\n", bt.getTransactionId(), 

bt.getBook().getTitle(), bt.getDueDate().format(DateTimeFormatter.ofPattern("dd-MM-

yyyy")));
