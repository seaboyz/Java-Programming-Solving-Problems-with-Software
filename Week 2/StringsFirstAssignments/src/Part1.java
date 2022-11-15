public class Part1 {
    public String findSimpleGene(String dna) {
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
        result = dna.substring(startCodonIndex, stopCodonIndex + 3);
        // return result
        return result;
    }

    public void testSimpleGene() {
        // dna with "ATG", without "TAA"
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        // dna without "ATG", with "TAA"
        String dna2 = "CGTATAAGCTAA";
        // dna without "ATG" and "TAA"
        String dna3 = "CGTACCGTTAC";
        // dna with "ATG" and "TAA", but the length of substring between is not multiple of 3
        String dna4 = "ATGCGTACGTADCTAA";
        // dna with "ATG" and "TAA", and the length of substring between is multiple of 3
        String dna5 = "ATGCGTTACGTATAA";
        System.out.println("Gene is: " + findSimpleGene(dna1));
        System.out.println("Gene is: " + findSimpleGene(dna2));
        System.out.println("Gene is: " + findSimpleGene(dna3));
        System.out.println("Gene is: " + findSimpleGene(dna4));
        System.out.println("Gene is: " + findSimpleGene(dna5));
    }

    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.testSimpleGene();
    }

}
