package edu.usc.csci310.hw.WBTesting.Sky;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToothlessTest {
    @Test
    public void testMoveTrue() {
        Toothless t = new Toothless(true);
        int initLoc = t.getLocation();
        t.move();
        assertEquals(initLoc + 10, t.getLocation());
    }

    @Test
    public void testMoveFalse() {
        Toothless t = new Toothless(false);
        int initLoc = t.getLocation();
        t.move();
        assertEquals(initLoc + 1, t.getLocation());
    }

    @Test
    public void testMakeNoisePosHappiness() { //make noise with happiness > 0
        Toothless t = new Toothless(true); //met hiccup --> +5 happiness
        String noise = t.makeNoise();
        assertEquals("drrrrrrr", noise);
    }

    @Test
    public void testMakeNoiseNoHappiness() { //make noise with happiness = 0
        Toothless t = new Toothless(false); //NOT met hiccup --> 0 happiness
        String noise = t.makeNoise();
        assertEquals("", noise);
    }

    @Test
    public void testMakeNoiseTensHappiness() { //make noise with happiness multiple of ten
        Toothless t = new Toothless(false); //NOT met hiccup --> 0 happiness
        t.setLocation(20);
        t.eat(); //eating at loc=20 inadvertently increases happiness to 20
        String noise = t.makeNoise();
        assertEquals("drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drrr drr", noise);
    }

    @Test
    public void testEat0Loc() { //testing eat with loc = 0
        Toothless t = new Toothless(false); //loc = 0
        String ate = t.eat();
        assertEquals("Ate no fish", ate);
    }

    @Test
    public void testEatLoc() { //testing eat with loc = 0
        Toothless t = new Toothless(false); //loc = 0, happiness = 0
        t.setLocation(5);
        String noise = t.makeNoise(); //happiness = 0 --> "" noise
        assertEquals("", noise); //noise = ""
        String ate = t.eat();
        assertEquals("Ate fish fish fish fish fish", ate);
        noise = t.makeNoise(); //happiness = 5 --> "drrrrrrr" noise
        assertEquals("drrrrrrr", noise); //noise = "drrrrrrr"
    }

    @Test
    public void testEatLocHiccup() { //testing eat with loc = 0 and met hiccup
        Toothless t = new Toothless(true); //loc = 0, happiness = 5
        t.setLocation(5); //loc = 5
        String noise = t.makeNoise(); //happiness = 5 --> "drrrrrrr" noise
        assertEquals("drrrrrrr", noise); //noise = "drrrrrrr"
        String ate = t.eat(); //loc = 5, happiness = 11 (5 for fish, 1 for hiccup)
        assertEquals("Ate fish fish fish fish fish gave all the fisheads to Hiccup because he's my bud", ate);
        noise = t.makeNoise(); //happiness = 11 --> noise = "drrrrrrrrrrrrr"
        assertEquals("drrrrrrrrrrrrr", noise); //noise = "drrrrrrrrrrrrr"
    }
}
