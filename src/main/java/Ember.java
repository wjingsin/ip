import java.util.LinkedList;
import java.util.Scanner;

public class Ember {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "____________________________________________________________\n";
        ListManager list = new ListManager();

        System.out.println(line +
                "Hello! I'm Ember\n" +
                "What can I do for you?\n" +
                line
        );

        while (true) {
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
                    String taskName = userInput.substring(5);
                    list.inputList(taskName);
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    String[] parts = userInput.split(" /by ");
                    String taskName = parts[0].substring(9);
                    String taskDeadline = parts[1];
                    list.inputList(taskName, taskDeadline);
                } else if (userInput.toLowerCase().startsWith("event")) {
                    String[] parts = userInput.split(" /from ");
                    String taskName = parts[0].substring(6);
                    String[] taskDetail = parts[1].split(" /to ");
                    String taskStart = taskDetail[0];
                    String taskEnd = taskDetail[1];
                    list.inputList(taskName, taskStart, taskEnd);
                } else {
                    System.out.println(line);
                }
            }
        }
    }
}
