package ember;

import ember.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles writing the list of tasks to a text file.
 *
 * The file path is fixed to "temp/lines.txt".
 * This class ensures the directory exists and provides
 * methods to write to or overwrite the file.
 */
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

    /**
     * Appends the specified text to the file.
     *
     * @param textToAdd the text to append
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public static void writeToFile(String textToAdd) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(textToAdd);
        }
    }

    /**
     * Writes the entire list of tasks to the file, overwriting previous content.
     *
     * @param list the list of tasks to write to the file
     */
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
