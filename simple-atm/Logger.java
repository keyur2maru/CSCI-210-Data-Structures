import java.io.*;
import java.util.ArrayList;

public class Logger {
  public void GetLog() throws IOException {
    
    ArrayList <String> List = User.atmLog;
    File file = new File("atm.log");  
  if (!file.exists()) {
	     file.createNewFile();
	  }
    
    BufferedWriter bw = null;
    FileWriter fw = new FileWriter(file,true);
    

	  bw = new BufferedWriter(fw);
    fw.write("");
         for (String i : List) {      
         bw.write(i);
         bw.append(System.lineSeparator());
        }
         bw.flush();
         fw.write("\r\n");
         bw.close();
         fw.close();
         System.out.println("Log saved on atm.log\n");
  }
}