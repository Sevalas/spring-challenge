package app.db;

import app.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static app.fixture.TaskFixture.taskDummy;

public class SavedTaskTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SavedTask savedTask;

    List<TaskDTO> listOfTask;

    @Before
    public void setup(){
        listOfTask = savedTask.selectSavedTaskList();
    }

    @Test
    public void insertSavedTaskOK() {
        TaskDTO insertedTask = savedTask.insertSavedTask(taskDummy);
        Assert.assertNotNull(insertedTask);
    }

    @Test
    public void insertSavedTaskNOOK() {
        TaskDTO insertedTask = savedTask.insertSavedTask(listOfTask.get(0));
        Assert.assertNull(insertedTask);
    }

    @Test
    public void selectSavedTaskListOK() {
        Assert.assertNotNull(listOfTask);
    }

    @Test
    public void selectSavedTaskByIDtOK() {
        TaskDTO selectedTask = savedTask.selectSavedTaskById(listOfTask.get(0).getId());
        Assert.assertNotNull(selectedTask);
    }

    @Test
    public void selectSavedTaskByIDtNOOK() {
        TaskDTO selectedTask = savedTask.selectSavedTaskById(null);
        Assert.assertNull(selectedTask);
    }

    @Test
    public void updateSavedTaskOK() {
        TaskDTO updatedTask = savedTask.updateSavedTask(listOfTask.get(0).getId(),listOfTask.get(0));
        Assert.assertNotNull(updatedTask);
    }

    @Test
    public void updateSavedTaskNOOK() {
        TaskDTO updatedTask = savedTask.updateSavedTask(taskDummy.getId(),taskDummy);
        Assert.assertNull(updatedTask);
    }

    @Test
    public void deleteSavedTaskOK() {
        boolean isTaskDeleted = savedTask.deleteSavedTask(listOfTask.get(0).getId());
        Assert.assertTrue(isTaskDeleted);
    }

    @Test
    public void deleteSavedTaskNOOK() {
        boolean isTaskDeleted = savedTask.deleteSavedTask("InexistID");
        Assert.assertFalse(isTaskDeleted);
    }
}
