public class EventTask extends Task {
    private String from;
    private String to;
    public EventTask(String name, String from, String to) throws MissingInformationException {
        super(name);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }

    @Override
    public String description() {
        return toString() + " (from: " + this.from + ", to: " + this.to + ")";
    }
}
