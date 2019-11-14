
package backend.core;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ColorTest {
  @Test
  public void testAllColors() {
    Color.green("Green!");
    Color.red("Red!");
    Color.yellow("Yellow!");
    Color.yellowBG("Yellow Background!");
  }

  @Test
  public void testEmptyConstructor() {
    Color color = new Color();
    assertThat(color, instanceOf(Color.class));
  }

}
