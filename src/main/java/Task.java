public class Task {
    private String name;
    private boolean isMarked;

    public Task(String name) {
        this.name = name;
        this.isMarked = false;
    }

    public void mark() {
        this.isMarked = true;
    }
    public void unmark() {
        this.isMarked = false;
    }

    public String toString() {
        String sign = (isMarked) ? "X" : " ";
        return "[" + sign + "] " + this.name;
    }

    public String description() {
        return toString();
    }
}
