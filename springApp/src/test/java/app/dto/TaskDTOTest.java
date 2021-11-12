package app.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TaskDTOTest {

    private TaskDTO taskDTO = new TaskDTO();

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup(){
        taskDTO = getTaskDTODummy();
    }

    @Test
    public void getResponseModel() {

        Assert.assertNotNull(taskDTO.getId());
        Assert.assertNotNull(taskDTO.getReporterName());
        Assert.assertNotNull(taskDTO.getAssigneeName());
        Assert.assertNotNull(taskDTO.getCreationDate());
        Assert.assertNotNull(taskDTO.getUpdateDate());
        Assert.assertNotNull(taskDTO.getTitle());
        Assert.assertNotNull(taskDTO.getDescription());
        Assert.assertNotNull(taskDTO.getStatus());
    }

    private TaskDTO getTaskDTODummy(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId("test");
        taskDTO.setReporterName("test");
        taskDTO.setAssigneeName("test");
        taskDTO.setCreationDate("test");
        taskDTO.setUpdateDate("test");
        taskDTO.setTitle("test");
        taskDTO.setDescription("test");
        taskDTO.setStatus("test");
        return taskDTO;
    }

}
