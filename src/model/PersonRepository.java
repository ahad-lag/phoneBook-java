package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private Connection connection;

    public PersonRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Person> getList(){

        try(
            Statement statement = this.connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * From " + TableNames.TABLE_PEOPLE)
        )
        {
            List<Person> People = new ArrayList<>();

            while (results.next()) {
                Person person = new Person();
                person.setId(results.getInt(TableNames.COLUMN_PEOPLE_ID));
                person.setName(results.getString(TableNames.COLUMN_PEOPLE_NAME));
                person.setFamily(results.getString(TableNames.COLUMN_PEOPLE_FAMILY));
                People.add(person);
            }
            return People;

        } catch (SQLException e) {
            System.out.println("Error in Execute Query " + e.getMessage());
            return null;
        }
    }
}
