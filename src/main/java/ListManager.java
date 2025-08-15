public class ListManager {
    public String[] list;
    String line = "____________________________________________________________\n";
    int currentListNumber;

    public ListManager() {
        list = new String[100];
        currentListNumber = 0;
    }

    public void inputList(String s) {
        list[currentListNumber] = s;
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
        System.out.println(line);
        while (i < list.length && list[i] != null) {
            System.out.println(
                    (i + 1) +
                            ". " +
                            list[i]);
            i++;
        }
    }
}
