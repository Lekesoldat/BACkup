package backend.json;

import backend.core.Person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JSONHandler
 */
public class JSONHandler {
  private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  /**
   * Stores the file in the ../out/profiles directory.
   * 
   * @param person the user to be stored.
   * @throws FileNotFoundException caused by the PrintWriter.
   */
  public static void writeFile(Person person) throws FileNotFoundException {
    // Enable pretty printing of JSON.
    File file = new File("../out/profiles/" + person.getId() + ".json");
    file.getParentFile().mkdirs();
    try (PrintWriter printWriter = new PrintWriter(file)) {
      String json = GSON.toJson(person);

      printWriter.println(json);
    }
  }

  /**
   * Use to choose file name.
   * 
   * @param path   filename.
   * @param person the person to be stored.
   * @throws FileNotFoundException exception.
   */
  public static void writeFile(String path, Person person) throws FileNotFoundException {
    // Enable pretty printing of JSON.
    File file = new File("../out/profiles/" + path + ".json");
    file.getParentFile().mkdirs();
    try (PrintWriter printWriter = new PrintWriter(file)) {
      String json = GSON.toJson(person);
      printWriter.println(json);
    }
  }

  /**
   *
   * 
   * @param file where the user data is stored.
   * @return the Person-object.
   * @throws IOException file not found.
   */
  public static Person readFile(File file) throws IOException {
    try (FileReader fileReader = new FileReader(file)) {
      Person person = GSON.fromJson(fileReader, Person.class);
      return person;
    }
  }

  /**
   * @param id of the person. Also found as the filename.
   * @return the person with a given id (or null if no such person exists)
   */
  public static Person getUser(String id) {
    File[] list = getDirectoryListing();

    if (list != null) {
      try {
        for (File user : list) {
          // Remove the .json-file ending in comparison.
          if (user.getName().split(".json")[0].equals(id)) {
            return readFile(user);
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  /**
   * @return a list of all the persons (or rather, their profiles)
   */
  public static File[] getDirectoryListing() {
    File dir = new File("../out/profiles/");
    return dir.listFiles();
  }
}