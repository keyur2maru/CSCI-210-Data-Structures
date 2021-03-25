public class HtmlElement {
  public String name_start;
  public String name_end;
  public Tag tag_start;
  public Tag tag_end;

  public HtmlElement(String start, String end, Tag tag_start, Tag tag_end) {
    //System.out.println("===+++");
    //System.out.println("tag_start:" + tag_start);
    name_start = start;
    name_end = end;
    this.tag_start = tag_start;
    this.tag_end = tag_end;
  }
}