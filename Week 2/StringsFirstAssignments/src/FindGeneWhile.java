public class FindGeneWhile {
  public String findGene(String dna) {
    // set the default result to ""
    String result = "";
    // find the startIndex of codon "ATG"
    int startIndex = dna.indexOf("ATG");
    // if startIndex == -1, return the default result
    if (startIndex == -1) {
      return result;
    }
    // find the stopIndex of codon "TAA" from startIndex + 3
    int stopIndex = dna.indexOf("TAA", startIndex + 3);
    // as long as stopIndex != -1
    while (stopIndex != -1) {
      // check if (stopIndex - startIndex) is the multiple of 3 
      if ((stopIndex - startIndex) % 3 == 0) {
        // if so, update result to the text beweet startIndex and stopIndex, and return it
        result = dna.substring(startIndex, stopIndex + 3);
        return result;
      } else {
        // if not, update the stopIndex to index of codon "TAA" from stopIndex + 3
        stopIndex = dna.indexOf("TAA", stopIndex + 3);
      }
    }
    // return result
    return result;
  }

  public void testFindGene() {
    String dna = "AATGCGTAATTAATCG";
    System.out.println("DNA is " + dna);
    String gene = findGene(dna);
    System.out.println("Gene is " + gene);
  }

  public static void main(String[] args) {
    FindGeneWhile findGeneWhile = new FindGeneWhile();
    findGeneWhile.testFindGene();
  }

}
