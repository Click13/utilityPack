package Datenbanken;

import java.sql.*;

public class EasyAccess {

    private Connection connection;

    public EasyAccess(String user, String password){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:file:C:/jbb/base.db;shutdown=true", user, password);
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Treiber nicht gefunden" + e.toString());
            System.err.println("Keine Treiberklasse gefunden.");
        }
    }

    public void updateDatabase(String statement){
        try {
            PreparedStatement prepared = connection.prepareStatement(statement);
            prepared.executeUpdate();
            prepared.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            connection.commit();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public ResultSet queryDatabase(String statement){
        ResultSet set = null;
        try{
            PreparedStatement prepared = connection.prepareStatement(statement);
            set = prepared.executeQuery();
            prepared.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return set;
    }

}
