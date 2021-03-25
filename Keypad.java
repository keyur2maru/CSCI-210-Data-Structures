import java.util.Scanner;

class Keypad {
  public void init() {
    System.out.println("Keypad.init()");
  }
  
  public int getAmount() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public int getPin() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}