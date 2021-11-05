package app.util;

import app.constants.Constants;
import app.dto.ResponseModel;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public ResponseModel responseModelUnexpectedErrorHandler (Exception exception){
        ResponseModel responseModel = new ResponseModel(
                Constants.UNEXPECTED_ERROR_CODE,
                Constants.UNEXPECTED_ERROR_MESSAGE,
                Constants.NO_RESPONSE_OBJECT_TYPE,
                Constants.NO_RESPONSE_OBJECT,
                exception.toString()+Arrays.toString(exception.getStackTrace())
        );
        return responseModel;
    }

    public static boolean isListNullOrEmpty(List list){
        return list == null || list.isEmpty();
    }
}
