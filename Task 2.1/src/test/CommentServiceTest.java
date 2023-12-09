import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {
  ArrayList<Comment> comments = new ArrayList<>();

  DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  String[] authors = {"1", "2", "3", "5", "2", "1", "1", "4", "6", "1"};

  LocalDate[] localDates = {LocalDate.parse("07.02.2022", dTF),
          LocalDate.parse("22.09.1931", dTF),
          LocalDate.parse("07.02.2022", dTF),
          LocalDate.parse("13.04.1963", dTF),
          LocalDate.parse("12.02.1907", dTF),
          LocalDate.parse("15.06.1977", dTF),
          LocalDate.parse("03.10.1995", dTF),
          LocalDate.parse("07.02.2022", dTF),
          LocalDate.parse("12.01.2022", dTF),
          LocalDate.parse("12.01.2022", dTF)};

  boolean[] booleans = {true, false, true, false, false, true, true, true, true, false};

  String[] commentTexts = {"Высокий уровень вовлечения представителей целевой аудитории является четким " +
          "доказательством простого факта: постоянный количественный рост и сфера нашей активности требует анализа " +
          "как самодостаточных, так и внешне зависимых концептуальных решений!",
          "С учётом сложившейся международной обстановки, существующая теория, а также свежий взгляд на привычные " +
                  "вещи — безусловно открывает новые горизонты для анализа существующих паттернов поведения.",
          "С другой стороны, экономическая повестка сегодняшнего дня влечет за собой процесс внедрения и" +
                  " модернизации переосмысления внешнеэкономических политик.",
          "Равным образом, дальнейшее развитие различных форм деятельности однозначно определяет каждого участника " +
                  "как способного принимать собственные решения касаемо экономической целесообразности принимаемых решений!",
          "Кстати, многие известные личности, вне зависимости от их уровня, должны быть преданы социально-демократической анафеме.",
          "Сложно сказать, почему независимые государства описаны максимально подробно.",
          "Как принято считать, акционеры крупнейших компаний, которые представляют собой яркий пример " +
                  "континентально-европейского типа политической культуры, будут преданы социально-демократической анафеме.",
          "Повседневная практика показывает, что граница обучения кадров влечет за собой процесс внедрения и " +
                  "модернизации системы обучения кадров, соответствующей насущным потребностям.",
          "Предварительные выводы неутешительны: базовый вектор развития позволяет оценить значение благоприятных перспектив.",
          "Однозначно, явные признаки победы институционализации, которые представляют собой яркий пример континентально-европейского типа политической культуры, будут объективно рассмотрены соответствующими инстанциями."
  };

  {
    for (int i = 0; i < localDates.length; i++) {
      comments.add(new Comment(authors[i], localDates[i], booleans[i], commentTexts[i]));
    }
  }

  CommentService commentService = new CommentService(comments);

  @Test
  void getModeratedComments() {
    Comment[] moderatedComment = commentService.getModeratedComments();
    Comment[] outputComment = {comments.get(5), comments.get(6), comments.get(8), comments.get(0), comments.get(2), comments.get(7)};
    assertArrayEquals(outputComment, moderatedComment);
  }

  @Test
  void testGetModeratedComments() {
    Comment[] moderatedComment = commentService.getModeratedComments(1, 4);
    Comment[] outputComment = {comments.get(2), comments.get(7)};
    assertArrayEquals(outputComment, moderatedComment);
  }

  @Test
  void getAuthorComments() {
    Comment[] moderatedComment = commentService.getAuthorComments("1");
    Comment[] outputComment = {comments.get(9), comments.get(0), comments.get(5), comments.get(6)};
    assertArrayEquals(outputComment, moderatedComment);
  }

  @Test
  void testGetAuthorComments() {
    Comment[] moderatedComment = commentService.getAuthorComments("1", 1, 2);
    Comment[] outputComment = {comments.get(5), comments.get(6)};
    assertArrayEquals(outputComment, moderatedComment);
  }

  @Test
  void getAuthorAfterDate() {
    String[] moderatedComment = commentService.getAuthorAfterDate(localDates[1]);
    String[] outputComment = {"1", "3", "5", "4", "6"};
    assertArrayEquals(outputComment, moderatedComment);
  }

  @Test
  void testGetAuthorAfterDate() {
    String[] moderatedComment = commentService.getAuthorAfterDate(localDates[1], 4, 1);
    String[] outputComment = {"6"};
    assertArrayEquals(outputComment, moderatedComment);
  }
}