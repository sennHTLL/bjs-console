package bridge;

public class ScoredParticipant {

    private String name;
    private double score;

    public ScoredParticipant(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public double getScore() {
        return this.score;
    }

    public String toString() {
        return this.name + " · " + this.score;
    }

    public String toFile() {
        return this.name + ", " + this.score;
    }
}
