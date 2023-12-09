import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

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

    for (int i = 0; i < localDates.length; i++) {
      comments.add(new Comment(authors[i], localDates[i], booleans[i], commentTexts[i]));
    }

    CommentService commentService = new CommentService(comments);

    Comment[] moderatedComment = commentService.getModeratedComments();
    System.out.println("Модерированные комментарии");
    for (Comment comment: moderatedComment) {
      System.out.println(comment + " " + comment.getCommentDate() + " " + comment.isModerationCompleted() + " " + comment.getAuthorName());
    }

    moderatedComment = commentService.getModeratedComments(1, 4);
    System.out.println("\nМодерированные комментарии на 1 странице по 3 комментария");
    for (Comment comment: moderatedComment) {
      System.out.println(comment + " " + comment.getCommentDate() + " " + comment.isModerationCompleted() + " " + comment.getAuthorName());
    }

    Comment[] authorComment = commentService.getAuthorComments("1");
    System.out.println("\nАвторские комментарии");
    for (Comment comment: authorComment) {
      System.out.println(comment + " " + comment.getCommentDate() + " " + comment.isModerationCompleted() + " " + comment.getAuthorName());
    }

    authorComment = commentService.getAuthorComments("1", 1, 2);
    System.out.println("\nАвторские комментарии на 1 странице по 2 комментария");
    for (Comment comment: authorComment) {
      System.out.println(comment + " " + comment.getCommentDate() + " " + comment.isModerationCompleted() + " " + comment.getAuthorName());
    }

    String[] authorAfterDate = commentService.getAuthorAfterDate(localDates[1]);
    System.out.println("\nАвторы комментирующие после " + localDates[1]);
    for (String s: authorAfterDate) {
      System.out.println(s);
    }

    authorAfterDate = commentService.getAuthorAfterDate(localDates[1], 4, 1);
    System.out.println("\nАвторы комментирующие после " + localDates[1] + " на 4 странице по 1 комментарию");
    for (String s: authorAfterDate) {
      System.out.println(s);
    }

  }
}