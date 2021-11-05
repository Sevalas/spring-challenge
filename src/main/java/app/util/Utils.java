package app.util;

import app.constants.Constants;
import app.dto.ResponseModel;

import java.util.Arrays;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static ResponseModel responseModelUnexpectedErrorHandler(Exception exception){
        String exceptionDescription = exception == null ? Constants.EMPTY_STRING :
                exception.toString()+Arrays.toString(exception.getStackTrace());

        ResponseModel responseModel = new ResponseModel(Constants.UNEXPECTED_ERROR_CODE,
                Constants.UNEXPECTED_ERROR_MESSAGE, Constants.NO_RESPONSE_OBJECT_TYPE,
                Constants.NO_RESPONSE_OBJECT, exceptionDescription);

        return responseModel;
    }

    public static boolean isListNullOrEmpty(List list){
        return list == null || list.isEmpty();
    }
}
