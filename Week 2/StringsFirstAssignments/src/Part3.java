public class Part3 {
  public Boolean twoOccurences(String stringa, String stringb) {
    // start the result with false
    Boolean result = false;
    // stringa does not appear in stringb
    int firstIndex = stringb.indexOf(stringa);
    if (firstIndex == -1) {
      return result;
    }
    // stringa appears twice in stringb
    int lastIndex = stringb.lastIndexOf(stringa);
    if (firstIndex != lastIndex) {
      // update result
      result = true;
    }
    // return result
    return result;
  }

  public String lastPart(String stringa, String stringb) {
    // start with result = ""
    String result = "";
    // find the first occurence of stringa in stringb
    int indexOfStringa = stringb.indexOf(stringa);
    // if not, return stringb
    if (indexOfStringa == -1) {
      result = stringb;
    } else {
      // if found, return the substring of stringb after stringa
      result = stringb.substring(indexOfStringa + stringa.length());
    }

    return result;
  }

  public void testing() {
    System.out.println(lastPart("by", "A story by Abby Long"));
    System.out.println(lastPart("an", "banana"));
    System.out.println(lastPart("zoo", "forest"));
  }

  public static void main(String[] args) {
    Part3 p3 = new Part3();
    p3.testing();
  }

}
