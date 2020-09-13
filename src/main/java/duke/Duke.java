package duke;

import duke.handlers.FileHandler;
import duke.handlers.ListHandler;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        State state = State.running;
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        FileHandler.setup(tasks);
        Messages.initialiseJulia();
        while (state == State.running) {
            String input = in.nextLine();
            Messages.printLine();
            state = analyseInput(input, tasks);
            Messages.printLine();
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
            Messages.printGoodbye();
            return State.stop;
        } else if (input.equals("list")) {
            ListHandler.printList(tasks);
        } else if (input.startsWith("done")) {
            ListHandler.checkTaskOff(input, tasks);
        } else if (input.startsWith("todo")) {
            ListHandler.addToDo(input, tasks);
        } else if (input.startsWith("deadline")) {
            ListHandler.addDeadline(input, tasks);
        } else if (input.startsWith("event")) {
            ListHandler.addEvent(input, tasks);
        } else if (input.startsWith("delete")){
            ListHandler.deleteEvent(input,tasks);
        } else {
            Messages.printInvalidInput();
        }
        return State.running;
    }

}



