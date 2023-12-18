import java.util.Arrays;
import java.util.stream.Collectors;

public class WordsService {

  public static String prepareString(String str){

    String[] strings = str.split("(?U)\\W+|\\d+|_+");

    return Arrays.stream(strings)
            .filter(c -> c.length() > 2)
            .map(String::toUpperCase)
            .distinct()
            .sorted()
            .collect(Collectors.joining(" "));
  }
}
