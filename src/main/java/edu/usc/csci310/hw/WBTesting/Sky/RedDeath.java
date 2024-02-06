package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

public class RedDeath implements Animal {

    private int location=0;
    private int sheep=0;
    private int dragonCount=100;

    public RedDeath(int sheep) {
        this.sheep = sheep;
    }

    @Override
    public String makeNoise() {
        StringBuilder noise = new StringBuilder("Hmm");
        if (location>10) {
            noise = new StringBuilder("Rarrrr!");
        } else {
            int count = dragonCount - sheep;
            for (int i = 0; i < count; i++) {
                noise.append("m");
                dragonCount++;
                sheep+=2;
            }
        }
        return noise.toString();
    }

    @Override
    public void move() {
        if(dragonCount==0) {
            location+=1;
        }
    }

    @Override
    public String eat() {
        if (sheep==0) {
            dragonCount--;
            return "Ate a dragon.";
        } else {
            if (sheep>=2) {
                sheep -= 2;
                return "Ate some sheep.";
            } else {
                sheep--;
                dragonCount--;
                return "Ate sheep and a dragon";
            }
        }
    }

    @Override
    public int getLocation() {return location;}
    public void setLocation(int l) {location = l;}
}
