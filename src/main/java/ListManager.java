public class ListManager {
    private Task[] list;
    private String line = "____________________________________________________________\n";
    private int currentListNumber;

    public ListManager() {
        this.list = new Task[100];
        this.currentListNumber = 0;
    }

    public void inputList(String s) {
        list[currentListNumber] = new Task(s);
        currentListNumber++;
        System.out.println(line +
                "added: " +
                s +
                "\n" +
                line
        );
    }
    public void printList() {
        int i = 0;
        System.out.println(line +
                "Here are the tasks in your list:\n");
        while (i < list.length && list[i] != null) {
            System.out.println(
                            (i + 1) +
                            ". " +
                            list[i]);
            i++;
        }
    }

    public void mark(int taskNumber) {
        list[taskNumber - 1].mark();
        System.out.println(line +
                        "Nice! I've marked this task as done: \n" +
                        list[taskNumber - 1].toString() +
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
