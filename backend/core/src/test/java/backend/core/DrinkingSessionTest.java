
package backend.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class DrinkingSessionTest {
  @Test
  public void testgetDrinks() {
    DrinkingSession session = new DrinkingSession();
    Drink drink = new Drink(37.5, 10.0);
    session.addDrink(drink);
    ArrayList<Drink> sessionDrinks = session.getDrinks();
    assertEquals(drink, sessionDrinks.get(0));
  }
}