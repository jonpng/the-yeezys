package test;
/**
 * Created by Brandon on 11/13/16.
 */

import model.User;
import org.junit.*;

public class Junit_Test {

    User user1 = new User("Name1", "User1", "Pass1".hashCode(), "Worker");
    User user2 = new User("Name2", "User2", "Pass2".hashCode(), "Worker");

    @Test
    public void test() {
        assert(user1.verify("User1", "Pass1"));
        assert(user2.verify("User2", "Pass2"));
    }
}
