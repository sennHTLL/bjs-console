package battle;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import classes.Judge;
import classes.Nomination;

public class Scoring {
  public void score(Judge[] judge, Nomination n, String filePath) {
    Scanner scanner = new Scanner(System.in);

    double scr = 0;
    double avg = 0;

    for (int i = 0; i < n.getListSize(); i++) {
      double num = 0;
      for (int j = 0; j < judge.length; j++) {
        IO.println(judge[j]);

        while (true) {
          IO.print("[participant] · " + n.getParticipant(i) + ", give score · ");
          scr = Double.valueOf(scanner.nextLine());

          if (scr >= 0 && scr <= 10) {
            num += scr;
            break;
          }
        }
      }
      avg = num / judge.length;

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,
          true))) {
        writer.write(n.getParticipant(i) + ", " + avg);
        writer.newLine();
      } catch (FileNotFoundException e) {
        IO.println("[error] · " + e);
      } catch (IOException e) {
        IO.println("[error -] · " + e);
      }
    }

    scanner.close();
  }
}
