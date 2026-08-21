package battle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import bridge.ScoredParticipant;
import classes.Judge;
import classes.Nomination;

public class Scoring {
    public void score(Judge[] judge, Nomination nom, String filePath) {
        Scanner scanner = new Scanner(System.in);

        double scr = 0;
        double avg = 0;

        ScoredParticipant[] scoredParticipants = new ScoredParticipant[nom.getListSize()];

        for (int i = 0; i < nom.getListSize(); i++) {
            double num = 0;

            for (int j = 0; j < judge.length; j++) {
                IO.println(judge[j]);

                while (true) {
                    IO.print("[participant] · " + nom.getParticipant(i) + ", give score · ");
                    scr = Double.valueOf(scanner.nextLine());

                    if (scr >= 0 && scr <= 10) {
                        num += scr;
                        break;
                    }
                }
            }

            avg = num / judge.length;

            ScoredParticipant scoredParticipant = new ScoredParticipant(nom.getParticipant(i), avg);
            scoredParticipants[i] = scoredParticipant;
        }

        IO.println("LOL");

        Arrays.sort(scoredParticipants, (a, b) -> Double.compare(b.getScore(), a.getScore()));

        for (ScoredParticipant scoredParticipant : scoredParticipants) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(scoredParticipant.toFile());
                writer.newLine();
            } catch (FileNotFoundException e) {
                IO.println("[error] · " + e);
            } catch (IOException e) {
                IO.println("[error] · " + e);
            }
        }

        scanner.close();
    }

    public void printResults(Nomination nom, String filePath) {
        String readLine;
        String[] splitParts;

        String participantName;
        double participantScore;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((readLine = reader.readLine()) != null) {
                splitParts = readLine.split(", ");

                participantName = splitParts[0];
                participantScore = Double.valueOf(splitParts[1]);

                IO.println(participantName + " · " + participantScore);
            }
        } catch (FileNotFoundException e) {
            IO.println("[error] · " + e);
        } catch (IOException e) {
            IO.println("[error] · " + e);
        }
    }
}
