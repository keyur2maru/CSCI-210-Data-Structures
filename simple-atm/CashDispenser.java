class CashDispenser {
  public void init() {
    System.out.println("CashDispenser.init()");
  }

  private int num100s;
  private int num20s;
  private int num10s;

  public int getCash(int amount) {
    num100s = amount / 100; //get number of $100 bills
    amount = amount % 100; //get remaining amount

    num20s = amount / 20; //get number of $100 bills
    amount = amount % 20; //get remaining amount

    num10s = amount / 10; //get number of $100 bills
    amount = amount % 10; //get remaining amount

    if (amount != 0) return -1; //error

    return 0; //success
  }

  public String num100s() {
    return "$100 Bills: " + num100s;
  }

  public String num20s() {
    return "$20 Bills: " + num20s;
  }

  public String num10s() {
    return "$10 Bills: " + num10s;
  }
}