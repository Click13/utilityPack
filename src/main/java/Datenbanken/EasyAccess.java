package Datenbanken;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class EasyAccess {
    private String host;
    private String user;
    private String password;
    private String database;
    private String command;
    private Connection dbConnection;
    private Statement sqlStatement;
    private ResultSet resultSet;

    public EasyAccess(String host, String database, String user, String password){
        final String DRIVER = "";// INSERT DRIVER HERE!!!!!!!!!!!!!!!!!!!!

        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;

        try {
            Class.forName(DRIVER);//Beim Laden der Treiberklasse, registriert diese sich beim Treibermanager.
        }
        catch (ClassNotFoundException e){
            System.out.println("Treiber nicht gefunden" + e.toString());
        }
    }

    public boolean openConnection(){
        String url = host + "/" + database;
        boolean connected = false;

        try{
            dbConnection = DriverManager.getConnection(url,user,password);
            connected = true;
        }
        catch (SQLException e){
            System.out.println("Verbindung fehlgeschlagen!");
            System.out.println(e.toString());
        }
        return connected;
    }

    public void closeConnection(){
        if (resultSet != null){
            try {
                resultSet.close();
            }
            catch (SQLException e){
                System.out.println("Die belegten Ressourcen konnten nicht freigegeben werden!");
                System.out.println(e.toString());
            }
        }

        if (sqlStatement != null){
            try {
                sqlStatement.close();
            }
            catch (SQLException e){
                System.out.println("Die belegten Ressourcen konnten nicht freigegeben werden!");
                System.out.println(e.toString());
            }
        }

        if (dbConnection != null){
            try {
                dbConnection.close();
            }
            catch (SQLException e){
                System.out.println("Die belegten Ressourcen konnten nicht freigegeben werden!");
                System.out.println(e.toString());
            }
        }
    }

    public ResultSet executeQuery(String pSql){
       ResultSet resultSet = null;

       try {
           sqlStatement =dbConnection.createStatement();
           resultSet = sqlStatement.executeQuery(pSql);
           this.resultSet = resultSet;
       }
       catch (SQLException e){
           System.out.println("Datenbank-Abfrage fehlgeschlagen: " + e.toString());
           System.out.println("SQL-Anweisung: " + pSql);
       }
       return resultSet;
    }

    public boolean executeUpdate(String pSql){
        boolean executed = false;

        try {
            sqlStatement = dbConnection.createStatement();
            sqlStatement.executeUpdate(pSql);
            executed = true;
        }
        catch (SQLException e){
            System.out.println("Datenbank-Aktualisierung fehlgeschlagen: " + e.toString());
            System.out.println("SQL-Anweisung: " + pSql);
        }

        return executed;
    }
}
