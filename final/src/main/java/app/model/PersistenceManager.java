package app.model;

import app.fxapp.MainFXApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Steve on 10/17/2016.
 */
public class PersistenceManager {
    private static final Logger LOGGER = Logger.getLogger("fxapp.MainFXApplication");

    public static void insertUser(String user, int pass, String name, String accountType, Connection connect) {
        PreparedStatement preStatement;
        ResultSet resultSet = null;

        try {

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
            LOGGER.log(Level.SEVERE, "SQL Error occurred");
            e.printStackTrace();
            return;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static User accessUser(String user, int pass, Connection connect) {
        PreparedStatement preStatement;
        ResultSet resultSet = null;

        try {

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
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "SQL Error occurred");
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void updateUser(String username, int oldPass, String name, int newPass, String addr, String email, Connection connect) {
        PreparedStatement preStatement;

        try {

            preStatement = connect.prepareStatement("UPDATE users SET Name=?, Password=?, Address=?, Email=? WHERE Username=? and Password=?");

            preStatement.setString(1, name);
            preStatement.setInt(2, newPass);
            preStatement.setString(3, addr);
            preStatement.setString(4, email);
            preStatement.setString(5, username);
            preStatement.setInt(6, oldPass);

            preStatement.executeUpdate();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SQL Error occurred");
            e.printStackTrace();
            return;
        }
    }

    public static void insertReport(int id, double xCoord, double yCoord, Timestamp date, String reporter,
                                    String srcName, String srcCondition, String srcType, String NSDir, String EWDir, Connection connect) {
        PreparedStatement preStatement;

        try {

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

        }   catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SQL Error occurred");
            e.printStackTrace();
            return;
        }
    }

    public static void insertPurityReport(int id, double xCoord, double yCoord, Timestamp date, String reporter,
                                    String srcName, String srcCondition, double virusPPM, double contaminantPPM, String NSDir, String EWDir, Connection connect) {
        PreparedStatement preStatement;

        try {

            preStatement = connect.prepareStatement("INSERT INTO purity_reports(id, xCoord, yCoord, date, reporter, srcName, srcCondition, virusPPM, contPPM, NSDir, EWDir) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preStatement.setInt(1, id);
            preStatement.setDouble(2, xCoord);
            preStatement.setDouble(3, yCoord);
            preStatement.setTimestamp(4, date);
            preStatement.setString(5, reporter);
            preStatement.setString(6, srcName);
            preStatement.setString(7, srcCondition);
            preStatement.setDouble(8, virusPPM);
            preStatement.setDouble(9, contaminantPPM);
            preStatement.setString(10, NSDir);
            preStatement.setString(11, EWDir);

            preStatement.execute();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SQL Error occurred");
            e.printStackTrace();
            return;
        }
    }

    public static void accessReports(MainFXApplication screen, Connection connect) {
        PreparedStatement preStatement;
        ResultSet resultSet = null;
        ReportList<Report> reports = screen.getReports();

        try {
            preStatement = connect.prepareStatement("select * from reports");
            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                reports.add(new Report(resultSet.getDouble("xCoord"), resultSet.getDouble("yCoord"),
                        resultSet.getString("srcName"), resultSet.getString("srcCondition"),
                        resultSet.getString("reporter"), resultSet.getString("NSDir"), resultSet.getString("EWDir"),
                        resultSet.getString("srcType"), resultSet.getTimestamp("date")));
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred");
            e.printStackTrace();
            return;
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

    public static void accessPurityReports(MainFXApplication screen, Connection connect) {
        PreparedStatement preStatement;
        ResultSet resultSet = null;
        ReportList<PurityReport> reports = screen.getPurityReports();

        try {
            preStatement = connect.prepareStatement("select * from purity_reports");
            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                reports.add(new PurityReport(resultSet.getDouble("xCoord"), resultSet.getDouble("yCoord"),
                        resultSet.getString("srcName"), resultSet.getString("srcCondition"),
                        resultSet.getString("reporter"), resultSet.getString("NSDir"), resultSet.getString("EWDir"),
                        resultSet.getDouble("virusPPM"), resultSet.getDouble("contPPM"), resultSet.getTimestamp("date")));
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred");
            e.printStackTrace();
            return;
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

