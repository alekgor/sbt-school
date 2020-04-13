package com.sbt;

import java.sql.*;

public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/JDBC";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден JDBC драйвер");
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * from animal where id = '2'");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("animal_name");
                String desc = resultSet.getString("animal_desc");
                System.out.println(id + " : " + name + " : " + desc);
            }


//            System.out.println(resultSet.getByte(1));
//            statement.addBatch("INSERT INTO animal(animal_name,animal_desc) VALUES ('frog','frog_desc')");
//            statement.addBatch("INSERT INTO animal(animal_name,animal_desc) VALUES ('bird','bird_desc')");
//            statement.addBatch("INSERT INTO animal(animal_name,animal_desc) VALUES ('parrot','parrot_desc')");
//            statement.executeBatch();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось получить connection");
        }
    }
}
