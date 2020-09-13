package duke;

import duke.system.DukeException;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        State state = State.running;
        File file = new File("duke.txt");
        Scanner readFile = startFile(file);
        Scanner in = new Scanner(System.in);
        Messages.initialiseJulia();
        ArrayList<Task> tasks = new ArrayList<>();
        loadList(readFile,tasks);
        while (state == State.running) {
            String input = in.nextLine();
            Messages.printLine();
            state = analyseInput(input, tasks);
            Messages.printLine();
        }
    }

    public static void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fileWriter = new FileWriter("duke.txt");
        fileWriter.write("Here is the collated list of your tasks:" + System.lineSeparator());
        int i = 0;
        for (Task task : tasks) {
            fileWriter.append("(").append(String.valueOf(i + 1)).append(") ").append(String.valueOf(task)).
                    append(System.lineSeparator());
            i++;
        }
        fileWriter.close();
    }

    public static void loadList(Scanner readFile, ArrayList<Task> tasks){
        while(readFile.hasNext()){
            String line = readFile.nextLine();
            if (line.contains("\uD835\uDD4B")) { //To Do
                String taskLine = line.substring((line.indexOf("\uD835\uDD4B") + 5));
                ToDo item = new ToDo(taskLine);
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            } else if (line.contains("\uD835\uDD3C")) { //Event
                String taskLine = line.substring((line.indexOf("\uD835\uDD3C") + 5));
                String[] descriptionAndAt = taskLine.split(" \\(at: ");
                descriptionAndAt[1] = descriptionAndAt[1].substring(0, descriptionAndAt[1].length()-1);
                Event item = new Event(descriptionAndAt[0], descriptionAndAt[1]);
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            } else if (line.contains("\uD835\uDD3B")) { //Deadline
                String taskLine = line.substring((line.indexOf("\uD835\uDD3B") + 5));
                String[] descriptionAndBy = taskLine.split(" \\(by: ");
                descriptionAndBy[1] = descriptionAndBy[1].substring(0, descriptionAndBy[1].length()-1);
                Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1]);
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            }
        }
    }


    public static Scanner startFile(File file) {
        try {
            if (file.createNewFile()){
                System.out.println("I can't find a file in your directory :(");
                System.out.println("I created a file for you here!\n" + "File location: " + file.getAbsolutePath());
            } else if (!file.createNewFile()) {
                System.out.println("I found a file in your directory!\nSetting up file over here...");
            }
            return new Scanner(file);
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
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
            printList(tasks);
        } else if (input.startsWith("done")) {
            checkTaskOff(input, tasks);
        } else if (input.startsWith("todo")) {
            addToDo(input, tasks);
        } else if (input.startsWith("deadline")) {
            addDeadline(input, tasks);
        } else if (input.startsWith("event")) {
            addEvent(input, tasks);
        } else {
            Messages.printInvalidInput();
        }
        return State.running;
    }



    /**
     * Prints message when task has been added
     *
     * @param item task description
     * @param numberOfTasks number of tasks in the current list
     */
    public static void printAdded(Task item, int numberOfTasks) {
        System.out.println("Okay, I have added the following into the list for you!\n" + "-> " + item);
        System.out.print("Now you have " + numberOfTasks);
        if (numberOfTasks==1) {
            System.out.print(" task");
        } else {
            System.out.print(" tasks");
        }
        System.out.println(" in the list.");
    }

    /**
     * Prints the current collated list based on user inputs
     *
     * @param tasks list of tasks
     */
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("Looks like you have no task yet!");
        } else {
            System.out.println("Here is the collated list of your tasks:");
            int i = 0;
            for (Task task : tasks) {
                System.out.println("(" + (i + 1) + ") " + task);
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }

    /**
     * Tries checking given task off the list
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void checkTaskOff (String input, ArrayList<Task> tasks) {
        String[] words = input.split(" ");

        try {
            int complete = Integer.parseInt(words[1]);
            if (complete <= tasks.size()) {
                tasks.get(complete - 1).markAsDone();
                writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Messages.printNotFound();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Messages.printDoneIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Adds To Do task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addToDo(String input, ArrayList<Task> tasks) {
        try {
            String[] words = input.split(" ");
            if (words.length > 1) {
                String task = input.substring(5);
                ToDo item = new ToDo(task);
                tasks.add(item);
                printAdded(item, tasks.size());
                writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Messages.printToDoIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Adds Tasks.Deadline task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addDeadline(String input, ArrayList<Task> tasks) {
        try {
            String task = input.substring(9);
            String[] descriptionAndBy = task.split(" /by ");

            Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1]);
            tasks.add(item);
            printAdded(item,tasks.size());
            writeToFile(tasks);
        }  catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e ) {
            Messages.printDeadlineIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Adds Tasks.Event task into the list of tasks
     *
     * @param input user's input
     * @param tasks list of tasks
     */
    public static void addEvent(String input, ArrayList<Task> tasks) {
        try {
            String task = input.substring(6);
            String[] descriptionAndAt = task.split(" /at ");
            Event item = new Event(descriptionAndAt[0], descriptionAndAt[1]);
            tasks.add(item);
            printAdded(item,tasks.size());
            writeToFile(tasks);
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            Messages.printEventIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}



