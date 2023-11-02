package registry.presenter;

public interface ConsoleReader {

    /**
     * Reads from console
     * @param message info message
     * @return String
     */
    String getStringFromConsole(String message);

    /**
     * Reads from console
     * @param message info message
     * @return int
     */
    int getNumberFromConsole(String message);
}
