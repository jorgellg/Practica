/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Person;
import utng.util.UtilDB;

/**
 *
 * @author Jorge
 */
public class PersonDAOImp implements PersonDAO{
        private Connection connection;
    
    public PersonDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarPerson(Person person) {
                try {
            String query = "INSERT INTO persons(\n" +
"	 last_seen, \"last_clothing\", \"comments\")\n" +
"	VALUES ( ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);       
            ps.setString(1, person.getLastSeen());
            ps.setString(2, person.getLastClothing());
            ps.setString(3, person.getComments());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void cambiarPerson(Person person) {
        try {
            String query = "UPDATE persons SET last_seen=?, \"last_clothing\"=?, \"comments\"=?\n" +
"	WHERE p_uuid=?";
  
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, person.getLastSeen());
            ps.setString(2, person.getLastClothing());
            ps.setString(3, person.getComments());
            ps.setInt(4, person.getpUuid());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> desplegarPerson() {
        List<Person> persons = new ArrayList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persons");
            while (rs.next()) {
                Person person = new Person (rs.getInt("p_uuid"),
                        rs.getString("last_seen"),
                        rs.getString("last_clothing"),
                        rs.getString("comments"));

                persons.add(person);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person elegirPerson(int pUuid) {
                      Person person=null;
        try {
            String query = " SELECT * FROM persons WHERE p_uuid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, pUuid);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  person = new Person(
                        rs.getInt("p_uuid"),
                        rs.getString("last_seen"),
                        rs.getString("last_clothing"),
                        rs.getString("comments"));
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void borrarPerson(int pUuid) {
                try {
            String query = "DELETE FROM persons WHERE "
                    + " p_uuid=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, pUuid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 




    
    
}
