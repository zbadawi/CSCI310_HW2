package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

public class Hiccup implements Animal {

    private int location=0;
    private int weight=0;
    private int age=0;

    public Hiccup(int birthweight, int age) throws Exception {
        if (birthweight>2 && age == 0) {
            throw new Exception("Not correct, Hiccup was tiny when he was born.");
        } else {
            this.weight= birthweight;
            this.age = age;
        }
    }

    @Override
    public String makeNoise() {
        String phrase = "";
        if (age<7) {
            phrase = "Ah, come on. Let me out, please? I need to make my mark!";
        } if (age<8) {
            phrase = "Oh, I hit it! YES, I HIT IT! Did anybody see that?!";
        } if (age<9) {
            phrase = "Toothless? I could've sworn you had... teeth.";
        } if (age<10) {
            phrase = "... I could get used to it.";
        }
        return phrase;
    }

    @Override
    public void move() {
        if (age<10) {
            location+=2;
        } else {
            location+=1;
        }
    }

    @Override
    public String eat() {
        weight++;
        if (weight>10) {
            return "Ate enough.";
        } else {
            return "...the village could do with a little less feeding, don't you think?";
        }
    }

    @Override
    public int getLocation() {return location;}
    public void setLocation(int l) {location = l;}

    public void setAge(int a) {age=a;}
    public int getAge() {return age;}
}
