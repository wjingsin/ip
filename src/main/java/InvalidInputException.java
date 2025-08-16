public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "You have entered an invalid input.\n" +
                "To add a new task, start with: todo, deadline or event. \n" +
                "To exit, type 'bye'.\n";
    }
}