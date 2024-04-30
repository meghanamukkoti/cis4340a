public class Cycle {
  private static final int deposit = (int) (Math.random() * 100); 
  private static final Cycle c = new Cycle();  

  private final int balance;

  public Cycle() {
    balance = deposit - 10; 
  }

  public static void main(String[] args) {
    System.out.println("The account balance is: " + c.balance);
  }
}
