package battle;

import java.util.Scanner;

import classes.Judge;
import classes.Nomination;
import classes.Participant;

public class Scoring {
  private double score;
  private String participant;

  public Scoring(Nomination nom) {
    this.participant = nom.getParticipant();
  }

  public void score(Judge[] j) {
    Scanner scanner = new Scanner(System.in);

    double scr = 0;
    double num = 0;
    double avg = 0;

    for (int i = 0; i < j.length; i++) {
      while (true) {
        IO.print("[participant] · " + this.participant + ", give score · ");
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

  public String toString() {
    return this.participant + " · " + this.score;
  }
}
