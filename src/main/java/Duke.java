import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        printLine();
        int exit = 0;
        while (exit == 0){
            String input = sc.nextLine();
            printLine();
            if (input.equals("bye")){
                exit = 1;
            }
            else {
                System.out.println(input);
                printLine();
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }
}

