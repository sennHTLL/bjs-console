import java.util.Scanner;

import classes.Judge;
import classes.Nomination;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    IO.println("JUDGE(-S)");
    Judge judge1 = new Judge("judge 1");
    IO.println(judge1);

    String nomKidsFilePath = "data/1v1_kids.txt";
    String nomJuniorFilePath = "data/1v1_junior.txt";
    String nomProFilePath = "data/1v1_pro.txt";

    Nomination nominationKids = new Nomination("1v1 kids");
    Nomination nominationJunior = new Nomination("1v1 junior");
    Nomination nominationPro = new Nomination("1v1 pro");

    IO.println("\n LIST NOMINATIONS");
    nominationKids.getTitle();
    nominationJunior.getTitle();
    nominationPro.getTitle();

    IO.println("\n ===== KIDS =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationKids.getParticipantsFromFile(nomKidsFilePath);
    nominationKids.getParticipants();

    IO.println("\n ===== JUNIOR =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationJunior.getParticipantsFromFile(nomJuniorFilePath);
    nominationJunior.getParticipants();

    IO.println("\n ===== PRO =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationPro.getParticipantsFromFile(nomProFilePath);
    nominationPro.getParticipants();
    nominationPro.addParticipant(scanner);
    nominationPro.getParticipants();

    // IO.println("\n UPDATE PARTICIPANT");
    // IO.println("[what you want to change \n [1] · name \n [2] · age \n [3] · both
    // \n [other] · nothing");
    // nominationPro.updateParticipant(1, 3);
    // IO.println("\n REMOVE PARTICIPANT");
    // nominationPro.removeParticipant(1);

    scanner.close();
  }
}
