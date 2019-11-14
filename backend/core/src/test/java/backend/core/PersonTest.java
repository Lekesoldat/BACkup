
package backend.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonTest {
  @Test(expected = IllegalArgumentException.class)
  public void testOnlyTwoGenders() {
    new Person("Helicopter", 80.98, 'H');
  }

  @Test
  public void testCorrectGender() {
    Person p = new Person("Paal", 80.5, 'M');
    assertEquals('M', p.getGender());
  }

  @Test
  public void testGetName() {
    Person person = new Person("Liv", 55.0, 'F');
    assertNotEquals("Magnus", person.getName());
  }

  @Test
  public void testGetWeight() {
    Person person = new Person("Liv", 55.0, 'F');
    assertThat(55.0, is(person.getWeight()));
  }

  @Test
  public void testEmptyConstructor() {
    Person p = new Person();
    assertThat(null, is(p.getName()));
  }

  @Test
  public void testGetDrinkingsessions() {
    Person person = new Person("Bob Ross", 55.0, 'F');
    assertNotEquals(null, person.getSessions());
  }

  @Test
  public void testAddDrink() {
    Person person = new Person("Bob Ross", 55.0, 'M');
    person.newSession();
    person.addDrink(new Drink(10.0, 40.0));
    assertThat(1, is(person.getSessions().get(person.getSessions().size() - 1).getDrinks().size()));
  }
}
