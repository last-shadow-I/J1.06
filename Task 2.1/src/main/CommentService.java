import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CommentService {

  private ArrayList<Comment> comments;

  public CommentService(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  public Comment[] getModeratedComments(){
    return comments.stream()
            .filter(Comment::isModerationCompleted)
            .sorted(Comparator.comparing(Comment::getCommentDate))
            .toArray(Comment[]::new);
  }

  public Comment[] getModeratedComments(int page, int pageSize){
    Comment[] moderatedComments = getModeratedComments();
    int indexOnPage = page*pageSize;
    return Arrays.stream(moderatedComments)
            .skip(indexOnPage)
            .limit(pageSize)
            .toArray(Comment[]::new);
  }

  public Comment[] getAuthorComments(String authorName){
    return comments.stream()
            .filter(c -> c.getAuthorName().equals(authorName))
            .sorted(Comparator.comparing(Comment::isModerationCompleted))
            .toArray(Comment[]::new);
  }

  public Comment[] getAuthorComments(String authorName, int page, int pageSize){
    Comment[] authorComment = getAuthorComments(authorName);
    int indexOnPage = page*pageSize;
    return Arrays.stream(authorComment)
            .skip(indexOnPage)
            .limit(pageSize)
            .toArray(Comment[]::new);
  }

  public String[] getAuthorAfterDate(LocalDate date){
    return comments.stream()
            .filter(c -> c.getCommentDate().isAfter(date))
            .map(Comment::getAuthorName).distinct()
            .toArray(String[]::new);
  }

  public String[] getAuthorAfterDate(LocalDate date, int page, int pageSize){
    String[] authorAfterDate = getAuthorAfterDate(date);
    int indexOnPage = page*pageSize;
    return Arrays.stream(authorAfterDate)
            .skip(indexOnPage)
            .limit(pageSize)
            .toArray(String[]::new);
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }


}
