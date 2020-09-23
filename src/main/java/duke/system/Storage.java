package duke.system;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static void setup(ArrayList<Task> tasks) {
        File file = new File("duke.txt");
        Scanner readFile = Storage.startFile(file);
        assert readFile != null;
        Storage.loadList(readFile,tasks);
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
}
