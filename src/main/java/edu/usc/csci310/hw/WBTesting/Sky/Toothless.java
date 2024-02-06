package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

public class Toothless implements Animal {

    private int location=0;
    private int happiness = 0;
    private boolean metHiccup = false;


    public Toothless(boolean metHiccup) {
        this.metHiccup = metHiccup;
        if (metHiccup) {
            happiness+=5;
        }
    }

    @Override
    public String makeNoise() {
        StringBuilder sound = new StringBuilder("");
        if (happiness>0) {
            sound.append("drr");
        }
        for (int i=0; i<happiness; i++) {
            sound.append("r");
            if (happiness % 10 == 0) {
                sound.append(" drr");
            }
        }
        return sound.toString();
    }

    @Override
    public void move() {
        if (metHiccup) {
            location += 10;
        } else {
            location += 1;
        }
    }

    @Override
    public String eat() {
        StringBuilder meal = new StringBuilder("Ate");
        for (int i=0; i<location; i++) {
            meal.append(" fish");
            happiness++;
        }
        if (location==0) {
            meal.append(" no fish");
        } else {
            if (metHiccup) {
                meal.append(" gave all the fisheads to Hiccup because he's my bud");
                happiness++;
            }
        }
        return meal.toString();
    }

    @Override
    public int getLocation() {return location;}
    public void setLocation(int l) {location = l;}
}
