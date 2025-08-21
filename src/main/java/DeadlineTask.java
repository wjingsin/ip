import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DeadlineTask extends Task {
    private LocalDate by;
    private String byFormatted;
    public DeadlineTask(String name, String byUnformatted) throws MissingInformationException, InvalidInputException{
        super(name);
        try {
            this.by = LocalDate.parse(byUnformatted);
            this.byFormatted = by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Input dates in format yyyy-mm-dd");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString();
    }

    @Override
    public String description() {
        return toString() + " (by: " + byFormatted + ")";
    }
}
