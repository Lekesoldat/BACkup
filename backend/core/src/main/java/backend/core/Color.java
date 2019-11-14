package backend.core;

/**
 * Simplify printing with colors.
 */
public class Color {
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String RESET = "\u001B[0m";
  public static final String YELLOW = "\u001B[33m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

  /**
   * @param input the text to be colored green.
   */
  public static void green(Object input) {
    System.out.println(GREEN + input.toString() + RESET);
  }

  /**
   * @param input the text to be colored red.
   */
  public static void red(Object input) {
    System.out.println(RED + input.toString() + RESET);
  }

  /**
   * @param input the text to be colored yellow.
   */
  public static void yellow(Object input) {
    System.out.println(YELLOW + input.toString() + RESET);
  }

  /**
   * @param input the text to have yellow background color.
   */
  public static void yellowBG(Object input) {
    System.out.println(ANSI_YELLOW_BACKGROUND + RED + input.toString() + RESET);
  }
}