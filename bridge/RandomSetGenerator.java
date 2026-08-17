package bridge;

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
        this.groups = new ArrayList<>();
    }

    public void shuffle() {
        ArrayList<Participant> participants = new ArrayList<>();
        Collections.shuffle(this.list);
        IO.println(" ===== SHUFFLED ===== ");

        for (Participant p : this.list) {
            IO.println(p);
        }

        for (int i = 0; i < this.nomination.getListSize(); i++) {
            if (i % 4 == 0) {
                this.groups.add(this.list);
            }
        }

        IO.println("group get: " + this.groups.get(0));
    }
}
