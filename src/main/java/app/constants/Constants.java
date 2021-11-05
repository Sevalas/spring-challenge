package app.constants;

public class Constants {

    //Response Codes
    public final static String SUCCESSUL_PROCESS_CODE = "00";
    public final static String EMPTY_RESPONSE_OBJECT_CODE = "01";
    public final static String TASK_NOT_FOUND_CODE = "02";
    public final static String INSERT_ERROR_CODE = "03";
    public final static String DELETE_ERROR_CODE = "04";
    public final static String INCOMPLETE_FIELDS_CODE = "05";
    public final static String UNEXPECTED_ERROR_CODE = "06";

    //Response Messages
    public final static String PROCESS_SUCCESS_MESSAGE = "Process completed successfully";
    public final static String EMPTY_RESPONSE_OBJECT_MESSAGE = "Process completed with empty response object";
    public final static String TASK_NOT_FOUND_MESSAGE = "Process present a error, task {taskId} was not found";
    public final static String INSERT_ERROR_MESSAGE = "Process present a error, task cannot be inserted";
    public final static String DELETE_ERROR_MESSAGE = "Process present a error, task cannot be deleted";
    public final static String INCOMPLETE_FIELDS_MESSAGE = "Invalid request, one or more fields are incomplete";
    public final static String UNEXPECTED_ERROR_MESSAGE = "Process present an unexpected error";


    public final static String NO_EXCEPTION = null;
    public final static String NO_RESPONSE_OBJECT = null;
    public final static String NO_RESPONSE_OBJECT_TYPE = null;

    public final static String EMPTY_STRING = "";

}
