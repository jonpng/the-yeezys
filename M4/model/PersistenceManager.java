package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Steve on 10/17/2016.
 */
public class PersistenceManager {
    private static final Logger LOGGER = Logger.getLogger("fxapp.MainFXApplication");

    public static void insertUser(String user, int pass, String name, String accountType) {
        Connection connect;
        PreparedStatement preStatement;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");

            preStatement = connect.prepareStatement("select * from users where Username=?");
            preStatement.setString(1, user);

            resultSet = preStatement.executeQuery();
            resultSet.next();

            if (resultSet.first()) {
                throw new IllegalArgumentException();
            } else {
                preStatement = connect.prepareStatement("INSERT INTO users(Username, Password, Name, Account_Type) VALUES(?, ?, ?, ?)");

                preStatement.setString(1, user);
                preStatement.setInt(2, pass);
                preStatement.setString(3, name);
                preStatement.setString(4, accountType);

                preStatement.execute();
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static User accessUser(String user, int pass) {
        Connection connect;
        PreparedStatement preStatement;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");

            preStatement = connect.prepareStatement("select * from users where Username=? and Password=?");
            preStatement.setString(1, user);
            preStatement.setInt(2, pass);

            resultSet = preStatement.executeQuery();

            resultSet.next();

            if (resultSet.first()) {
                return new User(resultSet.getString("Name"), resultSet.getString("Username"),
                        resultSet.getInt("Password"), resultSet.getString("Account_Type"), resultSet.getString("Email"),
                        resultSet.getString("Address"));
            } else {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred");
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateUser(String username, int oldPass, String name, int newPass, String addr, String email) {
        Connection connect;
        PreparedStatement preStatement;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");

            preStatement = connect.prepareStatement("UPDATE users SET Name=?, Password=?, Address=?, Email=? WHERE Username=? and Password=?");

            preStatement.setString(1, name);
            preStatement.setInt(2, newPass);
            preStatement.setString(3, addr);
            preStatement.setString(4, email);
            preStatement.setString(5, username);
            preStatement.setInt(6, oldPass);

            preStatement.executeUpdate();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void insertReport(int id, double xCoord, double yCoord, Timestamp date, String reporter, String srcName, String srcCondition, String srcType, String NSDir, String EWDir) {
        Connection connect;
        PreparedStatement preStatement;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");

            preStatement = connect.prepareStatement("INSERT INTO reports(id, xCoord, yCoord, date, reporter, srcName, srcCondition, srcType, NSDir, EWDir) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preStatement.setInt(1, id);
            preStatement.setDouble(2, xCoord);
            preStatement.setDouble(3, yCoord);
            preStatement.setTimestamp(4, date);
            preStatement.setString(5, reporter);
            preStatement.setString(6, srcName);
            preStatement.setString(7, srcCondition);
            preStatement.setString(8, srcType);
            preStatement.setString(9, NSDir);
            preStatement.setString(10, EWDir);

            preStatement.execute();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Report> accessReports() {
        Connection connect;
        PreparedStatement preStatement;
        ResultSet resultSet = null;

        ArrayList<Report> reports = new ArrayList<Report>();

        try {
            connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");

            preStatement = connect.prepareStatement("select * from reports");
            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                reports.add(new Report(resultSet.getDouble("xCoord"), resultSet.getDouble("yCoord"),
                        resultSet.getString("srcName"), resultSet.getString("srcCondition"),
                        resultSet.getString("reporter"), resultSet.getString("NSDir"), resultSet.getString("EWDir"),
                        resultSet.getString("srcType")));
            }

            return reports;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred");
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

