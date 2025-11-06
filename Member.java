public class Member {

 private static int counter = 1;

 protected final int id;

 protected String name;

 protected int maxBooks;

 protected int borrowDurationDays;

 public Member(String name) {

 this.id = counter++;

 this.name = name;

 this.maxBooks = 2;

 this.borrowDurationDays = 7;

 }

 public int getId() { return id; }

 public String getName() { return name; }

 public int getMaxBooks() { return maxBooks; }

 public int getBorrowDurationDays() { return borrowDurationDays; }

 @Override

 public String toString() {

 return String.format("ID: %d | Name: %s | Type: Regular | MaxBooks: %d | Duration: %d 

days", id, name, maxBooks, borrowDurationDays);}

}
