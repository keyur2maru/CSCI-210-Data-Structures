import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    title();
    if (args.length == 0) {
      usage();
      return;
    }
    try {
      List < String > html = Files.readAllLines(Paths.get(args[0]));
      System.out.println(html);
      parse(html);
    } catch (IOException e) {
      System.out.println(e);
      return;
    }
  }
  private static void title() {
    System.out.println("HTML Validator");
    System.out.println("Version 0.0.1");
    System.out.println("By Keyur Maru");
  }
  private static void usage() {
    System.out.println("Usage Info");
    System.out.println("Enter filename of HTML file");
    System.out.println("Example: java Main index.html");
  }

  private static HtmlElement[] html_elements = {
    new HtmlElement("<html>", "</html>", Tag.HtmlStart, Tag.HtmlEnd),
    new HtmlElement("<head>", "</head>", Tag.HeadStart, Tag.HeadEnd),
    new HtmlElement("<body>", "</body>", Tag.BodyStart, Tag.BodyEnd),
    new HtmlElement("<title>", "</title>", Tag.TitleStart, Tag.TitleEnd),
    new HtmlElement("<p>", "</p>", Tag.ParaStart, Tag.ParaEnd)
  };

  private static void parse(List < String > html) {
    Stack < Tag > stack = new Stack < Tag > ();

    //Parse each item in the HTML
    for (String s: html) {
      System.out.println("Checking: " + s);
      for (HtmlElement e: html_elements) {
        /*
        System.out.println("=> " + e.name_start + "," + e.name_end + "," + e.tag_start + "," + e.tag_end);
        */

        if (s.equals(e.name_start)) {
          System.out.println(" -push- (" + e.tag_start + ")");
          stack.push(e.tag_start);
          break;
        } else if (s.equals(e.name_end)) {
          Tag tag = stack.pop();
          System.out.println(" -pop- (" + tag + ")");
          if (tag != e.tag_start) {
            System.out.println("Not Valid HTML");
          }
        }

        //the poped item and current item should match
      }
      //System.out.println(" OK");
      System.out.println("");
    }
    if (stack.empty()) {
      System.out.println("HTML Valid");
    } else {
      System.out.println("HTML Not Valid");
    }
  }

}