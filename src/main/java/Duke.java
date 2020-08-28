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


    //Prints starting page of Julia the chat bot
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

    // Analyses the input given by user and determines the following action
    public static State analyseInput(String input, ArrayList<Task> tasks) {
        String[] words = input.split(" ");
        if (input.equals("bye")) {
            // Exits the programme
            System.out.println("Goodbye! I look forward to seeing you the next time!");
            return State.stop;
        } else if (input.equals("list")) {
            // Lists the tasks
            printList(tasks);
            return State.running;
        } else if (input.startsWith("done")) {
            // Checks task off the list
            try {
                int complete = Integer.parseInt(words[1]);
                if (complete <= tasks.size()) {
                    tasks.get(complete - 1).markAsDone();
                } else {
                    System.out.println("No such task found, try again?");
                }
                return State.running;
            } catch (Exception e) {
                System.out.println("No such task found, try again?");
                return State.running;
            }
        } else {
            // Adds tasks into the list
            Task item = new Task(input);
            tasks.add(item);
            System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + input);
            return State.running;
        }

    }

    // Prints a separator between chat bot and user
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    // Prints the current collated list based on user inputs
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("Looks like you have no task yet!");
        } else {
            System.out.println("Here is the collated list of your tasks:");
            int i = 0;
            for (Task task: tasks) {
                System.out.println("(" + (i + 1) + ") " + task.getStatusIcon() + " " + task.description);
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }
}

