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

public class RandomInt implements Randomness<Integer> {
    
    public Integer randomInput() {
        Random rand = new Random();
        return rand.nextInt((50 - 0) + 1) + 0;
    }
}
