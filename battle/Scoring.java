package battle;

import java.util.Scanner;

import classes.Judge;
import classes.Nomination;
import classes.Participant;

public class Scoring {
  private double score;

  public void score(Judge[] judges, Nomination n) {
    Scanner scanner = new Scanner(System.in);

    double scr = 0;
    double num = 0;
    double avg = 0;

    for (int i = 0; i < judges.length; i++) {
      for (int j = 0; j < n.getListSize(); j++) {
        IO.print("[participant] · " + n.getParticipant(j) + ", give score · ");
        scr = Double.valueOf(scanner.nextLine());
        // if (scr >= 0 && scr <= 10) {
        // num += score;
        // break;
        // }
      }
    }
    // avg = num / j.length;

    this.score = scr;
  }
}
