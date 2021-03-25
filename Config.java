import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Config {
  public static Map<String, String> map = new java.util.HashMap<>();

 public void init() {
            try {
      List < String > xml = Files.readAllLines(Paths.get("atm.xml"));
      System.out.println(xml);
      parse(xml);
    } catch (IOException e) {
      System.out.println(e);
      return;
    }
 }
  
    private static XmlElement[] xml_elements = {
    new XmlElement("<config>", "</config>", Tag.ConfigStart, Tag.ConfigEnd),
    new XmlElement("<title>", "</title>", Tag.TitleStart, Tag.TitleEnd),
    new XmlElement("<copyright>", "</copyright>", Tag.CopyrightStart, Tag.CopyrightEnd),
    new XmlElement("<developer>", "</developer>", Tag.DeveloperStart, Tag.DeveloperEnd),
    };

    private static void parse(List < String > xml) {
    Stack < Tag > stack = new Stack < Tag > ();

    //Parse each item in the xml
    for (String s: xml) {
      System.out.println("Checking: " + s);
      for (XmlElement e: xml_elements) {
        if (s.equals(e.name_start)) {
          System.out.println(" -push- (" + e.tag_start + ")");
          stack.push(e.tag_start);
          map.put(e.name_start.toString(), "");
          break;
        } else if (s.equals(e.name_end)) {
          Tag tag = stack.pop();
          System.out.println(" -pop- (" + tag + ")");
          if (tag != e.tag_start) {
            System.out.println("Not Valid XML");
          }
        }
      }
      System.out.println("");
    }
    if (stack.empty()) {
      System.out.println("XML Valid");
    } else {
      System.out.println("XML Not Valid");
    }
  map.put("<copyright>" , xml.get(5));
  map.put("<title>" , xml.get(2));
  map.put("<developer>" , xml.get(8));
  }
}

 