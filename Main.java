import java.util.Scanner;

import battle.Scoring;
import classes.Judge;
import classes.Nomination;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Judge[] judge = new Judge[3];
        judge[0] = new Judge("judge · 1");
        judge[1] = new Judge("judge · 2");
        judge[2] = new Judge("judge · 3");

        String filePathNominationKids = "data/list-kids.txt";
        String filePathNominationJunior = "data/list-junior.txt";
        String filePathNominationPro = "data/list-pro.txt";

        String filePathNominationKidsResults = "data/results-kids.txt";
        String filePathNominationJuniorResults = "data/results-junior.txt";
        String filePathNominationProResults = "data/results-pro.txt";

        Nomination nominationKids = new Nomination("1v1 kids");
        Nomination nominationJunior = new Nomination("1v1 junior");
        Nomination nominationPro = new Nomination("1v1 pro");

        Scoring scoreNominationKids = new Scoring();
        Scoring scoreNominationJunior = new Scoring();
        Scoring scoreNominationPro = new Scoring();

        IO.println("\n LIST NOMINATIONS");
        nominationKids.getTitle();
        nominationJunior.getTitle();
        nominationPro.getTitle();

        IO.println("\n ===== KIDS =====");
        IO.println("GET PARTICIPANTS FROM FILE");
        nominationKids.getParticipantsFromFile(filePathNominationKids);
        nominationKids.getList();

        IO.println("\n ===== JUNIOR =====");
        IO.println("GET PARTICIPANTS FROM FILE");
        nominationJunior.getParticipantsFromFile(filePathNominationJunior);
        nominationJunior.getList();

        IO.println("\n ===== PRO =====");
        manageNomination(scanner, judge, nominationPro,
                filePathNominationPro, filePathNominationProResults, scoreNominationPro);
        // IO.println("GET PARTICIPANTS FROM FILE");
        // nominationPro.getParticipantsFromFile(filePathNominationPro);
        // nominationPro.getList();
        // // nominationPro.addParticipant(scanner, filePathNominationPro);
        // // nominationPro.getList();
        //
        // scoreNominationPro.score(judge, nominationPro, filePathNominationProResults);
        //
        // // IO.println("\n UPDATE PARTICIPANT");
        // // IO.println("[what you want to change \n [1] · name \n [2] · age \n [3] ·
        // both
        // // \n [other] · nothing");
        // // nominationPro.updateParticipant(filePathNominationPro, 1, 3);
        // // IO.println("\n LIST PARTICIPANT");
        // // nominationPro.getList();
        // // IO.println("\n REMOVE PARTICIPANT");
        // // nominationPro.removeParticipant(filePathNominationPro, 1);
        // // IO.println("\n LIST PARTICIPANT");
        // // nominationPro.getList();

        scanner.close();
    }

    public static void manageNomination(Scanner scan, Judge[] judge, Nomination nom,
            String fp, String fpr, Scoring scoreNom) {
        IO.println("GET PARTICIPANTS FROM FILE");
        nom.getParticipantsFromFile(fp);
        nom.getList();
        // nom.addParticipant(scan, fp);
        // nom.getList();

        IO.println("PRELIMS");
        scoreNom.score(judge, nom, fpr);
        IO.println("PRELIMS RESULTS");
        scoreNom.printResults(nom, fpr);
        // IO.println("\n UPDATE PARTICIPANT");
        // IO.println("[what you want to change \n [1] · name \n [2] · age \n [3] · both
        // \n [other] · nothing");
        // nom.updateParticipant(fp, 1, 3);
        // IO.println("\n LIST PARTICIPANT");
        // nom.getList();
        // IO.println("\n REMOVE PARTICIPANT");
        // nom.removeParticipant(fp, 1);
        // IO.println("\n LIST PARTICIPANT");
        // nom.getList();
    }
}
