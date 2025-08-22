package ember.task;

import ember.exception.InvalidInputException;
import ember.exception.MissingInformationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventTask extends Task {
    private LocalDate from;
    private LocalDate to;
    private String fromFormatted;
    private String toFormatted;
    public EventTask(String name, String fromUnformatted, String toUnformatted)
            throws MissingInformationException, InvalidInputException {
        super(name);
        try {
            this.from = LocalDate.parse(fromUnformatted);
            this.to = LocalDate.parse(toUnformatted);
            this.fromFormatted = from.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            this.toFormatted = to.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Input dates in format yyyy-mm-dd");

        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }

    @Override
    public String description() {
        return toString() + " (from: " + fromFormatted +
                ", to: " + toFormatted + ")";
    }
}
