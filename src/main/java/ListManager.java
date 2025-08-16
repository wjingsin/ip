public class ListManager {
    private Task[] list;
    private String line = "____________________________________________________________\n";
    private int currentListNumber;

    public ListManager() {
        this.list = new Task[100];
        this.currentListNumber = 0;
    }

    public void addTask(Task task) {
        list[currentListNumber] = task;
        currentListNumber++;
        System.out.println(line +
                "Got it. I've added this task:\n" +
                list[currentListNumber - 1].description() +
                "\n" +
                "Now you have " +
                currentListNumber +
                " tasks in the list.\n" +
                line
        );
    }

    //TodoTask
    public void inputList(String s) {
        Task task = new TodoTask(s);
        addTask(task);
    }

    //DeadlineTask
    public void inputList(String s, String by) {
        Task task = new DeadlineTask(s, by);
        addTask(task);
    }

    //EventTask
    public void inputList(String s, String from, String to) {
        Task task = new EventTask(s, from, to);
        addTask(task);
    }


    public void printList() {
        int i = 0;
        System.out.println(line +
                "Here are the tasks in your list:\n");
        while (i < list.length && list[i] != null) {
            System.out.println(
                            (i + 1) +
                            ". " +
                            list[i].description());
            i++;
        }
        System.out.println("\n" + line);
    }

    public void mark(int taskNumber) {
        list[taskNumber - 1].mark();
        System.out.println(line +
                        "Nice! I've marked this task as done: \n" +
                        list[taskNumber - 1] +
                        "\n" +
                        line);
    }

    public void unmark(int taskNumber) {
        list[taskNumber - 1].unmark();
        System.out.println(line +
                "OK, I've marked this task as not done yet: \n" +
                list[taskNumber - 1].toString() +
                "\n" +
                line);
    }
}
