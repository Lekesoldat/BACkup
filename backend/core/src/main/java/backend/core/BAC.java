package backend.core;

public class BAC {
  /**
   * 
   * @param weight      users height.
   * @param gender      users gender, - either 'M' or 'F'.
   * @param volume      liquid consumed in dL.
   * @param percentage  alcohol percentage in the dirnk.
   * @param elapsedTime time spent drinking.
   * @return the current BAC.
   */
  public static double getBAC(double weight, char gender, double volume, double percentage, double elapsedTime) {
    return ((volume * percentage) / (weight * 2.668 * (gender == 'M' ? 0.68 : 0.55)))
        - ((elapsedTime) / ((1000 * 3600)) * 0.015);
  }
}