package app.db;

import app.dto.TaskDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SavedTask {

    private List<TaskDTO> savedTasks = new ArrayList<>(
            Arrays.asList(
                    new TaskDTO("92506a87-5195-4d04-b7eb-87954a679f7c","test","test",
                            new Date().toString(),new Date().toString(),"test","test","test"),
                    new TaskDTO("a86e482f-4da5-4851-9e39-52e90db5b770","ADJKS","ADJKS",
                            new Date().toString(),new Date().toString(),"ADJKS","ADJKS","ADJKS"),
                    new TaskDTO("932874cb-4dc5-40f9-976c-c3d1528fc75a","JiJiJi","JiJiJi",
                            new Date().toString(),new Date().toString(),"JiJiJi","JiJiJi","JiJiJi"),
                    new TaskDTO("7234e5d8-13ff-4991-9b31-dce8e45e069d","Sevalas","Sevalas",
                            new Date().toString(),new Date().toString(),"Sevalas","Sevalas","Sevalas"),
                    new TaskDTO("7234e5d8-13ff-4991-9b31-dce8e45e069d","Now","Now",
                            new Date().toString(),new Date().toString(),"Now","Now","Now")
            ));

    public SavedTask() {
    }

    public TaskDTO insertSavedTask(TaskDTO task) {
        if(!isTaskPresent(task.getId())){
            savedTasks.add(task);
            return selectSavedTaskById(task.getId());
        }
        return null;
    }

    public List<TaskDTO> selectSavedTaskList() {
        return savedTasks;
    }

    public TaskDTO selectSavedTaskById(String taskId) {
        Optional<TaskDTO> optionalkTaskDTO = savedTasks.stream().filter(task -> task.getId().equals(taskId)).findFirst();
        return optionalkTaskDTO.orElse(null);
    }

    public TaskDTO updateSavedTask(String taskId, TaskDTO modifiedTask) {
        if(isTaskPresent(taskId)){
            for(TaskDTO task : savedTasks) {
                if(taskId.equals(task.getId())) {
                    task.setReporterName(modifiedTask.getReporterName());
                    task.setAssigneeName(modifiedTask.getAssigneeName());
                    task.setCreationDate(modifiedTask.getCreationDate());
                    task.setUpdateDate(modifiedTask.getUpdateDate());
                    task.setTitle(modifiedTask.getTitle());
                    task.setDescription(modifiedTask.getDescription());
                    task.setStatus(modifiedTask.getStatus());
                    return selectSavedTaskById(task.getId());
                }
            }
        }
        return null;
    }

    public Boolean deleteSavedTask(String taskId) {
        List<TaskDTO> modifiedSavedTaskList = new ArrayList<>();

        if(isTaskPresent(taskId)){
            for(TaskDTO task : savedTasks) {
                if (!taskId.equals(task.getId())) {
                    modifiedSavedTaskList.add(task);
                }
            }
            savedTasks = modifiedSavedTaskList;
            return true;
        }
        return false;
    }

    private boolean isTaskPresent (String taskId){
        return savedTasks.stream().anyMatch(task -> task.getId().equals(taskId));
    }
}
