public class PremiumMember extends Member {

 private double fineDiscountRate;

 public PremiumMember(String name) {

 super(name);

 this.maxBooks = 5;

 this.borrowDurationDays = 14;

 this.fineDiscountRate = 0.2;

 }

 public double getFineDiscountRate() { return fineDiscountRate; }

 @Override

 public String toString() {

 return String.format("ID: %d | Name: %s | Type: Premium | MaxBooks: %d | Duration: %d 

days | FineDiscount: %.0f%%", id, name, maxBooks, borrowDurationDays, fineDiscountRate * 

100);

 }

}
