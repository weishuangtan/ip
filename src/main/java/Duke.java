import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initialiseJulia();
        ArrayList <Task> tasks = new ArrayList<>();
        State state = State.running;
        while (state == State.running) {
            String input = in.nextLine();
            printLine();
            state = analyseInput(input,tasks);
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
        String[] words = input.split(" ");
        if (input.equals("bye")) {
            // Exits the programme
            printGoodbye();
            return State.stop;
        } else if (input.equals("list")) {
            // Lists the tasks
            printList(tasks);

        } else if (input.startsWith("done")) {
            // Checks task off the list
            try {
                checkTaskOff(words[1],tasks);
            } catch (Exception e) {
                printNotFound();
            }
        } else if (input.startsWith("todo ")){
            // Add tasks without any date/time attached
            addToDo(input,tasks);
        }else {
            // Adds tasks into the list
            addTask(input,tasks);
        }
        return State.running;

    }

    /**
     * Tries checking given task off the list
     *
     * @param word task number given by user
     * @param tasks list of tasks
     */
    public static void checkTaskOff(String word, ArrayList<Task> tasks){
        int complete = Integer.parseInt(word);
        if (complete <= tasks.size()) {
            tasks.get(complete - 1).markAsDone();
        } else {
            printNotFound();
        }
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
        String EMOJI = "      \\(｡◕‿◕｡)/";
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
    public static void printGoodbye(){
        System.out.println("Goodbye! I look forward to seeing you the next time!");
    }

    /**
     * Prints error message
     */
    public static void printNotFound(){
        System.out.println("No such task found, try again?");
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
            for (Task task: tasks) {
                System.out.println("(" + (i + 1) + ") " + task);
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }

    /** Adds given task into the list of tasks
     *
     * @param input task description
     * @param tasks list of tasks
     */
    public static void addTask(String input, ArrayList<Task> tasks){
        Task item = new Task(input);
        tasks.add(item);
        System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + input);
    }

    /**
     * Add To Do task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addToDo(String input, ArrayList<Task> tasks){
        String task = input.substring(5,input.length()-5);
        ToDo item = new ToDo(task);
        tasks.add(item);
        System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + item);
    }
}

