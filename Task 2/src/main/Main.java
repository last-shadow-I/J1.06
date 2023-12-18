
public class Main {



  public static void main(String[] args) {

    String text = "Чашка9123кофе_____с    молоком без сахара.123";


    System.out.println(WordsService.prepareString(text));

    System.out.println(WordsService.prepareString("Добрый день!"));

    System.out.println(WordsService.prepareString("Эх раз, да еще раз, да еще много-много раз!"));

    System.out.println(WordsService.prepareString("""
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