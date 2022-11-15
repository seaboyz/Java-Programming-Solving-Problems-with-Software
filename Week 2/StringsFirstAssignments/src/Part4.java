import edu.duke.URLResource;

public class Part4 {
  public static void main(String[] args) {
    URLResource urlResource = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");

    for (String word : urlResource.words()) {
      int pos = word.toLowerCase().indexOf("youtube.com");
      if (pos != -1) {
        int beg = word.indexOf("\"");
        int end = word.lastIndexOf("\"");
        System.out.println(word.substring(beg + 1, end));
      }
    }
  }
}
