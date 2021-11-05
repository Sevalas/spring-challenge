package app.controllers;

import app.util.Utils;
import app.dao.TaskDAO;
import app.dto.ResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/task-manager")
public class TaskManagerController {

	private final static TaskDAO TaskDAO = new TaskDAO();

	/**
	 * Method to create tasks.
	 *
	 * @param bodyRequest json request with task attributes
	 * @return ResponseModel with the created task objectt
	 */
	@PostMapping("/add-task")
		public ResponseModel addTask(@RequestBody (required=true) Map<String, Object> bodyRequest) {
		ResponseModel responseModel;
		try {
			responseModel = TaskDAO.addTask(bodyRequest);
		} catch (Exception e) {
			responseModel = Utils.responseModelUnexpectedErrorHandler(e);
		}
		return responseModel;
	}

	/**
	 * Method to get a list of all saved tasks.
	 *
	 * @return ResponseModel with a List of all Saves task
	 */
	@GetMapping("/get-task-list")
	public ResponseModel getListOfTask() {
		ResponseModel responseModel;
		try {
			responseModel = TaskDAO.getListOfTask();
		} catch (Exception e) {
			responseModel = Utils.responseModelUnexpectedErrorHandler(e);
		}
		return responseModel;
	}

	/**
	 * Method to get a task by the id.
	 *
	 * @param taskId id of the task to find
	 * @return ResponseModel with founded task
	 */
	@GetMapping("/get-task/{task-id}")
	public ResponseModel getTaskByID(@RequestParam(value = "task-id") String taskId) {
		ResponseModel responseModel;
		try {
			responseModel = TaskDAO.getTaskByID(taskId);
		} catch (Exception e) {
			responseModel = Utils.responseModelUnexpectedErrorHandler(e);
		}
		return responseModel;
	}

	/**
	 * Method to update a task.
	 *
	 * @param bodyRequest json request with task attributes
	 * @param actualTaskId id of the task to update
	 * @return ResponseModel with updated task
	 */
	@PutMapping("/update-task/{task-id}")
	public ResponseModel updateTask(@RequestBody (required=true) Map<String, Object> bodyRequest,
									@RequestParam(value = "task-id") String actualTaskId) {
		ResponseModel responseModel;
		try {
			responseModel = TaskDAO.updateTask(actualTaskId,bodyRequest);
		} catch (Exception e) {
			responseModel = Utils.responseModelUnexpectedErrorHandler(e);
		}
		return responseModel;
	}

	/**
	 * Method to delete a task.
	 *
	 * @param taskId id of the task to delete
	 * @return ResponseModel with a indicative boolean value
	 */
	@DeleteMapping("/delete-task/{task-id}")
	public ResponseModel deleteTask(@RequestParam(value = "task-id") String taskId) {
		ResponseModel responseModel;
		try {
			responseModel = TaskDAO.deleteTask(taskId);
		} catch (Exception e) {
			responseModel = Utils.responseModelUnexpectedErrorHandler(e);
		}
		return responseModel;
	}
}