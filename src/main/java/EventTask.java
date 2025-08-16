public class EventTask extends Task {
    private String from;
    private String to;
    public EventTask(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }
}
