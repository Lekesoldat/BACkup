package backend.api.services;

import backend.core.Person;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Define which enpoints exist and how to access them.
 */
public interface PersistenceService {
  /**
   * @return a list of registered people
   */
  @GET("/api/users")
  Call<List<Person>> getRegisteredUsers();

  /**
   * 
   * @return the stored person.
   */
  @POST("/storeUser")
  Call<Person> storeUser(@Body Person person);
}
