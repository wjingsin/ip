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
        while(true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(line +
                        "Bye. Hope to see you again soon!\n" +
                        line
                );
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                list.printList();
            } else {
                list.inputList(userInput);
            }
        }
    }
}
