package ru.rtu_mirea.practice_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("/delete")
public class DeleteController {

    @GetMapping("/all")
    public String deleteFootballers() throws SQLException {
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

        String sql = "delete from footballers;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("All clinics removed");
        return "All clinics removed";
    }

    @GetMapping("/{nameF}")
    public String deleteFootballer(@PathVariable String nameF) throws SQLException {
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

        String sql = "delete from footballers where ='"+ nameF +"';";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);System.out.println("Executed");
        return "Executed";
    }
}
