/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpu.pkg203.data2;

/**
 *
 * @author michaelgoldman
 */
import java.util.Random;

public class RandomString implements Randomness<String> {
    public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static int randomInt() {
        Random rand = new Random();
        int randomInt = rand.nextInt((25 - 1) + 1) + 1;
        return randomInt;
    }
    
    public String randomInput() {
        StringBuffer randString = new StringBuffer();
        
        for(int i = 0; i < randomInt(); i++) {
            int randInt = randomInt();
            char randChar = CHARS.charAt(randInt);
            randString.append(randChar);
        }
        return randString.toString();
    }
}
