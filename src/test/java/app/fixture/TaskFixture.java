package app.fixture;

import app.dto.TaskDTO;

import java.util.HashMap;
import java.util.Map;

public class TaskFixture {

    public final static TaskDTO taskDummy = new TaskDTO("test","test","test","test","test","test","test","test");

    public final static Map<String, Object> taskDummyMap = new HashMap<String, Object>(){{
        put("reporterName", "test");
        put("assigneeName", "test");
        put("creationDate", "2021-11-04");
        put("updateDate", "2021-11-04");
        put("title", "test");
        put("description", "test");
        put("status", "test");
    }};

    public final static Map<String, Object> taskDummyMapIncomplete = new HashMap<String, Object>(){{
        put("reporterName", null);
        put("assigneeName", "test");
        put("creationDate", "2021-11-04");
        put("updateDate", "2021-11-04");
        put("title", null);
        put("description", "test");
        put("status", null);
    }};

    public final static Map<String, Object> taskDummyMapIncorrect = new HashMap<String, Object>(){{
        put("unexpectedParam", 222);
        put("reporterName", "test");
        put("assigneeName", "test");
        put("creationDate", null);
        put("updateDate", "2021-11-04");
        put("title", "test");
        put("description", "test");
    }};
}
