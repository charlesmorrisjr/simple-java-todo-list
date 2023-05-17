public class TodoTask {
  private String taskName;
  private boolean checked;

  public TodoTask(String name) {
    this.taskName = name;
    this.checked = false;
  }
  
  public void checkOrUncheck() {
    this.checked = !this.checked;
  }

  public String getCheckMark() {
    return this.checked ? "X" : " ";
  }

  public String displayTaskName() {
    return this.taskName;
  }
}