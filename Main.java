import java.util.Scanner;

import classes.Judge;
import classes.Nomination;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    IO.println("JUDGE(-S)");
    Judge judge1 = new Judge("judge 1");
    IO.println(judge1);

    Nomination nominationKids = new Nomination("1v1 kids");
    Nomination nominationJunior = new Nomination("1v1 junior");
    Nomination nominationPro = new Nomination("1v1 pro");

    IO.println("\n LIST NOMINATIONS");
    nominationKids.getTitle();
    nominationJunior.getTitle();
    nominationPro.getTitle();

    IO.println("\n ===== PRO =====");
    addIntoNominationPro(scanner, nominationPro);
    listNominationPro(nominationPro);

    IO.println("\n UPDATE PARTICIPANT");
    IO.println("[what you want to change \n [1] · name \n [2] · age \n [3] · both \n [other] · nothing");
    nominationPro.updateParticipant(1, 0);
    listNominationPro(nominationPro);

    IO.println("\n REMOVE PARTICIPANT");
    nominationPro.removeParticipant(1);

    IO.println("\n UPDATE LIST");
    listNominationPro(nominationPro);
  }

  public static void addIntoNominationPro(Scanner scanner, Nomination nom) {
    IO.println("ADD PARTICIPANTS");
    for (int i = 0; i < 4; i++) {
      addParticipant(scanner, nom);
    }
  }

  public static void listNominationPro(Nomination nom) {
    IO.println("\n LIST PARTICIPANTS");
    nom.getParticipants();
  }

  public static void addParticipant(Scanner scanner, Nomination nom) {
    nom.addParticipant(scanner);
  }
}
