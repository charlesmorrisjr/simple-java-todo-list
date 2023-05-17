import java.util.Scanner;
import java.util.ArrayList;

class TodoListProgram {
 
  private static ArrayList<TodoTask> todoList = new ArrayList<TodoTask>();
  private static Scanner input = new Scanner(System.in);

  public static void addTask() {
    System.out.println("Enter name of new task: ");
    
    // input.nextLine();
    String taskName = input.nextLine().trim();
    
    todoList.add(new TodoTask(taskName));
  }

  public static void checkTask() {
    System.out.println("Enter number of task to check/uncheck. Enter 0 to return to main screen.");

    int taskNum = getTaskNumInput();
    
    if (taskNum > 0) {
      todoList.get(taskNum - 1).checkOrUncheck();
    }
  }

  public static void removeTask() {
    System.out.println("Enter number of task to remove. Enter 0 to return to main screen.");

    int taskNum = getTaskNumInput();
    
    if (taskNum > 0) {
      todoList.remove(taskNum - 1);
    }
  }

  public static int getTaskNumInput() {
    while (true) {
      try {
        int taskNum = Integer.parseInt(input.nextLine());

        if (taskNum >= 0 && taskNum <= todoList.size()) {
          return taskNum;
        } else {
          System.out.println("Invalid choice. Please try again.");
        }
      } catch (Exception ex) {
        System.out.println("Invalid choice. Please try again.");
        input.reset();
      }
    }
  }

  public static void displayTodoList() {
    System.out.println("");

    for (int i = 0; i < todoList.size(); i++) {
      System.out.println((i + 1) + ". [" + todoList.get(i).getCheckMark() + "] " + todoList.get(i).getTaskName());
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    
    boolean userExit = false;
    
    todoList.add(new TodoTask("Meditate"));
    todoList.add(new TodoTask("Exercise"));
    todoList.add(new TodoTask("Wash car"));
    todoList.add(new TodoTask("Practice guitar"));
    todoList.add(new TodoTask("Grocery shopping"));
    
    do {
      System.out.println("To-Do List");

      if (todoList.size() > 0) {
        displayTodoList();
        System.out.println("1. Add task, 2. Check/uncheck task, 3. Remove task");
        System.out.println("Enter the number '1', '2', or '3'; or type 'exit' to close the app.\n");
      } else {
        System.out.println("\nNo items on the to-do list!");
        System.out.println("\n1. Add task");
        System.out.println("Enter the number '1' or type 'exit' to close the app.\n");
      }

      while (true) {
        System.out.println("Select an option: ");

        String userInput = input.nextLine().trim();

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
    } while (!userExit);

    input.close();

    System.out.println("\nBye!");
  }
}