import java.util.LinkedList;
import java.util.Scanner;

public class Ember {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] list = new String[100];
        int currentListNumber = 0;
        String line = "____________________________________________________________\n";
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
                int i = 0;
                System.out.println(line);
                while (i < list.length && list[i] != null) {
                    System.out.println(
                            (i + 1) +
                            ". " +
                            list[i]);
                    i++;
                }
                System.out.println(line);
            } else {
                list[currentListNumber] = userInput;
                currentListNumber++;
                System.out.println(line +
                        "added: " +
                        userInput +
                        "\n" +
                        line
                );
            }
        }
    }
}
