package ie.itt.devops.aleksandar.devopsproject;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hunter on 22/02/2017.
 */
public class RegisterTest {
    @Test
    public void validateRegistrationForm() throws Exception {
        String nameInput = "Joe Doe";
        String mobileInput = "0856743426";
        String emailInput = "thisismyemail@hotmail.com";
        String passwordInput = "password321";

        boolean output;
        boolean expected = true;

        Register register = new Register();
        output = register.validateRegistrationForm(nameInput,mobileInput,emailInput,passwordInput);

        assertEquals(expected,output);

    }
}