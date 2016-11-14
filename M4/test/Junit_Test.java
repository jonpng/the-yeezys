package test;
/**
 * Created by Brandon on 11/13/16.
 */

import model.Report;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Junit_Test {

    User user1 = new User("Name1", "User1", "Pass1".hashCode(), "Worker");
    User user2 = new User("Name2", "User2", "Pass2".hashCode(), "Worker");

    Report report1 = new Report(0, 0, "Test1", "Waste", "username", "N", "E", "Well");
    Report report2 = new Report(38, 24, "Test2", "Potable", "manager", "S", "E", "Lake");

    @Before
    public void setUp() {
        user1 =new User("Name1", "User1", "Pass1".hashCode(), "Worker");
        user2 = new User("Name2", "User2", "Pass2".hashCode(), "Worker");

        report1 = new Report(0, 0, "Test1", "Waste", "username", "N", "E", "Well");
        report2 = new Report(38, 24, "Test2", "Potable", "manager", "S", "E", "Lake");
    }

    @Test
    public void testUser() {
        assert(user1.verify("User1", "Pass1"));
        assert(user2.verify("User2", "Pass2"));
    }

    @Test
    public void testReport() {
        Assert.assertEquals(report1.getX(), 0, 0.001);
        Assert.assertEquals(report1.getY(), 0, 0.001);
        Assert.assertEquals(report1.getCondition(), "Waste");
        Assert.assertEquals(report1.getType(), "Well");
        Assert.assertEquals(report1.getReportName(), "Test1");
        Assert.assertEquals(report1.getReporter(), "username");

        Assert.assertEquals(report2.getX(), 38, 0.001);
        Assert.assertEquals(report2.getY(), 24, 0.001);
        Assert.assertEquals(report2.getCondition(), "Potable");
        Assert.assertEquals(report2.getType(), "Lake");
        Assert.assertEquals(report2.getReportName(), "Test2");
        Assert.assertEquals(report2.getReporter(), "manager");
    }

}
