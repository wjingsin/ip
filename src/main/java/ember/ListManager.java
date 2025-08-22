package ember;

import ember.exception.InvalidInputException;
import ember.exception.MissingInformationException;
import ember.task.DeadlineTask;
import ember.task.EventTask;
import ember.task.Task;
import ember.task.TodoTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Manages a list of tasks, allowing addition, deletion,
 * marking, unmarking, and printing of tasks.
 * Also handles persisting tasks to a file via ListFileWriter.
 */
public class ListManager {
    private String line = "____________________________________________________________\n";
    private int currentListNumber;
    public ArrayList<Task> list;

    /**
     * Constructs a new ListManager, initializes the task list,
     * and prepares the file writer for saving the list.
     */
    public ListManager() {
        this.list = new ArrayList<>();
        new ListFileWriter();
    }

    /**
     * Updates the saved task list text file to reflect the current list.
     */
    public void updateText() {
        ListFileWriter.listToText(list);
    }

    /**
     * Adds a task to the list, updates the file,
     * and prints confirmation to the console.
     *
     * @param task the Task object to add
     */
    public void addTask(Task task) {
        list.add(task);
        updateText();
        System.out.println(line +
                "Got it. I've added this task:\n" +
                task.description() +
                "\n" +
                "Now you have " +
                list.size() +
                " tasks in the list.\n" +
                line
        );
    }

    /**
     * Deletes a task by its index in the list (1-based).
     * Prints confirmation or throws an exception if index invalid.
     *
     * @throws InvalidInputException if index is out of bounds
     */
    public void deleteTask(int i) throws InvalidInputException {
        if (i > list.size() || i < 1) {
            throw new InvalidInputException("You currently have " + list.size() + " tasks currently." +
                    "\n" +
                    "Please try again. \n");
        } else {
            System.out.println(line +
                    "Noted. I've removed this task:\n" +
                    list.get(i - 1).description() +
                    "\n" +
                    "Now you have " +
                    (list.size() - 1) +
                    " tasks in the list.");
            list.remove(i - 1);
        }
        updateText();

    }

    //Ember.TodoTask
    public void inputList(String s) throws MissingInformationException, InvalidInputException {
        Task task = new TodoTask(s);
        addTask(task);
        updateText();

    }

    //Ember.DeadlineTask
    public void inputList(String s, String by) throws MissingInformationException, InvalidInputException {
        Task task = new DeadlineTask(s, by);
        addTask(task);
        updateText();

    }

    //Ember.EventTask
    public void inputList(String s, String from, String to) throws MissingInformationException, InvalidInputException {
        Task task = new EventTask(s, from, to);
        addTask(task);
        updateText();

    }


    public void printList() {
        int i = 0;
        System.out.println(line +
                "Here are the tasks in your list:\n");
        while (i < list.size() && list.get(i) != null) {
            System.out.println(
                            (i + 1) +
                            ". " +
                            list.get(i).description());
            i++;
        }
        System.out.println("\n" + line);
    }

    public void printMatchingList() {
        int i = 0;
        System.out.println(line +
                "Here are the matching tasks in your list:\n");
        while (i < list.size() && list.get(i) != null) {
            System.out.println(
                    (i + 1) +
                            ". " +
                            list.get(i).description());
            i++;
        }
        System.out.println("\n" + line);
    }

    public void findKeyword(String keyword) {
        ArrayList<Task> tasks = (ArrayList<Task>) list.stream().filter(task -> task.getName()
                .contains(keyword)).collect(Collectors.toList());
        ListManager keywordList = new ListManager();
        keywordList.list = tasks;
        keywordList.printMatchingList();
    }


    public void mark(int taskNumber) {
        list.get(taskNumber - 1).mark();
        System.out.println(line +
                        "Nice! I've marked this task as done:\n" +
                        list.get(taskNumber - 1) +
                        "\n" +
                        line);
        updateText();

    }

    /**
     * Unmarks the task at the given 1-based index (marks as not done).
     * Updates the saved file and prints confirmation.
     *
     * @param taskNumber 1-based index of the task to unmark
     */
    public void unmark(int taskNumber) {
        list.get(taskNumber - 1).unmark();
        System.out.println(line +
                "OK, I've marked this task as not done yet:\n" +
                list.get(taskNumber - 1).toString() +
                "\n" +
                line);
        updateText();

    }
}
