package ember.exception;

public class MissingInformationException extends Exception {
    public MissingInformationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "You have entered an invalid input.\n" +
                super.getMessage();
    }
}