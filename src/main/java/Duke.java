import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initialiseJulia();
        ArrayList<Task> tasks = new ArrayList<>();
        State state = State.running;
        while (state == State.running) {
            String input = in.nextLine();
            printLine();
            state = analyseInput(input, tasks);
            printLine();
        }
    }

    /**
     * Analyses the input given by user and determines the following action
     *
     * @param input user's input
     * @param tasks list of tasks
     * @return state of chat bot
     */
    public static State analyseInput(String input, ArrayList<Task> tasks) {
        if (input.equals("bye")) {
            printGoodbye();
            return State.stop;
        } else if (input.equals("list")) {
            printList(tasks);
        } else if (input.startsWith("done")) {
            checkTaskOff(input, tasks);
        } else if (input.startsWith("todo")) {
            addToDo(input, tasks);
        } else if (input.startsWith("deadline")) {
            addDeadline(input, tasks);
        } else if (input.startsWith("event")) {
            addEvent(input, tasks);
        } else {
            new DukeException().getErrorMessage("invalid");
        }
        return State.running;
    }


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
        printLine();
        System.out.println("Hello! I'm Julia\nIs there anything I can do for you today?");
        printLine();
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
        if (numberOfTasks==1) {
            System.out.print(" task");
        } else {
            System.out.print(" tasks");
        }
        System.out.println(" in the list.");
    }

    /**
     * Prints the current collated list based on user inputs
     *
     * @param tasks list of tasks
     */
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("Looks like you have no task yet!");
        } else {
            System.out.println("Here is the collated list of your tasks:");
            int i = 0;
            for (Task task : tasks) {
                System.out.println("(" + (i + 1) + ") " + task);
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }

    /**
     * Tries checking given task off the list
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void checkTaskOff(String input, ArrayList<Task> tasks) {
        String[] words = input.split(" ");
        try {
            int complete = Integer.parseInt(words[1]);
            if (complete <= tasks.size()) {
                tasks.get(complete - 1).markAsDone();
            } else {
                new DukeException().getErrorMessage("not found");
            }
        } catch (Exception e) {
            new DukeException().getErrorMessage("done");
        }
    }

    /**
     * Adds To Do task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addToDo(String input, ArrayList<Task> tasks) {
        String[] words = input.split(" ");
        if (words.length > 1) {
            String task = input.substring(5);
            ToDo item = new ToDo(task);
            tasks.add(item);
            printAdded(item, tasks.size());
        } else {
            new DukeException().getErrorMessage("todo");
        }
    }

    /**
     * Adds Deadline task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addDeadline(String input, ArrayList<Task> tasks) {
        try {
            String task = input.substring(9);
            String[] descriptionAndBy = task.split(" /by ");

            Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1]);
            tasks.add(item);
            printAdded(item,tasks.size());
        } catch (Exception e) {
            new DukeException().getErrorMessage("deadline");
        }

    }

    /**
     * Adds Event task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addEvent(String input, ArrayList<Task> tasks) {
        try {
            String task = input.substring(6);
            String[] descriptionAndBy = task.split(" /at ");
            Event item = new Event(descriptionAndBy[0], descriptionAndBy[1]);
            tasks.add(item);
            printAdded(item,tasks.size());
        } catch (Exception e) {
            new DukeException().getErrorMessage("event");
        }
    }

}



