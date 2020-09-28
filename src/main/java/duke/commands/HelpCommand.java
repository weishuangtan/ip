package duke.commands;

import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

/**
 * Prints the list of commands that user can input
 */
public class HelpCommand extends Command {
    /**
     * Constructor for Command class
     *
     * @param input user's input
     * @param tasks list of tasks
     * @param state running state of chat bot
     */
    public HelpCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute() {
        System.out.println("Here is the list of commands that you can use: ");
        System.out.println("[bye]         to exit the chat bot");
        System.out.println("[dates]       to view tasks with dates attached to it");
        System.out.println("[deadline]    to add a deadline type task");
        System.out.println("[delete]      to delete a task from the list");
        System.out.println("[done]        to mark off a task as done from the list");
        System.out.println("[event]       to add an event type task");
        System.out.println("[find]        to find tasks with matching keyword in the list");
        System.out.println("[help]        to list commands available for use");
        System.out.println("[list]        to view the list of tasks");
        System.out.println("[todo]        to add a todo type task");
    }
}
