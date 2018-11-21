package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginGenerator loginGenerator;
    LoginService loginService;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        assertFalse(loginService.loginExists("PDUR"));
        loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        assertTrue(loginService.loginExists("PDUR"));

        assertFalse(loginService.loginExists("JRAL2"));
        loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        assertTrue(loginService.loginExists("JRAL2"));

        assertFalse(loginService.loginExists("JROL1"));
        loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        assertTrue(loginService.loginExists("JROL1"));

        assertFalse(loginService.loginExists("PDUR1"));
        loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertTrue(loginService.loginExists("PDUR1"));

    }
}