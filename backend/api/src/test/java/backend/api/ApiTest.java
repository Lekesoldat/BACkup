
package backend.api;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import backend.api.services.PersistenceService;

public class ApiTest {
  @Test
  public void testConstructor() {
    Api api = new Api("http://localhost:1337");
    assertThat(api, instanceOf(Api.class));
  }

  @Test
  public void testcreatePersistenceService() {
    Api api = new Api("http://localhost:1337");
    PersistenceService service = api.createPersistenceService();
    assertThat(service, instanceOf(PersistenceService.class));
  }

}
