package ember;

import ember.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListFileWriter {
    private static final File file = new File("temp/lines.txt");
    public ListFileWriter() {
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (FileWriter fw = new FileWriter(file, false)) {
        } catch (IOException e) {
            System.out.println("Error clearing the file: " + e.getMessage());
        }
    }
    public static void writeToFile(String textToAdd) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(textToAdd);
        }
    }

    public static void listToText(ArrayList<Task> list) {
        try (FileWriter fw = new FileWriter(file, false)) {
            for (Task task: list) {
                fw.write(task.description() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
