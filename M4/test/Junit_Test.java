package test;
/**
 * Created by Brandon on 11/13/16.
 */

import model.Report;
import model.User;
import model.PurityReport;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Junit_Test {

    User user1 = new User("Name1", "User1", "Pass1".hashCode(), "Worker");
    User user2 = new User("Name2", "User2", "Pass2".hashCode(), "Worker");

    Report report1 = new Report(0, 0, "Test1", "Waste", "username", "N", "E", "Well");
    Report report2 = new Report(38, 24, "Test2", "Potable", "manager", "S", "E", "Lake");

    Date date1 = new Date();
    long i = 1479135572;
    Date date2 = new Date(i);
    PurityReport pure1 = new PurityReport(0, 0, "Name1", "Fair", "Reporter1", "N", "E", 10, 20, date1);
    PurityReport pure2 = new PurityReport(52, 48, "Name2", "Good", "Reporter2", "S", "W", 0, 0, date2);
    String dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date1);
    String dateStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date2);


    @Before
    public void setUp() {
        user1 =new User("Name1", "User1", "Pass1".hashCode(), "Worker");
        user2 = new User("Name2", "User2", "Pass2".hashCode(), "Worker");

        report1 = new Report(0, 0, "Test1", "Waste", "username", "N", "E", "Well");
        report2 = new Report(38, 24, "Test2", "Potable", "manager", "S", "E", "Lake");

        pure1 = new PurityReport(0, 0, "Name1", "Fair", "Reporter1", "N", "E", 10.0, 20.0, date1);
        pure2 = new PurityReport(52, 48, "Name2", "Good", "Reporter2", "S", "W", 0.1, 0.1, date2);
        dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date1);
        dateStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date2);
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

    @Test
    public void testPurity() {
        Assert.assertEquals(pure1.getVirusPPM(), 10, 0.001);
        Assert.assertEquals(pure1.getContainmentPPM(), 20, 0.001);
        Assert.assertEquals(pure1.getDate(), dateStr1);

        Assert.assertEquals(pure2.getVirusPPM(), 0.1, 0.001);
        Assert.assertEquals(pure2.getContainmentPPM(), 0.1, 0.001);
        Assert.assertEquals(pure2.getDate(), dateStr2);
    }

}
