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
    String name = scanner.nextLine();

    IO.print("[participant age]  ➤ ");
    int age = Integer.valueOf(scanner.nextLine());

    Participant p = new Participant(name, age);
    participants.add(p);
  }

  public void removeParticipant(int uIndex) {
    int index = uIndex - 1;
    participants.remove(index);
  }

  public void updateParticipant(int uIndex, int whatToUpdate) {
    int index = uIndex - 1;
    Participant p = participants.get(index);
    IO.println(p);

    // TO-DO put variables 'updated' inside condition and make it scanner
    if (whatToUpdate == 1) {
      p.updName("moonlord");
    } else if (whatToUpdate == 2) {
      p.updAge(19);
    } else if (whatToUpdate == 3) {
      p.updName("moonlord");
      p.updAge(19);
    } else {
      p = new Participant(p.getName(), p.getAge());
    }

    participants.remove(index);
    participants.add(index, p);
  }
}
