import java.util.Scanner;

public class Ui {
    private Scanner inputScanner;

    public Ui() {
        this.inputScanner = new Scanner(System.in);
    }

    /**
     * Displays an initial greeting message on the chatbot UI.
     */
    public void showGreeting() {
        String logo = """          
                   _____             __ _      _     _
                  / ____|           / _(_)    | |   | |
                 | |  __  __ _ _ __| |_ _  ___| | __| |
                 | | |_ |/ _` | '__|  _| |/ _ \\ |/ _` |
                 | |__| | (_| | |  | | | |  __/ | (_| |
                  \\_____|\\__,_|_|  |_| |_|\\___|_|\\__,_|
                """;

        String initialGreeting = "Hey. I'm\n\n" + logo
                + "\nLet's get this over with. What do you want?";
        this.showMessage(initialGreeting);
    }

    /**
     * Read the next line that the user inputs into the UI and return it.
     *
     * @return The whole line of String input that the user inputted.
     */
    public String readCommand() {
        return inputScanner.nextLine().strip();
    }

    /**
     * Displays a message on the chatbot UI which will be wrapped between 2 horizontal lines.
     *
     * @param message Message to be displayed.
     */
    public void showMessage(String message) {
        this.showLine(70);
        System.out.println(message);
        this.showLine(70);
    }

    /**
     * Displays a line made up of a specified length to the chatbot UI.
     *
     * @param length Length of the line, which is the number of underscore characters.
     */
    public void showLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("_");
        }
        System.out.print("\n");
    }
}
