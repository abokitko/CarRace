package com.labs.classes;

import com.labs.classes.Engine.Engine;
import com.labs.classes.Transport.Car;
import com.labs.classes.Transport.Transport;
import com.labs.classes.Wheels.Wheels;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    private static final String user = "root";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/race?useUnicode=true&serverTimezone=UTC";
    private static final String password = "12345";
    private static final String wheelsTableName = "wheels";
    private static final String enginesTableName = "engines";
    private static final String carsTableName = "cars";

    private static Connection con;
    private static Statement stmt;

    public SQL(){

    }

    private static void executeQuery(String query){
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }finally {
            try {con.close();} catch (SQLException se){ }
            try {stmt.close();} catch (SQLException se){ }
        }
    }

    private static void createWheelsTableIfNotExists(){
        String query = String.format("CREATE TABLE IF NOT EXISTS %s (unique_id INTEGER PRIMARY KEY, wheels_friction DOUBLE, radius INTEGER)", wheelsTableName);
        executeQuery(query);
    }

    private static void createEngineTableIfNotExists(){
        String query = String.format("CREATE TABLE IF NOT EXISTS %s (unique_id INTEGER PRIMARY KEY, horse_powers INTEGER, wheels_moment INTEGER)", enginesTableName);
        executeQuery(query);
    }

    private static void createCarsTableIfNotExists(){
        String query = "CREATE TABLE IF NOT EXISTS " + carsTableName
                + " (unique_id INTEGER PRIMARY KEY,"
                + " mass INTEGER,"
                + " max_speed INTEGER,"
                + " friction INTEGER,"
                + " wheels_id INTEGER,"
                + " engine_id INTEGER,"
                + " FOREIGN KEY (wheels_id) REFERENCES " + wheelsTableName + "(unique_id),"
                + " FOREIGN KEY (engine_id) REFERENCES " + enginesTableName + "(unique_id));";
        executeQuery(query);
    }

    public static void insertWheels(Wheels wheels){
        createWheelsTableIfNotExists();
        String query = String.format("INSERT INTO %s (unique_id, wheels_friction, radius) VALUE (%d, %s, %d);", wheelsTableName, wheels.getUniqueID(), wheels.getWheelsFriction() * 1.0, wheels.getRadius());
        System.out.println(query);
        executeQuery(query);
    }

    public static void insertEngine(Engine engine){
        createEngineTableIfNotExists();
        String query = String.format("INSERT INTO %s (unique_id, horse_powers, wheels_moment) VALUES (%d, %d, %d);", enginesTableName, engine.getUniqueID(), engine.getHP(), engine.getWM());
        executeQuery(query);
    }

    public static void insertCar(Transport car) {
        int unique_id = car.getUniqueID();
        try {
            insertWheels(car.getWheels());
            insertEngine(car.getEngine());
            createCarsTableIfNotExists();
            String query = String.format("INSERT INTO %s (unique_id, mass, max_speed, friction, wheels_id, engine_id) VALUES (%s, %s, %s, %s, %s, %s);",
                    carsTableName, unique_id, car.getMass(), car.getMax_speed(), car.getFriction()*1.0, car.getWheels().getUniqueID(), car.getEngine().getUniqueID());
            System.out.println(query);
            executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
