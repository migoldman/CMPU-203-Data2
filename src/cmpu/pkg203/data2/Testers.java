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

public class Testers<D extends Comparable> {
    static Random rand;
    
    //Creates an empty multiset
    public static Multiset empty() {
        return new Leaf();
    }
    
    //Creates a random int from min to max
    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
    
    //Creates a random Multiset (RMS) with a max length of maxlen, data ranging
        //from min to max
        //If there are duplicates, it will add it to the counter of the data
    public static Multiset RMS(int min, int max, int maxlen) {
        if(maxlen > 0) {
            return RMS(min, max, (maxlen-1)).add(randomInt(min,max));
        }
        else {
            return new Leaf();
        }
    }
    
//    public static void RMStester() {
//        for(int i = 0; i < 50; i++) {
//            
//        }
//    }
    
    public static void cardAddP() {
        for(int i = 0; i < 50; i++) {
            Multiset holder = RMS(0, 10, 20);
            int randInt = randomInt(0,10);
            int holderCard = holder.cardinality();
            if(holder.add(randInt).cardinality() == holderCard+1) {
                if(!holder.member(randInt)) {
                    System.out.println("Error 0");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        //Static variables for initial testing
        Multiset MT = empty();
        Multiset MS1 = MT.add(5);
        Multiset MS2 = MS1.add(4);
        Multiset MS3 = MS2.add(5);
        
        Multiset C1 = MT.add('t');
        Multiset S1 = MT.add("foo");
        Multiset S2 = S1.add("bar");
        
        System.out.println("Cardinality tests");
        System.out.println(0 + " is " + MT.cardinality());
        System.out.println(1 + " is " + MS1.cardinality());
        System.out.println(2 + " is " + MS2.cardinality());
        System.out.println(2 + " is " + MS3.cardinality());
        System.out.println(1 + " is " + C1.cardinality());
        System.out.println(1 + " is " + C1.multiplicity('t'));
        System.out.println(2 + " is " + S2.cardinality());
        System.out.println(1 + " is " + S2.multiplicity("foo"));
        System.out.println(0 + " is " + S2.multiplicity("this should be 0"));
    }
}
