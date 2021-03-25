class Main {
  public static void main(String[] args) {
    title();
    if (args.length == 0) {
      usage();
      return;
    }

    char[] string_array = args[0].toCharArray();
    for (char c : string_array) {
      System.out.println("Checking " + c);
      if (c == '(') {
        push(c);
      }
      else if (c == ')') {
        pop(c);
      }
    }
    if (get_stack_size() == 0) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid!");
    }

    System.out.println("Part 2");

    CharStack stack = new CharStack();
    System.out.println("Emptying stack before use");
    stack.clear();
    try {
      System.out.println("Pushing items on stack");
      for (char i : string_array) {
        System.out.println(i + ", ");
        stack.push(i);      
      }
      System.out.println();

      System.out.println("Pulling items from stack");
      while (stack.isEmpty() == false) {
        System.out.println(stack.pop() + ", ");
      }
     // stack.pop(); //test for java.lang.Exception for stack empty when pop
    }
    catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("All done");
  }


    private static void title() {
      System.out.println("Correctly Parenthesized");
      System.out.println("Version 0.0.1");
      System.out.println("By Keyur Maru");
    
  }
  
  private static void usage() {
    System.out.println("Usage Info");
    System.out.println("Enter a string to check");  
    System.out.println("Example: java Main '(a+b)*c((c+d)/(f+g)'");
    System.out.println("NOTE: Be sure to use single quotes around string!");  
  }

  private static int stack_size;
  private static void push(char c) {
    stack_size++;
    System.out.println("push: stack_size: " + stack_size);
  }
  private static void pop(char c) {
    stack_size--;
    System.out.println("pop: stack_size: " + stack_size);
  }
  private static int get_stack_size() {
    return stack_size;
  }
  

  }
