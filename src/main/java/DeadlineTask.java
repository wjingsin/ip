public class DeadlineTask extends Task {
    private String by;
    public DeadlineTask(String name, String by) throws MissingInformationException{
        super(name);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString();
    }

    @Override
    public String description() {
        return toString() + " (by: " + this.by + ")";
    }
}
