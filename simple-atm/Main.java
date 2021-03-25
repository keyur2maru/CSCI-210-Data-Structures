class Main {  
 public static void main(String args[]){ 
  ATM atm = new ATM();
  atm.init();
  Config validate = new Config();
  validate.init();
  atm.run(); 
 }
} 