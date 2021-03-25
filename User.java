import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class User {
  private LCD lcd;
  private CardReader cardReader;
  private Keypad keypad;
  private CashDispenser dispenser;
  
  static ArrayList<String> atmLog = new ArrayList<String>();

  public User(LCD lcd, CardReader cardReader, Keypad keypad, CashDispenser dispenser) {
    this.lcd = lcd;
    this.cardReader = cardReader;
    this.keypad = keypad;
    this.dispenser = dispenser;
  }

   public void io() {
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy / HH:mm:ss");
    lcd.print(formatter.format(date) + "\n");
    atmLog.add("Date/Time of the entry: " + formatter.format(date));

    lcd.print(Config.map.get("<title>") + "\n");
    lcd.print(Config.map.get("<copyright>") + "\n");
    lcd.print(Config.map.get("<developer>") + "\n");
    lcd.print("Press ENTER to begin");
    Scanner in = new Scanner(System.in);
    try {
      System.in.read();
} catch (Exception e) {
 e.printStackTrace();
 }
    cardReader.readCard();

    //pin entry verification
    int pin = 12345;
    int counter = 0;
    boolean verify = false;
		lcd.print("ENTER YOUR PIN: ");
    int enteredPin = keypad.getPin();

    while ( enteredPin != pin ) {
			lcd.print("INCORRECT PIN. TRY AGAIN.\n");
			lcd.print("ENTER YOUR PIN: ");
			enteredPin = keypad.getPin();
      counter++;

      if (counter > 1 && enteredPin != pin) {  //exit after entering wrong pin three times
      counter = counter + 1; 
      lcd.print("Number of failed pin entry attempts: " + counter + "\n");
      System.out.println("Maximum attempts reached. Please contact NewCo Bank!");
      System.exit(0);    
      }
    }
      
      if (enteredPin == pin) {
      lcd.print("Pin verified succesfully\n");
      lcd.print("Number of failed pin entry attempts: " + counter + "\n");
      atmLog.add("Number of failed pin entry attempts: " + Integer.toString(counter));
      verify = true;
      atmLog.add("The pin was entered correctly: " + Boolean.toString(verify));
    }
    
    //Get amount to withdraw 
    lcd.print("Enter amount to withdraw:  ");
    int amount = keypad.getAmount();

    //Withdraw the amount
    int result = dispenser.getCash(amount);
    if (result == 1) {
      lcd.print("Cash dispense error%n");
    }
    else {
      lcd.print("Cash dispense as follows:\n");
      lcd.print(dispenser.num100s() + "\n");             
      lcd.print(dispenser.num20s() + "\n");
      lcd.print(dispenser.num10s() + "\n");  
      atmLog.add("Amount Withdrawn: " + String.valueOf(amount));
      lcd.print("\n");
    }
    
    try {
    Logger TransLogger = new Logger();
    TransLogger.GetLog();
    atmLog.clear();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("User.io()");
    try {
      Thread.sleep(5000);
    }
    catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}