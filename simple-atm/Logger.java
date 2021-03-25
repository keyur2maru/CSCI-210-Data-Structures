import java.util.ArrayList;
import java.io.*;

public class Logger implements Serializable {
  private static final long serialVersionUID = 1L;
  public void getLog() throws IOException {
    Logger obj = new Logger();

    ArrayList < String > List = User.atmLog;
    try {
      FileOutputStream writeData = new FileOutputStream("atmoutput.log");
      ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

      writeStream.writeObject(List);
      writeStream.flush();
      writeStream.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      FileInputStream readData = new FileInputStream("atmoutput.log");
      ObjectInputStream readStream = new ObjectInputStream(readData);

      ArrayList List1 = (ArrayList < ? > ) readStream.readObject();
      readStream.close();

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  } 
}