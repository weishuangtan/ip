public class Messages {

    /**
     * Prints starting page of Julia the chat bot
     */
    public static void initialiseJulia() {
        String LOGO = " _____ _   _ _     _ _____\n"
                + "|_   _| | | | |   | | . . |\n"
                + "  | | | | | | |   | | \\_/ |\n"
                + "|\\| | | |_| | |___| | | | |\n"
                + "\\___/ \\_____/\\____|_|_| |_|\n";
        String TEXT_BOX = "                 _____________\n"
                + "                |             |\n"
                + "                | Hello there!|\n"
                + "               <|_____________|\n";
        String EMOJI = "      \\(\uFF61\u25D5\u203F\u25D5\uFF61)/";
        System.out.println(LOGO + TEXT_BOX + EMOJI);
        Messages.printLine();
        System.out.println("Hello! I'm Julia\nIs there anything I can do for you today?");
        Messages.printLine();
    }

    public static void printToDoIncorrectFormat() {
        System.out.println("Incorrect format for todo, please try again!");
        System.out.println("Here is an example on how you can add a todo task into the list: ");
        System.out.println("\"todo Tutorials for this week\"");
    }

    public static void printDoneIncorrectFormat() {
        System.out.println("Incorrect format for done, please try again!");
        System.out.println("Here is an example on how you can use the done command: ");
        System.out.println("\"done 3\"");
    }

    public static void printEventIncorrectFormat() {
        System.out.println("Incorrect format for event, please try again!");
        System.out.println("Here is an example on how you can add an event task into the list: ");
        System.out.println("\"event Tutorial class /at 10:00AM\"");
    }

    public static void printDeadlineIncorrectFormat() {
        System.out.println("Incorrect format for deadline, please try again!");
        System.out.println("Here is an example on how you can add a deadline task into the list: ");
        System.out.println("\"deadline Math homework /by end of this week\"");
    }

    public static void printInvalidInput() {
        System.out.println("Oh no, so sorry but I cannot understand that :(");
        System.out.println("Try using \"todo\", \"event\" or \"deadline\" to add tasks!");
        System.out.println("You can also use \"done\" to mark your tasks as done, or");
        System.out.println("use \"list\" to list out all your existing tasks!");
    }

    public static void printNotFound() {
        System.out.println("No such task found, try again?");
    }

    /**
     * Prints a separator between chat bot and user
     */
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints goodbye message
     */
    public static void printGoodbye() {
        System.out.println("Goodbye! I look forward to seeing you the next time!");
    }

}