import java.util.Scanner;

public class DNA{
  /* This program is designed to determine if a sequence of DNA is
  a protein by testing the first three chars, the last three chars,
  and whether or not the sequence is divisable by three */

  char adenine;
  char cytosine;
  char guanine;
  char thymine;

  public static void main (String[] args){
    DNA run = new DNA();
    
    String dna = run.scannerIn();

    run.divisibleTest(dna);
    run.firstCodon(dna);
    run.lastCodon(dna);

    if(run.divisibleTest(dna) && run.firstCodon(dna) && run.lastCodon(dna) == true){
      run.returnProtein(dna);
    }
    else{
      System.out.println("Not a protein.");
    }
  }

  public String scannerIn(){
    Scanner in = new Scanner(System.in);
    System.out.println("Input your DNA Sequence then hit enter:");
    String input = in.nextLine();
    return input;
  }

  public boolean divisibleTest(String dna){
    if (dna.length() % 3 == 0) {
      System.out.println("Your sequence is divisible by three!");
      return true;
    }
    else{
      System.out.println("Your sequence is not divisible by three, %n so it is not a protein!");
      return false;
    }
  }

  public boolean firstCodon(String dna){
    if (dna.startsWith("ATG")){
      System.out.println("Your sequence begins with ATG!");
      return true;
    }
    else{
      System.out.println("Your sequence does not begin with ATG, %n so it is not a protein.");
      return false;
    }
  }

  public boolean lastCodon(String dna){
    if (dna.endsWith("TGA")){
      return true;
    }
    else{
      return false;
    }
  }

  public String returnProtein(String dna){
    String protein1 = dna.substring(dna.length() - 3);
    String protein2 = dna.substring(0,3);
    String proteinConcat = protein1.concat(protein2);
    System.out.println("Your protein sequence is: " + proteinConcat);
    return proteinConcat;
  }

}
