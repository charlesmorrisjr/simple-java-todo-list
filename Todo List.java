import java.util.Scanner;
import java.util.ArrayList;

class TodoListProgram {
 
  private static ArrayList<TodoTask> todoList = new ArrayList<TodoTask>();
  private static Scanner input = new Scanner(System.in);

  public static void addTask() {
    System.out.println("Enter name of new task: ");
    
    String taskName = input.next();
    
    todoList.add(new TodoTask(taskName));
  }

  public static void checkTask() {
    System.out.println("Enter number of task to check/uncheck. Enter 0 to return to main screen.");

    while (true) {
      if (input.hasNextInt()) {
        int taskNum = input.nextInt();

        if (taskNum > 0 && taskNum <= todoList.size()) {
          todoList.get(taskNum - 1).checkOrUncheck();
          break;
        } else if (taskNum == 0) {
          break;
        } else {
          System.out.println("Invalid choice. Please try again.");
        }
      } else {
        System.out.println("Invalid choice. Please try again.");
        input.next();
      }
    }
  }

  public static void removeTask() {
    System.out.println("Enter number of task to remove. Enter 0 to return to main screen.");

    while (true) {
      if (input.hasNextInt()) {
        int taskNum = input.nextInt();

        if (taskNum > 0 && taskNum <= todoList.size()) {
          todoList.remove(taskNum - 1);
          break;
        } else if (taskNum == 0) {
          break;
        } else {
          System.out.println("Invalid choice. Please try again.");
        }
      } else {
        System.out.println("Invalid choice. Please try again.");
        input.next();
      }
    }
  }

  public static void displayTodoList() {
    System.out.println("");

    for (int i = 0; i < todoList.size(); i++) {
      System.out.println((i + 1) + ". [" + todoList.get(i).getCheckMark() + "] " + todoList.get(i).displayTaskName());
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    
    boolean userExit = false;
    
    todoList.add(new TodoTask("Wake up"));
    todoList.add(new TodoTask("Meditate"));
    
    while (!userExit) {
      if (todoList.size() == 0) {
        System.out.println("\nNo items on the to-do list!");
        System.out.println("\n1. Add task");
      } else {
        displayTodoList();
        System.out.println("1. Add task, 2. Check/uncheck task, 3. Remove task");
      }

      System.out.println("or type 'exit' to close the app.\n");

      while (true) {
        System.out.println("Select an option: ");

        String userInput = input.next();

        if (userInput.equals("1")) {
          addTask();
          break;
        } else if (userInput.equals("2") && todoList.size() > 0) {
          checkTask();
          break;
        } else if (userInput.equals("3") && todoList.size() > 0) {
          removeTask();
          break;
        } else if (userInput.equalsIgnoreCase("exit")) {
          userExit = true;
          break;
        } else {
          System.out.println("Invalid choice. Please try again.");
        }
      }
    }

    input.close();

    System.out.println("\nBye!");
  }
}