import java.util.Scanner;

import classes.Nomination;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String filePathNominationKids = "data/1v1_kids.txt";
    String filePathNominationJunior = "data/1v1_junior.txt";
    String filePathNominationPro = "data/1v1_pro.txt";

    Nomination nominationKids = new Nomination("1v1 kids");
    Nomination nominationJunior = new Nomination("1v1 junior");
    Nomination nominationPro = new Nomination("1v1 pro");

    IO.println("\n LIST NOMINATIONS");
    nominationKids.getTitle();
    nominationJunior.getTitle();
    nominationPro.getTitle();

    IO.println("\n ===== KIDS =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationKids.getParticipantsFromFile(filePathNominationKids);
    nominationKids.getParticipants();

    IO.println("\n ===== JUNIOR =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationJunior.getParticipantsFromFile(filePathNominationJunior);
    nominationJunior.getParticipants();

    IO.println("\n ===== PRO =====");
    IO.println("GET PARTICIPANTS FROM FILE");
    nominationPro.getParticipantsFromFile(filePathNominationPro);
    nominationPro.getParticipants();
    nominationPro.addParticipant(scanner, filePathNominationPro);
    nominationPro.getParticipants();

    IO.println("\n UPDATE PARTICIPANT");
    IO.println("[what you want to change \n [1] · name \n [2] · age \n [3] · both \n [other] · nothing");
    nominationPro.updateParticipant(filePathNominationPro, 1, 3);
    IO.println("\n LIST PARTICIPANT");
    nominationPro.getParticipants();
    IO.println("\n REMOVE PARTICIPANT");
    nominationPro.removeParticipant(filePathNominationPro, 1);
    IO.println("\n LIST PARTICIPANT");
    nominationPro.getParticipants();

    scanner.close();
  }
}
