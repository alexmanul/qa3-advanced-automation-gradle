package Steps;

import MYSQL.SQLHelper;
//import cucumber.api.CucumberOptions;
//import cucumber.api.java.After;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j
@CucumberOptions(glue = {"cucumber.hook", "cucumber.steps"})
public class Hooks {
    final SQLHelper sqlHelper = new SQLHelper();

    // ToDo: Draft version
    public static boolean restoreDB(String dbName, String dbUserName, String dbPassword, String source) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName, "-e", " source " + source};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
                return true;
            } else {
                System.out.println("Could not restore the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @After("@DropDBTableAgents")
    public void dropDBTableAgents() throws IOException, SQLException {
        String query = "DROP TABLE AGENTS";
        Connection connection = sqlHelper.createConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        log.info("Database is dropped");
        connection.close();
    }

    @Before("@CreateDBTableAgents")
    public void createDBTableAgents() throws IOException, SQLException {
        sqlHelper.readSQLFromFile();
        log.info("Database table 'AGENTS' is created");
    }
}
