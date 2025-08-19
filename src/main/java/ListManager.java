import java.util.ArrayList;

public class ListManager {
    private String line = "____________________________________________________________\n";
    private int currentListNumber;
    private ArrayList<Task> list;

    public ListManager() {
        this.list = new ArrayList<>();
    }

    public void addTask(Task task) {
        list.add(task);
        System.out.println(line +
                "Got it. I've added this task:\n" +
                list.get(list.size() - 1).description() +
                "\n" +
                "Now you have " +
                list.size() +
                " tasks in the list.\n" +
                line
        );
    }

    //TodoTask
    public void inputList(String s) throws MissingInformationException {
        Task task = new TodoTask(s);
        addTask(task);
    }

    //DeadlineTask
    public void inputList(String s, String by) throws MissingInformationException{
        Task task = new DeadlineTask(s, by);
        addTask(task);
    }

    //EventTask
    public void inputList(String s, String from, String to) throws MissingInformationException{
        Task task = new EventTask(s, from, to);
        addTask(task);
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

    public void mark(int taskNumber) {
        list.get(taskNumber - 1).mark();
        System.out.println(line +
                        "Nice! I've marked this task as done: \n" +
                        list.get(taskNumber - 1) +
                        "\n" +
                        line);
    }

    public void unmark(int taskNumber) {
        list.get(taskNumber - 1).unmark();
        System.out.println(line +
                "OK, I've marked this task as not done yet: \n" +
                list.get(taskNumber - 1).toString() +
                "\n" +
                line);
    }
}
