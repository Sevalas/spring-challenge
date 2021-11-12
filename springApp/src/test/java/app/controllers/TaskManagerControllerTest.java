package app.controllers;

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

public class TaskManagerControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private TaskManagerController taskManagerController;

    @InjectMocks
    private SavedTask savedTask;

    List<TaskDTO> listOfTask;

    @Before
    public void setup(){
        listOfTask = savedTask.selectSavedTaskList();
    }

    @Test
    public void addTaskOK() {
        ResponseModel ControllerResponse = taskManagerController.addTask(taskDummyMap);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void addTaskNOOK() {
        ResponseModel ControllerResponse = taskManagerController.addTask(taskDummyMapIncorrect);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.UNEXPECTED_ERROR_CODE);
    }

    @Test
    public void addTaskNOOK2() {
        ResponseModel ControllerResponse = taskManagerController.addTask(taskDummyMapIncomplete);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.INCOMPLETE_FIELDS_CODE);
    }

    @Test
    public void getListOfTaskOK() {
        ResponseModel ControllerResponse = taskManagerController.addTask(taskDummyMap);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void getTaskByIDOK() {
        ResponseModel ControllerResponse = taskManagerController.getTaskByID(listOfTask.get(2).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);
    }

    @Test
    public void getTaskByIDNOOK() {
        ResponseModel ControllerResponse = taskManagerController.getTaskByID(null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);
    }

    @Test
    public void updateTaskOK() {
        ResponseModel ControllerResponse = taskManagerController.updateTask(taskDummyMap,listOfTask.get(0).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);

    }

    @Test
    public void updateTaskNOOK() {
        ResponseModel ControllerResponse = taskManagerController.updateTask(taskDummyMapIncomplete,listOfTask.get(0).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.INCOMPLETE_FIELDS_CODE);

    }

    @Test
    public void updateTaskNOOK2() {
        ResponseModel ControllerResponse = taskManagerController.updateTask(taskDummyMap,null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);

    }

    @Test
    public void updateTaskNOOK3() {
        ResponseModel ControllerResponse = taskManagerController.updateTask(taskDummyMapIncorrect,null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.UNEXPECTED_ERROR_CODE);
    }

    @Test
    public void deleteTaskOK() {
        ResponseModel ControllerResponse = taskManagerController.deleteTask(listOfTask.get(0).getId());
        Assert.assertEquals(ControllerResponse.getCode(), Constants.SUCCESSUL_PROCESS_CODE);

    }

    @Test
    public void deleteTaskNOOK() {
        ResponseModel ControllerResponse = taskManagerController.deleteTask(null);
        Assert.assertEquals(ControllerResponse.getCode(), Constants.TASK_NOT_FOUND_CODE);
    }
}
