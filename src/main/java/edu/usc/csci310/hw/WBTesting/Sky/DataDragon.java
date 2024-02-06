package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

import java.io.File;
import java.sql.*;


public class DataDragon implements Animal {

    int location = 0;
    Connection c;
    int feedings = 0;
    int moves = 0;

    public DataDragon(Connection conn) throws Exception {
        try {
            c = conn;
            Statement statement = c.createStatement();
            statement.executeUpdate("create table feedings (id integer, quantity integer)");
            statement.executeUpdate("insert into feedings values(1, 4)");
            statement.executeUpdate("insert into feedings values(2, 3)");
            feedings = 2;
            statement.executeUpdate("create table movements (time integer, direction string, amount integer)");
        }
        catch (SQLException sqle) {
            System.err.println("Could not create the DataDragon");
            throw new Exception("Could not create the DataDragon");
        }
    }

    @Override
    public String makeNoise() {
        if (moves == feedings) {
            return "This is a good balance.";
        } else if (moves > feedings) {
            return "Too much exercise not enough eating";
        } else {
            return "Too much eating, not enough exercise";
        }
    }

    @Override
    public void move() {
        try {
            PreparedStatement pst = c.prepareStatement("insert into movements values(?,?,?)");
            moves++;
            pst.setInt(1, moves);
            pst.setString(2, "Onward");
            pst.setInt(3,1);
            pst.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("Could not move");
        }
    }

    @Override
    public String eat() {
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select id, quantity from feedings");
            int foodEatenSum = 0;
            while (rs.next()) {
                int mealSize = rs.getInt("quantity");
                if (mealSize > 0) {
                    foodEatenSum += mealSize;
                }
            }
            if (foodEatenSum > 20) {
                return "I'm not hungry";
            } else {
                feedings++;
                PreparedStatement pst = c.prepareStatement("insert into feedings values(?, ?)");
                pst.setInt(1, feedings);
                pst.setLong(2, Math.round(Math.random()*10));
                pst.executeUpdate();
                return "nom nom nom";
            }
        } catch (SQLException sqle) {
            return "it was not possible to eat at this time";
        }
    }

    @Override
    public int getLocation() {
        return location;
    }

    public int getMoves() {
        return moves;
    }

    public int getFeedings() {
        return feedings;
    }
}
