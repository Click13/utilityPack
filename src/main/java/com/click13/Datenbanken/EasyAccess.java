package com.click13.Datenbanken;

import java.sql.*;

public class EasyAccess {

    private static EasyAccess instanz = null;
    private Connection connection;
    private String user;
    private String password;

    private EasyAccess(String user, String password){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:file:C:/jbb/base.db;shutdown=true", user, password);
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Treiber nicht gefunden" + e.toString());
            System.err.println("Keine Treiberklasse gefunden.");
            e.printStackTrace();
        }
        this.user = user;
        this.password = password;
    }

    public synchronized void updateDatabase(String statement){
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

    public synchronized ResultSet queryDatabase(String statement){
        ResultSet set = null;
        try{
            PreparedStatement prepared = connection.prepareStatement(statement);
            set = prepared.executeQuery();
            prepared.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            connection.commit();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return set;
    }

    public synchronized void close(){
        try {
            if (!connection.isClosed()){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        instanz = null;
    }

    public static synchronized EasyAccess getInstanz(String user, String password){
        if (instanz == null){
            instanz = new EasyAccess(user, password);
            return instanz;
        }
        else{
            if (instanz.user.equals(user) && instanz.password.equals(password)){
                return instanz;
            }
            else{
                return null;
            }
        }
    }
}
