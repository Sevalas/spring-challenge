package app.dao;

import app.constants.Constants;
import app.db.SavedTask;
import app.dto.ResponseModel;
import app.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static app.fixture.TaskFixture.taskDummyMap;
import static app.fixture.TaskFixture.taskDummyMapIncomplete;
import static app.fixture.TaskFixture.taskDummyMapIncorrect;

public class TaskDAOTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private TaskDAO TaskDAO;

    @InjectMocks
    private SavedTask savedTask;

    List<TaskDTO> listOfTask;

    @Before
    public void setup(){
        listOfTask = savedTask.selectSavedTaskList();
    }

    @Test
    public void addTaskOK() {
        ResponseModel responseModel = TaskDAO.addTask(taskDummyMap);
        Assert.assertEquals(responseModel.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void addTaskNOOK() {
        ResponseModel responseModel = TaskDAO.addTask(taskDummyMapIncomplete);
        Assert.assertEquals(responseModel.getCode(), Constants.INCOMPLETE_FIELDS_CODE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addTaskNOOK2() {
        TaskDAO.addTask(taskDummyMapIncorrect);
    }

    @Test
    public void getListOfTaskOK() {
        ResponseModel responseModel = TaskDAO.getListOfTask();
        Assert.assertEquals(responseModel.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void getTaskByIDOK() {
        ResponseModel ControllerResponse = TaskDAO.getTaskByID(listOfTask.get(0).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void getTaskByIDNOOK() {
        ResponseModel ControllerResponse = TaskDAO.getTaskByID(null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);
    }

    @Test
    public void updateTaskOK() {
        ResponseModel ControllerResponse = TaskDAO.updateTask(listOfTask.get(0).getId(),taskDummyMap);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void updateTaskNOOK() {
        ResponseModel ControllerResponse = TaskDAO.updateTask(null,taskDummyMapIncomplete);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.INCOMPLETE_FIELDS_CODE);
    }
    @Test
    public void updateTaskNOOK2() {
        ResponseModel ControllerResponse = TaskDAO.updateTask(null,taskDummyMap);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);
    }
    @Test (expected = IllegalArgumentException.class)
    public void updateTaskNOOK3() {
        TaskDAO.updateTask(null,taskDummyMapIncorrect);
    }

    @Test
    public void deleteTaskOK() {
        ResponseModel ControllerResponse = TaskDAO.deleteTask(listOfTask.get(0).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);

    }

    @Test
    public void deleteTaskNOOK() {
        ResponseModel ControllerResponse = TaskDAO.deleteTask(null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);
    }
}
