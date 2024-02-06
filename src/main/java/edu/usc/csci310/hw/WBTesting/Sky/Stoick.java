package edu.usc.csci310.hw.WBTesting.Sky;

import edu.usc.csci310.hw.WBTesting.Animal;

public class Stoick implements Animal {

    private int location=0;
    private int hungerLevel=0;
    private int fedLevel=0;

    public Stoick(int fedLevel) {
        this.fedLevel=fedLevel;
    }

    @Override
    public String makeNoise() {
        String message = "";
        switch(fedLevel) {
            case 0:
                message = "We're Vikings. It's an occupational hazard.";
                break;
            case 5:
                message = "Well, I can show my face in public again";
                break;
            default:
                message = "Train hard.";
        }
        hungerLevel++;
        return message;
    }

    @Override
    public void move() {
        boolean canPassThroughDoor = true;
        while (canPassThroughDoor) {
            location++;
            if (fedLevel > 10) {
                canPassThroughDoor = false;
            }
            if (hungerLevel>10) {
                break;
            }
            hungerLevel++;
        }
    }

    @Override
    public String eat() {
        String meal = "Ate ";
        if (hungerLevel>0) {
            meal+=" mutton";
            hungerLevel--;
            fedLevel+=2;
            if (hungerLevel>0) {
                meal+=" with ale";
                hungerLevel--;
                fedLevel++;
                if (hungerLevel>0) {
                    meal+=" and more mutton.";
                    hungerLevel--;
                    fedLevel+=2;
                }
                meal+=".";
            }
        } else {
            meal += "nothing.";
        }
        return meal;
    }

    @Override
    public int getLocation() {return location;}
    public void setLocation(int l) {location = l;}
}
