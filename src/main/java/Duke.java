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
        String[] list = new String[100];
        while (exit == 0){
            String input = sc.nextLine();
            printLine();
            if (input.equals("bye")){
                exit = 1;
                System.out.println("Goodbye! I look forward to seeing you the next time!");
                printLine();
            }
            else if (input.equals("list")){
                printList(list);
            }
            else {
                list[i] = input;
                System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + input);
                printLine();
                i++;
            }
        }
    }

    public static void printLine(){
        System.out.println("____________________________________________________________");
    }

    public static void printList(String[] list){
        System.out.println("Here is the collated list:");
        int i = 0;
        while(list[i] !=null ){
            System.out.println("(" + (i+1) + ") " + list[i]);
            i++;
        }
        System.out.println("Feel free to continue adding to the list!");
        printLine();
    }
}

