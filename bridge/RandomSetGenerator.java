package bridge;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import classes.Nomination;
import classes.Participant;

public class RandomSetGenerator {

    private Nomination nomination;
    private ArrayList<Participant> list;
    private ArrayList<ArrayList<Participant>> groups;

    public RandomSetGenerator(Nomination nomination) {
        this.nomination = nomination;
        this.list = this.nomination.getArrayList();
        this.groups = new ArrayList<ArrayList<Participant>>();
    }

    public void shuffle() {
        ArrayList<Participant> participants = new ArrayList<>();

        int count = 0;

        Collections.shuffle(this.list);
        IO.println(" ===== SHUFFLED ===== ");

        for (Participant p : this.list) {
            IO.println(p);
            participants.add(p);
            count++;
            if (count == 4) {
                IO.println("· · · · ·");
            }
        }

        // IO.println(" ===== 2D ARRAY ===== ");
        // IO.println("[participants num] · " + participants.size());
        int row = 0;
        int column = 0;

        this.groups.add(new ArrayList<Participant>());

        for (int i = 0; i < participants.size(); i++) {
            this.groups.get(row).add(column, participants.get(i));
            column++;
            if (column == 4) {
                this.groups.add(new ArrayList<Participant>());
                row++;
                column = 0;
            }
        }

        // ===== this is works ⮛
        // this.groups.add(new ArrayList<Participant>());
        // this.groups.get(0).add(0, participants.get(0));
        // this.groups.get(0).add(1, participants.get(1));
        // this.groups.get(0).add(2, participants.get(2));
        // this.groups.get(0).add(3, participants.get(3));
        // this.groups.add(new ArrayList<Participant>());
        // this.groups.get(1).add(0, participants.get(4));
        // this.groups.get(1).add(1, participants.get(5));
        // this.groups.get(1).add(2, participants.get(6));
        // this.groups.get(1).add(3, participants.get(7));

        // ====== stupid comment but i will forget what it does
        // ====== print shuffled saved array and saved it in shuffled way or not
        // for (int i = 0; i < this.groups.size(); i++) {
        // for (int j = 0; j < this.groups.get(i).size(); j++) {
        // IO.println(this.groups.get(i).get(j));
        // }
        // IO.println("[muahahahahaha]");
        // }
    }

    public void writeInFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < this.groups.size(); i++) {
                for (int j = 0; j < this.groups.get(i).size(); j++) {
                    writer.write(this.groups.get(i).get(j).getName());
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            IO.println("[exception] · " + e);
        } catch (IOException e) {
            IO.println("[exception] · " + e);
        }
    }
}
