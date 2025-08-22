package ember.task;

import ember.exception.MissingInformationException;

public class TodoTask extends Task {
    public TodoTask(String name) throws MissingInformationException {
        super(name);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String description() {
        return toString();
    }
}
