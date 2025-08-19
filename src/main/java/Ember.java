import java.util.Scanner;

public class Ember {
    public static void main(String[] args) throws MissingInformationException {
        Scanner scanner = new Scanner(System.in);
        String line = "____________________________________________________________\n";
        ListManager list = new ListManager();

        System.out.println(line +
                "Hello! I'm Ember\n" +
                "What can I do for you?\n" +
                line
        );

        while (true) {
            try {
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println(line +
                            "Bye. Hope to see you again soon!\n" +
                            line
                    );
                    break;
                } else if (userInput.equalsIgnoreCase("list")) {
                    list.printList();
                } else if (userInput.toLowerCase().startsWith("mark")) {
                    String[] parts = userInput.split(" ");
                    if (parts.length == 2) {
                        list.mark(Integer.parseInt(parts[1]));
                    }
                } else if (userInput.toLowerCase().startsWith("unmark")) {
                    String[] parts = userInput.split(" ");
                    if (parts.length == 2) {
                        list.unmark(Integer.parseInt(parts[1]));
                    }
                } else {
                    if (userInput.toLowerCase().startsWith("todo")) {
                        try {
                            String taskName = userInput.substring(5);
                            list.inputList(taskName);
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("Remember to input a 'space' before typing your task description");
                        }
                    } else if (userInput.toLowerCase().startsWith("deadline")) {
                        try {
                            String[] parts = userInput.split(" /by ");
                            String taskName = parts[0].substring(9);
                            String taskDeadline = parts[1];
                            list.inputList(taskName, taskDeadline);
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("Remember to input a 'space' before typing your task description. ");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("After typing your task description, input your deadline with '/by (date)'. ");
                        }
                    } else if (userInput.toLowerCase().startsWith("event")) {
                        try {
                            String[] parts = userInput.split(" /from ");
                            String taskName = parts[0].substring(6);
                            String[] taskDetail = parts[1].split(" /to ");
                            String taskStart = taskDetail[0];
                            String taskEnd = taskDetail[1];
                            list.inputList(taskName, taskStart, taskEnd);
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("Remember to input a 'space' before typing your task description. ");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("After typing your task description, input your deadline with '/from (date) /to (date)'. ");
                        }
                    } else if (userInput.toLowerCase().startsWith("delete")) {
                        try {
                            String[] parts = userInput.split(" ");
                            if (parts.length == 2) {
                                list.deleteTask(Integer.parseInt(parts[1]));
                            }
                        } catch (InvalidInputException | NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(line);
                        throw new InvalidInputException("You have entered an invalid input.\n " +
                                "To add a new task, start with: todo, deadline or event.\n " +
                                "To exit, type 'bye'.");
                    }
                }
            } catch (InvalidInputException | MissingInformationException e) {
                System.out.println(e.toString());
            }
        }
    }
}
