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
    
    private User taylor = new User("Taylor", "thavrilak3", 12345, "User");
    private Report report = new Report(43.3763, -87.0294, "Lake Michigan", "Waste", taylor.getName(), "N", "W", "Lake");


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
        
        taylor = new User("Taylor", "thavrilak3", 12345, "User");
        report = new Report(43.3763, -87.0294, "Lake Michigan", "Waste", taylor.getName(), "N", "W", "Lake");
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
    
    @Test
    public void verifyReport() {
        Assert.assertEquals(report.getX(), 43.3763, 0.001);
        Assert.assertEquals(report.getY(), -87.0294, 0.001);
        Assert.assertEquals(report.getReportName(), "Lake Michigan");
        Assert.assertEquals(report.getCondition(), "Waste");
        Assert.assertEquals(report.getReporter(), taylor.getName());
        Assert.assertEquals(report.getNSDir(), "N");
        Assert.assertEquals(report.getEWDir(), "W");
        Assert.assertEquals(report.getType(), "Lake");
    }
    
    @Test
    public void testUser3() {
        assertTrue(taylor.verify(taylor.getUsername(), String.valueOf(taylor.getPassword()));   
    }
}
