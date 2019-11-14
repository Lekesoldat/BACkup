package backend.core;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The person featured in the drinking session.
 */
public class Person {
  private String id;
  private String name;
  private double weight;
  private char gender;
  private ArrayList<DrinkingSession> sessions;

  /**
   * Creation of a new Person.
   * 
   * @param name   The persons name.
   * @param weight The persons weight.
   * @param gender The persons gender. 'M' or 'F'
   */
  public Person(String name, double weight, char gender) {
    if (Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'f') {
      throw new IllegalArgumentException("Illegal gender.");
    }

    this.sessions = new ArrayList<DrinkingSession>();
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.weight = weight;
    this.gender = gender;
  }

  /**
   * @return the ID
   */
  public String getId() {
    return id;
  }

  /**
   * Empty constructor for the Jackson-serialization.
   */
  public Person() {
  }

  /**
   * 
   * @return a list over drinking sessions.
   */
  public ArrayList<DrinkingSession> getSessions() {
    return sessions;
  }

  /**
   * Store a drink on the user.
   * 
   * @param drink the drink to be stored.
   */
  public void addDrink(Drink drink) {
    this.sessions.get(sessions.size() - 1).addDrink(drink);
  }

  /**
   * Start a new drinking session.
   */
  public void newSession() {
    sessions.add(new DrinkingSession());
  }

  /**
   * @return the gender.
   */
  public char getGender() {
    return gender;
  }

  /**
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * @return the weight.
   */
  public double getWeight() {
    return weight;
  }
}