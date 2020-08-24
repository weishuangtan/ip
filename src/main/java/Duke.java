import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    //Main function
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        initialiseJulia();
        ArrayList <Task> list = new ArrayList<>();

        int end = 0;

        //loops until end variable becomes 1 meaning the user wrote "bye"
        while (end == 0){
            String input = in.nextLine();
            printLine();
            end = inputAnalyser(input,list);
            printLine();
        }
    }

    //Prints starting page of Julia the chat bot
    public static void initialiseJulia(){
        String logo = " _____ _   _ _     _ _____\n"
                + "|_   _| | | | |   | | . . |\n"
                + "  | | | | | | |   | | \\_/ |\n"
                + "|\\| | | |_| | |___| | | | |\n"
                + "\\___/ \\_____/\\____|_|_| |_|\n";
        String textBox = "                 _____________\n"
                + "                |             |\n"
                + "                | Hello there!|\n"
                + "               <|_____________|\n";
        String emoji = "      \\(｡◕‿◕｡)/";
        System.out.println(logo + textBox + emoji);
        printLine();
        System.out.println("Hello! I'm Julia\nIs there anything I can do for you today?");
        printLine();
    }

    //Analyses the input given by user and determines the following action
    public static int inputAnalyser(String input, ArrayList<Task> list){
        String[] words = input.split(" ");

        //exits the programme
        if (input.equals("bye")){
            System.out.println("Goodbye! I look forward to seeing you the next time!");
            return 1;
        }

        //lists the tasks
        else if (input.equals("list")){
            printList(list);
            return 0;
        }

        //checks tasks off the list
        else if (words[0].equals("done") && words[1].matches(".*\\d*")){
            int complete = Integer.parseInt(words[1]);
            if (complete <= list.size())
                list.get(complete-1).markAsDone();
            else
                System.out.println("No such task found, try again?");
            return 0;
        }

        //adds tasks into the list
        else {
            Task item = new Task(input);
            list.add(item);
            System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + input);
            return 0;
        }

    }

    //Prints a separator between chat bot and user
    public static void printLine(){
        System.out.println("____________________________________________________________");
    }

    //Prints the current collated list based on user inputs
    public static void printList(ArrayList<Task> list){
        System.out.println("Here is the collated list of your tasks:");
        int i = 0;
        for (Task item: list) {
            System.out.println("(" + (i + 1) + ") " + item.getStatusIcon() + " " + item.description);
            i++;
        }
        System.out.println("Feel free to continue adding to the list!");
    }
}

