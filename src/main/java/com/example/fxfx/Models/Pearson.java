package com.example.fxfx.Models;

import com.example.fxfx.DataBase.DB_connector;
import com.example.fxfx.Utiles.PearsonUtil;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class Pearson {
    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private String gender;
    private static PearsonUtil bu;
    private static final Statement statement = DB_connector.getStatement();

    public Pearson(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public Pearson(int id ,String firstName, String lastName, int age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public void create() throws SQLException {
        String query = String.format(
                "INSERT INTO pearsons.Pearson (firstName, lastName, ageName, gender) " +
                        "VALUES ('%s', '%s', %d, '%s');",
                firstName, lastName, age, gender
        );
        statement.executeUpdate(query);
    }
    public boolean delete() throws SQLException {
        String query = "delete from Pearson where id = " + id;
        return statement.executeUpdate(query) == 1;
    }

    public static Collection<Pearson> get() throws SQLException {
        String sql = "SELECT * from Pearson";
        ResultSet rs = statement.executeQuery(sql);
        List<Pearson> pearsons = new ArrayList<>();
        while (rs.next()){
            pearsons.add(new Pearson(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getInt("ageName"),
                    rs.getString("gender")
            ));
        }
        return pearsons;
    }
    public void update(){
        String sql = String.format("UPDATE Pearson SET firstName = '%s', lastName = '%s', ageName = %d ,gender = '%s' WHERE id = %d "
                , this.firstName, this.lastName, this.age,this.gender, this.id);
        try {
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
