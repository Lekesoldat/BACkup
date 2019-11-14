package backend.server;

import backend.core.Color;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Initialize the Spring-server.
 */
@SpringBootApplication
public class RestServer {
  /**
   * 
   * @param args the main arguments.
   */
  public static void main(String[] args) {
    Color.yellow("SpringApplication booting..");
    SpringApplication.run(RestServer.class, args);
  }

  /**
   * Displauy a message after server boot.
   */
  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {
    Color.green("Server is ready to use!");
  }
}