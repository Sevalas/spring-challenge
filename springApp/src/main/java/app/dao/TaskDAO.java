package app.dao;

import app.constants.Constants;
import app.db.SavedTask;
import app.dto.ResponseModel;
import app.dto.TaskDTO;
import app.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TaskDAO  {

    private final SavedTask savedTask;
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public TaskDAO() {
        savedTask = new SavedTask();
    }

    public ResponseModel addTask(Map<String, Object> bodyRequest) {
        ResponseModel responseModel;
        TaskDTO initialTask = objectMapper.convertValue(bodyRequest,TaskDTO.class);

        if(isAnyAttributeOfTaskNullOrEmpty(initialTask)) {
            return new ResponseModel(Constants.INCOMPLETE_FIELDS_CODE, Constants.INCOMPLETE_FIELDS_MESSAGE,
                    TaskDTO.class.getSimpleName(), null, Constants.NO_EXCEPTION);
        }
        TaskDTO insertedTask = savedTask.insertSavedTask(initialTask);

        if(insertedTask == null){
            responseModel = new ResponseModel(Constants.INSERT_ERROR_CODE, Constants.INSERT_ERROR_MESSAGE,
                    TaskDTO.class.getSimpleName(), insertedTask, Constants.NO_EXCEPTION);
        } else {
            responseModel = new ResponseModel(Constants.SUCCESSUL_PROCESS_CODE, Constants.PROCESS_SUCCESS_MESSAGE,
                    TaskDTO.class.getSimpleName(), insertedTask, Constants.NO_EXCEPTION);
        }
        return responseModel;
    }

    public ResponseModel getListOfTask() {
        ResponseModel responseModel;
        List<TaskDTO> listOfTask = savedTask.selectSavedTaskList();

        if(Utils.isListNullOrEmpty(listOfTask)){
            responseModel = new ResponseModel(Constants.EMPTY_RESPONSE_OBJECT_CODE,
                    Constants.EMPTY_RESPONSE_OBJECT_MESSAGE,
                    List.class.getSimpleName() + "<" + TaskDTO.class.getSimpleName() + ">", listOfTask,
                    Constants.NO_EXCEPTION);
        } else {
            responseModel = new ResponseModel(Constants.SUCCESSUL_PROCESS_CODE, Constants.PROCESS_SUCCESS_MESSAGE,
                    List.class.getSimpleName() + "<" + TaskDTO.class.getSimpleName() + ">",
                    listOfTask, Constants.NO_EXCEPTION);
        }
        return responseModel;
    }

    public ResponseModel getTaskByID(String taskId) {
        ResponseModel responseModel;
        TaskDTO task = savedTask.selectSavedTaskById(taskId);
        if(task == null){
            taskId = taskId == null ? Constants.EMPTY_STRING : taskId;
            responseModel = new ResponseModel(Constants.TASK_NOT_FOUND_CODE,
                    Constants.TASK_NOT_FOUND_MESSAGE.replace("{taskId}",taskId), TaskDTO.class.getSimpleName(),
                    task, Constants.NO_EXCEPTION);
        } else {
            responseModel = new ResponseModel(Constants.SUCCESSUL_PROCESS_CODE, Constants.PROCESS_SUCCESS_MESSAGE,
                    TaskDTO.class.getSimpleName(), task, Constants.NO_EXCEPTION);
        }
        return responseModel;
    }

    public ResponseModel updateTask(String actualTaskId,Map<String, Object> bodyRequest) {
        TaskDTO updatedTask = objectMapper.convertValue(bodyRequest,TaskDTO.class);

        if(isAnyAttributeOfTaskNullOrEmpty(updatedTask)) {
            return new ResponseModel(Constants.INCOMPLETE_FIELDS_CODE, Constants.INCOMPLETE_FIELDS_MESSAGE,
                    TaskDTO.class.getSimpleName(), null, Constants.NO_EXCEPTION);
        }

        ResponseModel responseModel;
        ResponseModel responseModelOfExistingTask = getTaskByID(actualTaskId);

        if (!responseModelOfExistingTask.getCode().equals(Constants.SUCCESSUL_PROCESS_CODE)){
            return responseModelOfExistingTask;
        } else {
            TaskDTO task = savedTask.updateSavedTask(actualTaskId,updatedTask);
            if(task == null){
                responseModel = new ResponseModel(Constants.INSERT_ERROR_CODE, Constants.INSERT_ERROR_MESSAGE,
                        TaskDTO.class.getSimpleName(), task, Constants.NO_EXCEPTION);
            } else {
                responseModel = new ResponseModel(Constants.SUCCESSUL_PROCESS_CODE, Constants.PROCESS_SUCCESS_MESSAGE,
                        TaskDTO.class.getSimpleName(), task, Constants.NO_EXCEPTION);
            }
        }
        return responseModel;
    }

    public ResponseModel deleteTask(@RequestParam(value = "task-id") String taskId) {
        ResponseModel responseModelOfExistingTask = getTaskByID(taskId);

        if (!responseModelOfExistingTask.getCode().equals(Constants.SUCCESSUL_PROCESS_CODE)){
            return responseModelOfExistingTask;
        }

        ResponseModel responseModel;
        Boolean isTaskDeleted = savedTask.deleteSavedTask(taskId);

        if(!isTaskDeleted){
            responseModel = new ResponseModel(Constants.DELETE_ERROR_CODE, Constants.DELETE_ERROR_MESSAGE,
                    Boolean.class, isTaskDeleted, Constants.NO_EXCEPTION);
        } else {
            responseModel = new ResponseModel(Constants.SUCCESSUL_PROCESS_CODE, Constants.PROCESS_SUCCESS_MESSAGE,
                    Boolean.class, isTaskDeleted, Constants.NO_EXCEPTION);
        }
        return responseModel;
    }

    private boolean isAnyAttributeOfTaskNullOrEmpty(TaskDTO task){
        List<String> taskStringFieldList = Arrays.asList(task.getReporterName(), task.getAssigneeName(),
                task.getCreationDate(), task.getUpdateDate(), task.getTitle(), task.getDescription(), task.getStatus());
        return taskStringFieldList.contains(null) || taskStringFieldList.contains(Constants.EMPTY_STRING);
    }
}
