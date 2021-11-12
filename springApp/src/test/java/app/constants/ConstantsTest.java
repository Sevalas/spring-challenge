package app.constants;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ConstantsTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testConstantes() throws Exception {
        Constructor<Constants> constructor =  Constants.class
                .getDeclaredConstructor();
        constructor.setAccessible(true);
        Constants constants = constructor.newInstance();
        Assert.assertNotNull(constants);
        for (Field field : constants.getClass().getDeclaredFields())
            if (field != null)
                Assert.assertFalse(field.getName() == null && field.get(constants) == null);
    }
}
