package duke.system;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sets up the entire txt file and saves list inside
 */
public class Storage {
    /**
     * Sets up the storage in txt file
     *
     * @param tasks list of tasks
     */
    public static void setup(ArrayList<Task> tasks) {
        File file = new File("duke.txt");
        Scanner readFile = Storage.startFile(file);
        assert readFile != null;
        Storage.loadList(readFile,tasks);
    }

    /**
     * Creates a file if there is no such file in directory, and load if there already exists
     *
     * @param file duke.txt file
     * @return returns a Scanner to read the file
     */
    public static Scanner startFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("I can't find a file in your directory :(");
                System.out.println("I created a file for you here!\n" + "File location: " + file.getAbsolutePath());
            } else if (!file.createNewFile()) {
                System.out.println("I found a file in your directory!\nSetting up file over here...");
            }
            return new Scanner(file);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the list of tasks from the duke.txt file and save it into the chat bot
     *
     * @param readFile Scanner to read the file
     * @param tasks list of tasks
     */
    public static void loadList(Scanner readFile, ArrayList<Task> tasks) {
        while(readFile.hasNext()) {
            String line = readFile.nextLine();
            if (line.contains("\u24c9")) { //To Do
                String taskLine = line.substring((line.indexOf("\u24c9") + 4));
                ToDo item = new ToDo(taskLine);
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            } else if (line.contains("\u24ba")) { //Event
                String taskLine = line.substring((line.indexOf("\u24ba") + 4));
                String[] descriptionAndAt = taskLine.split(" \\(at: ");
                descriptionAndAt[1] = descriptionAndAt[1].substring(0, descriptionAndAt[1].length()-1);
                LocalDate date = findDate(taskLine);
                Event item = new Event(descriptionAndAt[0], descriptionAndAt[1],findDate(taskLine));
                if (date != null) {
                    item.hasDate();
                }
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            } else if (line.contains("\u24b9")) { //Deadline
                String taskLine = line.substring((line.indexOf("\u24b9") + 4));
                String[] descriptionAndBy = taskLine.split(" \\(by: ");
                descriptionAndBy[1] = descriptionAndBy[1].substring(0, descriptionAndBy[1].length()-1);
                LocalDate date = findDate(taskLine);
                Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1], date);
                if (date != null) {
                    item.hasDate();
                }
                if (line.contains("\u2713")) {
                    item.isDone();
                }
                tasks.add(item);
            }
        }
    }

    /**
     * Saves the existing list of tasks into the duke.txt file
     *
     * @param tasks list of tasks
     * @throws IOException when there is no input
     */
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

    public static LocalDate findDate(String input) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            try {
                return LocalDate.parse(String.format("%s %s %s", words[i], words[i + 1], words[i + 2]),
                        DateTimeFormatter.ofPattern("MMM dd yyyy)"));
            } catch (DateTimeParseException | ArrayIndexOutOfBoundsException ignored) {
            }
        }
        return null;
    }
}
