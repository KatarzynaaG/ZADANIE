package Zadanie;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
        public Connection dataBaseLink;

        public Connection getConnection() {
            String dataBaseName = "demo_db";
            String dataBaseUser = "demo";
            String dataBasePassword = "putyourpasswordhere";
            String url = "jdbc:mysql://localhost/" + dataBaseName;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dataBaseLink = DriverManager.getConnection(url, dataBaseUser, dataBasePassword);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
            return dataBaseLink;
        }
    }

