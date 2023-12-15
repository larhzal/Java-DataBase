package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DeviseDao {
    String user, password, host, db_name;
    Integer port;
    Connection conx;

    public DeviseDao(){
        user = "root";
        password = "gazel";
        port = 3306;
        host = "localhost";
        db_name = "TP10";
        String url = "jdbc:mysql://"+host+":"+port+"/"+db_name;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conx = DriverManager.getConnection(url, user, password);
            System.out.println("OK");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
        }
    }

    public Vector<Devise> getAllDevise(){
        Vector<Devise> list = new Vector<Devise>();
        Statement statemat;
        ResultSet resultSet;
        try{
            statemat = conx.createStatement();
            resultSet = statemat.executeQuery("select * from T_Devise");
            while (resultSet.next()) {
                String devise = resultSet.getString("devise");
                Double taux = resultSet.getDouble("taux");
                Devise dev = new Devise(devise,taux);
                list.add(dev);
                
            }
            
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
       }
       return list;
    
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Connection getConx() {
        return conx;
    }

    public void setConx(Connection conx) {
        this.conx = conx;
    }

}

