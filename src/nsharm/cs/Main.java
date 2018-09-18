package nsharm.cs;

public class Main {

  public static void main(String[] args) {
    System.out.println(WebScraper.counter(WebScraper.urlToString("https://www.bls.gov/tus/charts/chart9.txt")));
  }
}
