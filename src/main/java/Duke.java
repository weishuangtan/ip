import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
        int exit = 0;
        int i = 0;
        String[] inputs = new String[100];
        while (exit == 0){
            inputs[i] = sc.nextLine();
            printLine();
            if (inputs[i].equals("bye")){
                exit = 1;
            }
            else {
                System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + inputs[i]);
                printLine();
            }
            i++;
        }

        System.out.println("Goodbye! I look forward to seeing you the next time!");
        printLine();
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }
}

