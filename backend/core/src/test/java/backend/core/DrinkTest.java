package backend.core;

import backend.core.BAC;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DrinkTest {

  @Test
  public void testBACIsWrong() {
    assertNotEquals(0.2, BAC.getBAC(70.0, 'M', 5.0, 5.0, 0.0));
  }

  @Test
  public void testConstructor() {
    Drink drink = new Drink(37.5, 10.0);
    assertThat(37.5, is(drink.getPercentage()));
  }

  @Test
  public void testGetVolume() {
    Drink drink = new Drink(37.5, 10.0);
    assertThat(10.0, is(drink.getVolume()));
  }

  @Test
  public void testGetDateNotEquals() {
    Drink drink = new Drink(37.5, 10.0);
    assertNotEquals("08102019", drink.getDate());
  }

  @Test
  public void testEmptyConstructor() {
    Drink drink = new Drink();
    assertThat(null, is(drink.getDate()));
  }

}
