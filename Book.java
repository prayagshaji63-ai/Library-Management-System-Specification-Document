public class Book {

 private static int counter = 1;

 private final int id;

 private String title;

 private Author author;

 private int stock;

 public Book(String title, Author author, int stock) {

 this.id = counter++;

 this.title = title;

 this.author = author;

 this.stock = stock;
   }

 public int getId() { return id; }

 public String getTitle() { return title; }

 public Author getAuthor() { return author; }

 public int getStock() { return stock; }

 public boolean isAvailable() { return stock > 0; }

 public void reduceStock() { if (stock > 0) stock--; }

 public void increaseStock() { stock++; }

 @Override

 public String toString() {

 return String.format("ID: %d | Title: %s | Author: %s | Stock: %d", id, title, 

author.getName(), stock);

 }

}
