package ie.itt.devops.aleksandar.devopsproject;

import android.database.sqlite.SQLiteDatabase;
import android.test.RenamingDelegatingContext;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hunter on 22/02/2017.
 */
public class LogMeInTest {
    @Test
    public void validationMobNumPassword() throws Exception {
        String mobileInput = "0874561236";
        String passwordInput = "password123";
        boolean output;
        boolean expected = true;

        LogMeIn logMeIn = new LogMeIn();
        output = logMeIn.validationMobNumPassword(mobileInput,passwordInput);

        assertEquals(expected,output);

    }

    @Test
    public void onClick() throws Exception {

    }

}