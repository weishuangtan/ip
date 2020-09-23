package duke.parser;

import duke.commands.*;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

public class Parser {
    /**
     * Analyses the input given by user and determines the following action
     *
     * @param input user's input
     * @param tasks list of tasks
     * @return state of chat bot
     */
    public static Command analyseCommand(String input, ArrayList<Task> tasks, State state) {
        if (input.equals("bye")) {
            return new ExitCommand(input, tasks, state);
        } else if (input.equals("list")) {
            return new ListCommand(input, tasks, state);
        } else if (input.startsWith("done")) {
            return new DoneCommand(input, tasks, state);
        } else if (input.startsWith("todo")) {
            return new ToDoCommand(input, tasks, state);
        } else if (input.startsWith("deadline")) {
            return new DeadlineCommand(input, tasks, state);
        } else if (input.startsWith("event")) {
            return new EventCommand(input, tasks, state);
        } else if (input.startsWith("delete")){
            return new DeleteCommand(input, tasks, state);
        } else if (input.startsWith("find")) {
            return new FindCommand(input, tasks, state);
        } else {
            return new IncorrectCommand(input, tasks, state);
        }
    }
}
