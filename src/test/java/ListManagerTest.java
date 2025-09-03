package ember;

import ember.exception.InvalidInputException;
import ember.exception.MissingInformationException;
import ember.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    private ListManager manager;

    @BeforeEach
    void setUp() {
        manager = new ListManager();
    }

    @Test
    void testInputList_AddTodoTask() throws MissingInformationException, InvalidInputException {
        manager.inputList("Read book");
        String expectedDescription = "[T][ ] Read book";
        String actual = managerDescriptionList().get(0);
        assertEquals(expectedDescription, actual);
    }

    @Test
    void testInputList_AddDeadlineTask() throws MissingInformationException, InvalidInputException {
        manager.inputList("Read book", "2025-01-01");
        String expectedDescription = "[D][ ] Read book (by: 1 Jan, 2025)";
        String actual = managerDescriptionList().get(0);
        assertEquals(expectedDescription, actual);
    }

    @Test
    void testInputList_AddEventTask() throws MissingInformationException, InvalidInputException {
        manager.inputList("Read book", "2025-01-01", "2026-01-02");
        String expectedDescription = "[E][ ] Read book (from: 1 Jan, 2025, to: 2 Jan, 2026)";
        String actual = managerDescriptionList().get(0);
        assertEquals(expectedDescription, actual);
    }


    @Test
    void testDeleteTask_RemovesCorrectTask() throws MissingInformationException, InvalidInputException {
        manager.inputList("Task A");
        manager.inputList("Task B");
        manager.deleteTask(1);
        List<String> descriptions = managerDescriptionList();
        assertEquals(1, descriptions.size());
        assertEquals("[T][ ] Task B", descriptions.get(0));
    }

    @Test
    void testDeleteTask_InvalidIndex_ThrowsException() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            manager.deleteTask(5);
        });
        assertTrue(exception.getMessage().contains("Please try again"));
    }

    private List<String> managerDescriptionList() {
        return manager
                .list
                .stream()
                .map(Task::description)
                .collect(Collectors.toList());
    }
}
