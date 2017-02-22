package ie.itt.devops.aleksandar.devopsproject;

import android.content.Context;
import android.content.res.Resources;
import android.test.ActivityTestCase;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Hunter on 22/02/2017.
 */
public class WelcomeTest {
    @Test
    public void getCurrentTime()  throws Exception {
        String expected = DateFormat.getDateTimeInstance().format(new Date());
        String output;

        Welcome welcome = new Welcome();
        output = welcome.getCurrentTime();

        assertEquals(expected,output);
    }
}