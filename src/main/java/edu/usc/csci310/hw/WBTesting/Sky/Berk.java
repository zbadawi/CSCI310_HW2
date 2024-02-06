package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Set;

public class Berk {
    public static void main(String[] args) throws Exception {
        Set<Animal> animals = new HashSet<Animal>();

        Connection conn = DriverManager.getConnection("jdbc:sqlite:dataDragon.db");
        Animal a = new DataDragon(conn);
        animals.add(a);
        Animal b = new Hiccup(10, 8);
        animals.add(b);
        Animal c = new RedDeath(5);
        animals.add(c);
        Animal d = new Toothless(false);
        animals.add(d);
        Animal e = new Stoick(5);
        animals.add(e);

        for (Animal f : animals) {
            f.eat();
            f.makeNoise();
            f.move();
        }

        System.out.println("This is Berk. It's twelve days North of hopeless, and a few degrees South of freezing to death. It's located solidly on the Meridian of Misery.");
    }
}
