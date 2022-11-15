public class Part2 {
  public String findSimpleGene(String dna, int startCondon, int stopCodon) {
    // update dna to substring of dna , start from startCondon, end to stopCodon
    dna = dna.substring(startCondon, stopCodon);
    // update dna to uppercase
    dna = dna.toUpperCase();
    // start with result = ""
    String result = "";
    // find the index of the start codon "ATG"
    int startCodonIndex = dna.indexOf("ATG");
    // if there is no "ATG", return result
    if (startCodonIndex == -1) {
      return result;
    }
    // find the index of the stop codon "TAA"
    int stopCodonIndex = dna.indexOf("TAA");
    // if there is no "TAA", return result
    if (stopCodonIndex == -1) {
      return result;
    }
    // if the length of the substring between "ATG" and "TAA" is not a multiple of 3, return result
    if ((stopCodonIndex - startCodonIndex) % 3 != 0) {
      return result;
    }
    // else update the result with the substring between "ATG" and "TAA"
    result = dna.substring(startCodonIndex + 3, stopCodonIndex);
    // return result
    return result;
  }

  public void testSimpleGene() {
    // dna with "ATG", without "TAA"
    String dna1 = "ATGGCTAATCCG";
    // dna without "ATG", with "TAA"
    String dna2 = "CGTATAAGCTAA";
    // dna without "ATG" and "TAA"
    String dna3 = "CGTACCGTTAC";
    // dna with "ATG" and "TAA", but the length of substring between is not multiple of 3
    String dna4 = "ATGCGTACGTADCTAA";
    // dna with "ATG" and "TAA", and the length of substring between is multiple of 3
    String dna5 = "ATGCGTTACGTATAA";
    System.out.println("Gene is: " + findSimpleGene(dna1, 0, dna1.length()));
    System.out.println("Gene is: " + findSimpleGene(dna2, 0, dna2.length()));
    System.out.println("Gene is: " + findSimpleGene(dna3, 0, dna3.length()));
    System.out.println("Gene is: " + findSimpleGene(dna4, 0, dna4.length()));
    System.out.println("Gene is: " + findSimpleGene(dna5, 0, dna5.length()));
  }

  public static void main(String[] args) {
    Part2 p2 = new Part2();
    p2.testSimpleGene();
  }

}
