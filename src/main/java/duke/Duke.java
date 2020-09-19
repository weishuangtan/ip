package duke;

import duke.commands.Command;
import duke.parser.FileHandler;
import duke.parser.Parser;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        State state = new State();
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        FileHandler.setup(tasks);
        Messages.initialiseJulia();
        while (state.getState()) {
            String input = in.nextLine();
            Messages.printLine();
            Command command = Parser.analyseCommand(input,tasks,state);
            command.execute();
            Messages.printLine();
        }
    }

}



