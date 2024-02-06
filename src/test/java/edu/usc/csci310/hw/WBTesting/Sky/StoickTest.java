package edu.usc.csci310.hw.WBTesting.Sky;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoickTest {
    @Test
    public void testMakeNoise0Fed() { //testing make noise when fedlevel = 0
        Stoick s = new Stoick(0);
        String noise = s.makeNoise(); //fedlevel = 0 --> "We're Vikings. It's an occupational hazard."
        assertEquals("We're Vikings. It's an occupational hazard.", noise);
    }

    @Test
    public void testMakeNoise5Fed() { //testing make noise when fedlevel = 5
        Stoick s = new Stoick(5);
        String noise = s.makeNoise(); //fedlevel = 5 --> "Well, I can show my face in public again"
        assertEquals("Well, I can show my face in public again", noise);
    }

    @Test
    public void testMakeNoiseDef() { //testing make noise default behavior
        Stoick s = new Stoick(3);
        String noise = s.makeNoise(); //fedlevel = 3 --> "Train hard."
        assertEquals("Train hard.", noise);

        Stoick ss = new Stoick(7);
        noise = ss.makeNoise(); //fedlevel = 7 --> "Train hard."
        assertEquals("Train hard.", noise);
    }

    @Test
    public void testMoveGreat10Fed() { //testing move when fedlevel > 10 && hunger < 10
        Stoick s = new Stoick(15); //fedlevel = 15
        int init = s.getLocation(); // loc = 0
        String ate = s.eat(); //hunger = 0 --> "Ate nothing."
        assertEquals("Ate nothing.", ate); //checking initial hunger
        s.move(); // loc = 1, hunger = 1
        assertEquals(init + 1, s.getLocation()); //checking location increment
        ate = s.eat(); //hunger = 1 --> "Ate  mutton", hunger = 0, fed = 2
        assertEquals("Ate  mutton", ate); //checking hunger increment
    }

    @Test
    public void testMoveGreat10Hunger() { //testing move when hunger > 10 && fedlevel <10
        Stoick s = new Stoick(0); //fedlevel = 0
        int init = s.getLocation(); // loc = 0
        String ate = s.eat(); //hunger = 0 --> "Ate nothing."
        assertEquals("Ate nothing.", ate); //checking initial hunger
        s.move(); // loc = 12, hunger = 11
        assertEquals(12, s.getLocation()); //checking location increment
        ate = s.eat(); //hunger = 11 --> "Ate  mutton with ale and more mutton..", hunger = 8, fed = 5
        assertEquals("Ate  mutton with ale and more mutton..", ate); //checking hunger increment
        String noise = s.makeNoise(); //fed = 5 --> "Well, I can show my face in public again"
        assertEquals("Well, I can show my face in public again", noise); //checking fed
    }

    @Test
    public void testEat2Hunger() { //testing eat with hunger = 2
        Stoick s = new Stoick(0); //fedlevel = 0, hunger = 0, loc = 0
        s.move(); // loc = 12, hunger = 11
        String ate = s.eat(); //hunger = 11 --> "Ate  mutton with ale and more mutton..", hunger = 8, fed = 5
        ate = s.eat(); //hunger = 8 --> "Ate  mutton with ale and more mutton..", hunger = 5, fed = 10
        ate = s.eat(); //hunger = 5 --> "Ate  mutton with ale and more mutton..", hunger = 2, fed = 15
        ate = s.eat(); //hunger = 2 --> "Ate  mutton with ale.", hunger = 0, fed = 18
        assertEquals("Ate  mutton with ale.", ate);
        ate = s.eat(); //"Ate nothing"
        assertEquals("Ate nothing.", ate);
    }
}
