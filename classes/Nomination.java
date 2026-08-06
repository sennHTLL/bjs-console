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

  public void updateParticipant(int uIndex, int whatToUpdate) {
    int index = uIndex - 1;
    Participant p = participants.get(index);
    IO.println(p);

    String updatedName = "moonlord";
    int updatedAge = 19;

    // TO-DO put variables 'updated' inside condition and make it scanner
    if (whatToUpdate == 1) {
      p = new Participant(updatedName, p.getAge());
    } else if (whatToUpdate == 2) {
      p = new Participant(p.getName(), updatedAge);
    } else if (whatToUpdate == 3) {
      p = new Participant(updatedName, updatedAge);
    } else {
      p = new Participant(p.getName(), p.getAge());
    }

    participants.remove(index);
    participants.add(index, p);
  }
}
