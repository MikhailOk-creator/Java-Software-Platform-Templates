package ru.rtu_mirea.practice_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping("/add")
public class AddingController {

    @GetMapping("/{first_name}/{last_name}/{team_name}/{team_date}")
    public String addTeam(@PathVariable String team_name, @PathVariable Date team_date, @PathVariable String first_name, @PathVariable String last_name){
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

        String sql = "insert into footballers (first_name, last_name, team_name, team_creationDate) values (?,?,?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Column not found");
            return "Column not found";
        }

        try {
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, team_name);
            preparedStatement.setDate(4, (java.sql.Date) team_date);
        } catch (SQLException e) {
            System.err.println("This clinic is already exists");
            return "This clinic is already exists";
        }

        System.out.println("Footballer " + first_name + " " + last_name + " enters team" + team_name);
        return "Footballer " + first_name + " " + last_name + " enters team" + team_name;
    }

}
