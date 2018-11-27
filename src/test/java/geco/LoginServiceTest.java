package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService loginService;
    final String [] logins = new String[] {"jeanjean", "mimi", "toto", "tutelle", "trottoir"};

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(logins);
        for(String login : logins)
            assertTrue(loginService.findAllLogins().contains(login));
    }

    @Test
    public void loginExists() {
        assertTrue(loginService.loginExists("jeanjean"));
        assertFalse(loginService.loginExists("caca"));
    }

    @Test
    public void addLogin() {
        loginService.addLogin("coco");
        assertTrue(loginService.loginExists("coco"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        String token = "t";
        ArrayList<String> res = (ArrayList<String>) loginService.findAllLoginsStartingWith(token);
        for(String login : logins)
            if(login.startsWith(token)) assertTrue(res.contains(login));
    }

    @Test
    public void findAllLogins() {
        for(String login : logins)
            assertTrue(loginService.findAllLogins().contains(login));
    }
}