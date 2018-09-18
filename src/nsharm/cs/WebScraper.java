package nsharm.cs;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Class declaration for WebScraper.
 */
public class WebScraper {

  /**
   * Function that finds number of words in a url.
   *
   * @param url is link converted to string
   * @return returns word count
   */
  public static int counter(String url) {
    int count = 0;
    boolean isWord = false;
    for (int i = 0; i <  url.length(); i++) {
      if (Character.isLetter(url.charAt(i)) && i != url.length() - 1) {
        isWord = true;
      } else if (!Character.isLetter(url.charAt(i)) && isWord) {
        count++;
        isWord = false;
      } else if (Character.isLetter(url.charAt(i)) && i == url.length() - 1) {
        count++;
      }
    }
    return count;
  }

  /**
   * Retrieve contents from a URL and return them as a string.
   *
   * @param url url to retrieve contents from
   * @return the contents from the url as a string, or an empty string on error
   */
  public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
      urlScanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
  }
}
