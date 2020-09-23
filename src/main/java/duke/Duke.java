package duke;

import duke.commands.Command;
import duke.system.Storage;
import duke.parser.Parser;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starts the entry point of Julia the chat bot
 */
public class Duke {

    /**
     * Runs the program until termination
     * @param args starts the program
     */
    public static void main(String[] args) {
        State state = new State();
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        Storage.setup(tasks);
        Ui.initialiseJulia();
        while (state.getState()) {
            String input = in.nextLine();
            Ui.printLine();
            Command command = Parser.analyseCommand(input,tasks,state);
            command.execute();
            Ui.printLine();
        }
    }

}



