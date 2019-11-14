package backend.core;

import java.util.ArrayList;

/**
 * DrinkingSession
 */
public class DrinkingSession {
  private ArrayList<Drink> drinks;

  /**
   * Creates a new array of drinks
   */
  public DrinkingSession() {
    this.drinks = new ArrayList<>();
  }

  /**
   * 
   * @return a list of drinks.
   */
  public ArrayList<Drink> getDrinks() {
    return drinks;
  }

  /**
   * Adds the drink to the array of drinks
   * 
   * @param drink is a unit that the person has consumed
   */
  public void addDrink(Drink drink) {
    this.drinks.add(drink);
  }

}