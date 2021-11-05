package app.dto;

public class ResponseModel {
    private String code;
    private String message;
    private Object objectType;
    private Object responseObject;
    private String exception;


    public ResponseModel() {}

    public ResponseModel(String code, String message, Object objectType, Object responseObject, String exception) {
        this.code = code;
        this.message = message;
        this.objectType = objectType;
        this.responseObject = responseObject;
        this.exception = exception;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObjectType() {
        return objectType;
    }

    public void setObjectType(Object objectType) {
        this.objectType = objectType;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", objectType=" + objectType +
                ", responseObject=" + responseObject +
                ", error='" + exception + '\'' +
                '}';
    }
}
