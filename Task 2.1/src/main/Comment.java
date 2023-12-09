import java.time.LocalDate;

public class Comment {

  private String authorName;
  private LocalDate commentDate;
  private boolean isModerationCompleted;
  private String commentText;

  public Comment(String authorName, LocalDate commentDate, boolean isModerationCompleted, String commentText) {
    setAuthorName(authorName);
    setCommentDate(commentDate);
    setModerationCompleted(isModerationCompleted);
    setCommentText(commentText);
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public LocalDate getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(LocalDate commentDate) {
    this.commentDate = commentDate;
  }

  public boolean isModerationCompleted() {
    return isModerationCompleted;
  }

  public void setModerationCompleted(boolean moderationCompleted) {
    isModerationCompleted = moderationCompleted;
  }

  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }
}
