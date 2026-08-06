package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Nomination {

  private String title;
  private ArrayList<Participant> participants;

  public Nomination(String title) {
    this.title = title;
    this.participants = new ArrayList<>();
  }

  public String getTitle() {
    return this.title;
  }

  public void getParticipants() {
    for (Participant p : participants) {
      int index = participants.indexOf(p) + 1;
      IO.println(index + ". [" + this.title + "] · " + p);
    }
  }

  public void addParticipant(Scanner scanner) {
    IO.print("[participant name] ➤ ");
    String pName = scanner.nextLine();

    IO.print("[participant age] ➤ ");
    int pAge = Integer.valueOf(scanner.nextLine());

    Participant p = new Participant(pName, pAge);
    participants.add(p);
  }

  public void removeParticipant(int uIndex) {
    int i = uIndex - 1;
    participants.remove(i);
  }
}
