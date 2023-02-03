package exception;

public class IncorrectArgumentException extends Exception {

    private final String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    public String getMessage() {
        return "Параметр " + argument + " задан некорректно" ;
    }
}
