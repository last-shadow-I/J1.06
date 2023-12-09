import java.util.Arrays;

public class Main {

  public static String prepareString(String str){

    String[] strings = str.split("(?U)\\W+|\\d+|_+");

    return Arrays.stream(strings)
            .filter(c -> c.length() > 2)
            .map(String::toUpperCase)
            .distinct()
            .sorted().reduce("", (a,b) -> a + " " + b).trim();
  }

  public static void main(String[] args) {

    String text = "Чашка9123кофе_____с    молоком без сахара.123";


    System.out.println(prepareString(text));

    System.out.println(prepareString("Добрый день!"));

    System.out.println(prepareString("Эх раз, да еще раз, да еще много-много раз!"));

    System.out.println(prepareString("""
            Lorem ipsum dolor sit amet, consectetur
                adipiscing elit, sed do eiusmod tempor
                incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit
            in voluptate velit esse cillum dolore eu fugiat
            nulla pariatur. Excepteur sint occaecat cupidatat
            non proident, sunt in culpa qui officia deserunt
            mollit anim id est laborum."""));

  }
}