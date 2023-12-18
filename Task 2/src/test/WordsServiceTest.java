import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsServiceTest {

  String[] inputStrings = new String[] {"", "Да; и; но ((4))", "Добрый день!", "сине-зеленый",
          "Чашка9123кофе_____с    молоком без сахара.123", "Эх раз, да еще раз, да еще много-много раз!", """
    Lorem ipsum dolor sit amet, consectetur
    adipiscing elit, sed do eiusmod tempor
    incididunt ut labore et dolore magna aliqua. Ut
    enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
    consequat. Duis aute irure dolor in reprehenderit
    in voluptate velit esse cillum dolore eu fugiat
    nulla pariatur. Excepteur sint occaecat cupidatat
    non proident, sunt in culpa qui officia deserunt
    mollit anim id est laborum."""};
  String[] outputStrings = new String[] {"", "", "ДЕНЬ ДОБРЫЙ", "ЗЕЛЕНЫЙ СИНЕ", "БЕЗ КОФЕ МОЛОКОМ САХАРА ЧАШКА",
          "ЕЩЕ МНОГО РАЗ", "ADIPISCING ALIQUA ALIQUIP AMET ANIM AUTE CILLUM COMMODO CONSECTETUR CONSEQUAT CULPA " +
          "CUPIDATAT DESERUNT DOLOR DOLORE DUIS EIUSMOD ELIT ENIM ESSE EST EXCEPTEUR EXERCITATION FUGIAT INCIDIDUNT " +
          "IPSUM IRURE LABORE LABORIS LABORUM LOREM MAGNA MINIM MOLLIT NISI NON NOSTRUD NULLA OCCAECAT OFFICIA PARIATUR " +
          "PROIDENT QUI QUIS REPREHENDERIT SED SINT SIT SUNT TEMPOR ULLAMCO VELIT VENIAM VOLUPTATE"};
  @Test
  void prepareStringTest() {
    for (int i = 0; i < inputStrings.length; i++) {
      assertEquals(outputStrings[i], WordsService.prepareString(inputStrings[i]));
    }
  }
}