package com.mercadolibre.demo_app_sebas.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fury.api.FuryUtils;
import com.fury.api.exceptions.FuryDecryptException;
import com.fury.api.exceptions.FuryNotFoundAPPException;
import com.fury.api.exceptions.FuryUpdateException;

public class ConnectionDB {

    private Connection connect;
    String host = FuryUtils.getEnv("DB_MYSQL_DESAENV04_DATABASESE_DATABASESE_ENDPOINT");
    // You can use the variables (with READ ONLY permissions):
    // FuryUtils.getEnv("DB_MYSQL_DESAENV04_DATABASESE_DATABASESE_LOCAL_REPLICA_ENDPOINT"; to connect to the local replica, or...
    // FuryUtils.getEnv("DB_MYSQL_DESAENV04_DATABASESE_DATABASESE_REMOTE_REPLICA_ENDPOINT"; for the remote replica
    String db = "databasese";
    String username = "juansmartine";
    String password = FuryUtils.getEnv("DB_MYSQL_DESAENV04_DATABASESE_DATABASESE_WPROD");
    public ConnectionDB() throws FuryDecryptException, FuryUpdateException, FuryNotFoundAPPException {
        connect = null;
    }

    public Connection dbConnectionOpen() throws FuryDecryptException,
            FuryUpdateException, FuryNotFoundAPPException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://" + host
                + "/" + db
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=" + username
                + "&password=" + password);

        return connect;
    }

    public void dbConnectionClose() throws SQLException {
        connect.close();
    }
}
