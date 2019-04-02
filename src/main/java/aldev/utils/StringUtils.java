package aldev.utils;

/**
 * StringUtils
 */
public class StringUtils {

  public static String formAcronym(String name) {
    String acronym = "";
    for (String n : name.split(" ")) {
      acronym += n.charAt(0);
    }
    return acronym;
  }

  public static String formPassword(int password, String acronym) {
    return acronym + "-" + password;
  }
}