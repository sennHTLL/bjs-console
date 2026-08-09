package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Nomination {

  private String title;
  private ArrayList<Participant> participants;

  public Nomination(String title) {
    this.title = title;
    this.participants = new ArrayList<>();
  }

  public void getTitle() {
    IO.println(this.title);
  }

  public void getList() {
    for (Participant p : participants) {
      int index = participants.indexOf(p) + 1;
      IO.println(index + ". [" + this.title + "] · " + p);
    }
  }

  public void getParticipant() {
    for (Participant p : participants) {
      p.getName();
    }
  }

  public void getParticipantsFromFile(String filePath) {
    String readLine;
    String[] splitParts;

    String name;
    int age;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      while ((readLine = reader.readLine()) != null) {
        splitParts = readLine.split(", ");

        name = splitParts[0];
        age = Integer.valueOf(splitParts[1]);

        Participant p = new Participant(name, age);
        participants.add(p);
      }
    } catch (FileNotFoundException e) {
      IO.println("[error] · " + e);
    } catch (IOException e) {
      IO.println("[error] · " + e);
    }
  }

  public void addParticipant(Scanner scanner, String filePath) {
    IO.print("[participant name] ➤ ");
    String name = scanner.nextLine();

    IO.print("[participant age]  ➤ ");
    int age = Integer.valueOf(scanner.nextLine());

    Participant p = new Participant(name, age);
    participants.add(p);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
      writer.write(p.toFile());
      writer.newLine();
    } catch (FileNotFoundException e) {
      IO.println("[error] · " + e);
    } catch (IOException e) {
      IO.println("[error] · " + e);
    }
  }

  public void removeParticipant(String filePath, int uIndex) {
    int index = uIndex - 1;
    participants.remove(index);

    String tempFile = "data/temp.txt";
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);

    int line = 0;
    String currentLine;

    try {
      FileWriter fw = new FileWriter(tempFile, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      FileReader fr = new FileReader(filePath);
      BufferedReader br = new BufferedReader(fr);

      while ((currentLine = br.readLine()) != null) {
        line++;
        if (uIndex != line) {
          pw.println(currentLine);
        }
      }

      pw.flush();
      pw.close();
      fr.close();
      br.close();
      bw.close();
      fw.close();

      oldFile.delete();
      File dump = new File(filePath);
      newFile.renameTo(dump);
    } catch (IOException e) {
      IO.println("[error] · " + e);
    }
  }

  public void updateParticipant(String filePath, int uIndex, int whatToUpdate) {
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

    // [version 2]
    String tempFile = "data/temp.txt";
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);

    int line = 0;
    String currentLine;

    try {
      FileWriter fw = new FileWriter(tempFile, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      FileReader fr = new FileReader(filePath);
      BufferedReader br = new BufferedReader(fr);

      while ((currentLine = br.readLine()) != null) {
        line++;
        if (uIndex == line) {
          pw.println(p.toFile());
        } else if (uIndex != line) {
          pw.println(currentLine);
        }
      }

      pw.flush();
      pw.close();
      fr.close();
      br.close();
      bw.close();
      fw.close();

      oldFile.delete();
      File dump = new File(filePath);
      newFile.renameTo(dump);
    } catch (IOException e) {
      IO.println("[error] · " + e);
    }
  }
}
