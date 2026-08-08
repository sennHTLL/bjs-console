package classes;

public class Participant {

  private String name;
  private int age;

  public Participant(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public String updName(String name) {
    return this.name = name;
  }

  public int updAge(int age) {
    return this.age = age;
  }

  @Override
  public String toString() {
    return this.name + " · " + this.age;
  }

  public String toFile() {
    return this.name + ", " + this.age;
  }
}
