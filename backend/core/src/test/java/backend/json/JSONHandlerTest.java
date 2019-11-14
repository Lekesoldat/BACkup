
package backend.json;

import backend.core.Drink;
import backend.core.Person;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JSONHandlerTest {
  @Test
  public void testEmptyConstructor() {
    JSONHandler color = new JSONHandler();
    assertThat(color, instanceOf(JSONHandler.class));
  }

  @Test
  public void testWriteFile() {
    try {
      Person fullPerson = new Person("Magnus Holtet", 85.0, 'M');
      fullPerson.newSession();
      fullPerson.addDrink(new Drink(40.0, 10));
      fullPerson.addDrink(new Drink(4.7, 5.0));
      fullPerson.addDrink(new Drink(35.0, 0.7));

      JSONHandler.writeFile(fullPerson);
      JSONHandler.writeFile("TestFile", new Person("DO NOT CLICK", 65, 'F'));
      JSONHandler.writeFile(new Person("Kristoffer Nyvoll", 90.0, 'M'));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testReadFile() {
    try {
      JSONHandler.readFile(new File("../out/profiles/TestFile.json"));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}
