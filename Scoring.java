import java.util.ArrayList;

import classes.Participant;

public class Scoring {

  private ArrayList<Participant> participants;
  private double score;

  public Scoring(double score) {
    this.participants = new ArrayList<>();
    this.score = score;
  }

  public double getScore() {
    return this.score;
  }
}
