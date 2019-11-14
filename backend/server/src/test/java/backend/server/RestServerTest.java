package backend.server;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import backend.api.Api;
import backend.api.services.PersistenceService;
import backend.core.Person;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class RestServerTest {
  Api api = new Api("http://localhost:8080");
  PersistenceService service = api.createPersistenceService();

  /**
   * Create empty string to run main.
   */
  @BeforeClass
  public static void beforeAllTestMethods() {
    System.out.println("Invoked once before all test methods");
    String[] arguments = new String[] { "something" };
    RestServer.main(arguments);
  }

  @Test
  public void testGetRegisteredUsers() throws IOException {
    List<Person> data = service.getRegisteredUsers().execute().body();
    System.out.println(data);
    if (data.size() > 0) {
      assertThat(data.get(0), instanceOf(Person.class));
    }
  }
}
