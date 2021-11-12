package app.util;

import app.constants.Constants;
import app.dto.ResponseModel;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testTestPrivateConstructor() {
        Constructor<Utils> cnt;
        try {
            cnt = Utils.class.getDeclaredConstructor();
            cnt.setAccessible(true);

            cnt.newInstance();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    public void responseModelUnexpectedErrorHandlerOK() {
        Exception exception = new Exception("Test");
        ResponseModel responseModel = Utils.responseModelUnexpectedErrorHandler(exception);
        Assert.assertEquals(Constants.UNEXPECTED_ERROR_MESSAGE, responseModel.getMessage());

        exception = null;
        responseModel = Utils.responseModelUnexpectedErrorHandler(exception);
        Assert.assertEquals(Constants.EMPTY_STRING, responseModel.getException());
    }

    @Test
    public void isListNullOrEmpty() {
        List<String> nullList = null;
        List<String> EmptyList = new ArrayList<>();
        List<String> listWithItems = new ArrayList<>(
                Arrays.asList("Test","Test2")
        );
        Assert.assertTrue(Utils.isListNullOrEmpty(nullList));
        Assert.assertTrue(Utils.isListNullOrEmpty(EmptyList));
        Assert.assertFalse(Utils.isListNullOrEmpty(listWithItems));
    }
}
