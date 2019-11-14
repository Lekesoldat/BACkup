package backend.core;

import backend.core.BAC;

import org.junit.Test;

import static org.junit.Assert.*;

public class BACTest {
  @Test
  public void testBACIsWrong() {
    assertNotEquals(0.2, BAC.getBAC(70.0, 'M', 5.0, 5.0, 0.0));
  }

  @Test
  public void testEmptyConstructor() {
    assertNotNull(new BAC());
  }
}
