public class DukeException extends Exception {

    public void getErrorMessage(String errorType){

        switch(errorType){
        case "todo":
            System.out.println("Incorrect format for todo, please try again!");
            System.out.println("Here is an example on how you can add a todo task into the list: ");
            System.out.println("\"todo Tutorials for this week\"");
            break;
        case "done":
            System.out.println("Incorrect format for done, please try again!");
            System.out.println("Here is an example on how you can use the done command: ");
            System.out.println("\"done 3\"");
            break;
        case "event":
            System.out.println("Incorrect format for event, please try again!");
            System.out.println("Here is an example on how you can add an event task into the list: ");
            System.out.println("\"event Tutorial class /at 10:00AM\"");
            break;
        case "deadline":
            System.out.println("Incorrect format for deadline, please try again!");
            System.out.println("Here is an example on how you can add a deadline task into the list: ");
            System.out.println("\"deadline Math homework /by end of this week\"");
            break;
        case "invalid":
            System.out.println("Oh no, so sorry but I cannot understand that :(");
            System.out.println("Try using \"todo\", \"event\" or \"deadline\" to add tasks!");
            System.out.println("You can also use \"done\" to mark your tasks as done, or");
            System.out.println("use \"list\" to list out all your existing tasks!");
            break;
        case "not found":
            System.out.println("No such task found, try again?");
            break;
        }
    }
}
