import java.util.*;

class ATM {
  private LCD lcd;
  private CardReader cardReader;
  private Keypad keypad;
  private CashDispenser cashDispenser;

  public void init() {
    System.out.println("ATM.init()");

    lcd = new LCD();
    lcd.init();

    cardReader = new CardReader();
    cardReader.init();

    keypad = new Keypad();
    keypad.init();

    cashDispenser = new CashDispenser();
    cashDispenser.init();
  }
  
  public void run() {
  User user = new User(lcd,cardReader,keypad,cashDispenser);
  while (true) {
    user.io();
  } 
  }
}
