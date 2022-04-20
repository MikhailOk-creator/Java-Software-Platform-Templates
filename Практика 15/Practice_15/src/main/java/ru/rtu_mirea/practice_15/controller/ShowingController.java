package ru.rtu_mirea.practice_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @GetMapping("/all")
    public String allShow() throws SQLException {
        System.out.println("All teams show");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    DBConfig.DB_URL,
                    DBConfig.DB_USERNAME,
                    DBConfig.DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("No connection to database");
            System.out.println(e.getMessage());
            return "No connection to database";
        }

        String sql = "SELECT * from footballers;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while(resultSet.next()) {
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            String team_name = resultSet.getString(3);
            Date team_date = resultSet.getDate(4);
            answer += first_name + " : " + last_name + " : " + team_name + " : " + team_date + '\n';
        }
        return answer;
    }

    @GetMapping("/{nameF}")
    public String showFootballer(@PathVariable String nameF) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    DBConfig.DB_URL,
                    DBConfig.DB_USERNAME,
                    DBConfig.DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("No connection to database");
            System.out.println(e.getMessage());
            return "No connection to database";
        }

        String sql = "SELECT * from footballers where team_name='" + nameF + "';";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while(resultSet.next()) {
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            String team_name = resultSet.getString(3);
            Date team_date = resultSet.getDate(4);
            answer += first_name + " : " + last_name + " : " + team_name + " : " + team_date + '\n';
        }
        return answer;
    }
}
