package duke.system;

import duke.tasks.Task;

/**
 * Text UI of the application
 */
public class Ui {

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
        Ui.printLine();
        System.out.println("Hello! I'm Julia\nIs there anything I can do for you today?");
        Ui.printLine();
    }

    /**
     * Prints the message when To Do command is in incorrect format
     */
    public static void printToDoIncorrectFormat() {
        System.out.println("Incorrect format for todo, please try again!");
        System.out.println("Here is an example on how you can add a todo task into the list: ");
        System.out.println("\"todo Tutorials for this week\"");
    }

    /**
     * Prints the message when done command is in incorrect format
     */
    public static void printDoneIncorrectFormat() {
        System.out.println("Incorrect format for done, please try again!");
        System.out.println("Here is an example on how you can use the done command: ");
        System.out.println("\"done 3\"");
    }

    /**
     * Prints the message when event command is in incorrect format
     */
    public static void printEventIncorrectFormat() {
        System.out.println("Incorrect format for event, please try again!");
        System.out.println("Here is an example on how you can add an event task into the list: ");
        System.out.println("\"event Tutorial class /at 10:00AM\"");
    }

    /**
     * Prints the message when deadline command is in incorrect format
     */
    public static void printDeadlineIncorrectFormat() {
        System.out.println("Incorrect format for deadline, please try again!");
        System.out.println("Here is an example on how you can add a deadline task into the list: ");
        System.out.println("\"deadline Math homework /by end of this week\"");
    }

    /**
     * Prints the message when delete command is in incorrect format
     */
    public static void printDeleteIncorrectFormat() {
        System.out.println("Incorrect format for delete, please try again!");
        System.out.println("Here is an example on how you can use the delete command: ");
        System.out.println("\"delete 3\"");
    }

    /**
     * Prints the message when the input is invalid
     */
    public static void printFindIncorrectFormat() {
        System.out.println("Incorrect format for find, please try again!");
        System.out.println("Here is an example on how you can use the find command: ");
        System.out.println("\"find homework\"");
    }


    public static void printInvalidInput() {
        System.out.println("Oh no, so sorry but I cannot understand that :(");
        System.out.println("Type \"help\" to view the list of commands!");
    }

    /**
     * Prints the message when unable to find a task to check as done
     */
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

    /**
     * Prints message when task has been added
     *
     * @param item task description
     * @param numberOfTasks number of tasks in the current list
     */
    public static void printAdded(Task item, int numberOfTasks) {
        System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + item);
        System.out.print("Now you have " + numberOfTasks);
        if (numberOfTasks == 1) {
            System.out.print(" task");
        } else {
            System.out.print(" tasks");
        }
        System.out.println(" in the list.");
    }
}