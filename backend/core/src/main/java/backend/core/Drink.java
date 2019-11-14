package backend.core;

import java.util.Date;

/**
 * Drink
 */
public class Drink {
  private String date = null;
  private double percentage;
  private double volume;

  /**
   * Constructor for the drink-object (Creating a new drink)
   * @param percentage of the beverage
   * @param volume of the consumed drink
   */
  public Drink(double percentage, double volume) {
    Date today = new Date();
    this.date = Long.toString(today.getTime());
    this.percentage = percentage;
    this.volume = volume;
  }

  /**
   * Empty constructor for the drink-object
   */
  public Drink() {

  }

  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }

  /**
   * @return the percentage
   */
  public double getPercentage() {
    return percentage;
  }

  /**
   * @return the volume
   */
  public double getVolume() {
    return volume;
  }
}