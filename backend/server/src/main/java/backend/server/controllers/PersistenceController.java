package backend.server.controllers;

import backend.core.Drink;
import backend.core.Person;
import backend.json.JSONHandler;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServerController defines the REST-api endpoints.
 */
@RestController
public class PersistenceController {
  /**
   * @return a welcome message for root.
   */
  @RequestMapping("/")
  public String index() {
    return "Hello, from ServerController.java";
  }

  /**
   * @return a list of the registered users.
   */
  @GetMapping("/api/users")
  public List<Person> getRegisteredUsers() {
    File[] users = JSONHandler.getDirectoryListing();
    List<Person> registeredUsers = new ArrayList<>();

    if (users != null) {
      try {
        for (File user : users) {
          registeredUsers.add(JSONHandler.readFile(user));
        }
      } catch (IOException e) {
        System.err.println("GET /registeredUsers failed.");
      }
    }

    return registeredUsers;
  }

  /**
   * Get a user with the desired id.
   * 
   * @param id the id of the user to be found.
   * @return the user if found.
   */
  @GetMapping("/api/users/{id}")
  public Person getPerson(@PathVariable String id) {
    return JSONHandler.getUser(id);
  }

  /**
   * Take tha data from POST-request and store it as a new drink on the provided
   * user.
   * 
   * @param id    the user id.
   * @param drink the drink-data.
   * @return the user the drink was stored on.
   */
  @PostMapping("/api/users/{id}/drink")
  public Person addDrink(@PathVariable String id, @RequestBody String drink) {
    // Convert JSON String to Java Object
    Gson gson = new Gson();
    Drink object = gson.fromJson(drink, Drink.class);

    // Get the person to add the drink on
    Person person = JSONHandler.getUser(id);
    person.addDrink(object);

    // Store user after drink is added.
    try {
      JSONHandler.writeFile(person);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Fetch the user one last time to make sure that the updated user is getting
    // returned.
    return JSONHandler.getUser(id);
  }

  /**
   * Initiate a new drinking session.
   * 
   * @return the person.
   */
  @PostMapping("/api/users/{id}/session")
  public Person startSession(@PathVariable String id) {
    Person user = JSONHandler.getUser(id);
    if (user != null) {
      user.newSession();
    }

    try {
      JSONHandler.writeFile(user);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return user;
  }

  /**
   * Stores the current person when a POST request is made to /storeUser
   * 
   * @param person the person to be stored on the server.
   * @return the person object that was stored.
   */
  @PostMapping("/api/users")
  public Person storeUser(@RequestBody String person) {
    // Deserialize Person-object
    Gson gson = new Gson();
    Person user = gson.fromJson(person, Person.class);

    // If the user lacks a unique ID, it's a new user. Store if it already exists.
    try {

      if (user.getId() != null) {
        JSONHandler.writeFile(user);
      } else {
        Person newUser = new Person(user.getName(), user.getWeight(), user.getGender());
        JSONHandler.writeFile(newUser);
        user = newUser;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return user;
  }
}