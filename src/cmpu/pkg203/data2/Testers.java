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
import java.util.Arrays;
import java.util.Random;

public class Testers<D extends Comparable> {
    static Random rand = new Random();
    static int randomInt = randomInt(0, 20);
    static Multiset branch = RMS(0, 20, 20);
    static Multiset MT = empty();

    
    //Creates an empty multiset
    public static Multiset empty() {
        return new Leaf();
    }
    
    //Creates a random int from min to max
    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
    
    public static String randomString() {
        int random = randomInt(0, 10);
        char[] stringIn = new char[random];
        String characters = "ABCDEFGHIJK";
        for(int i = 0; i < random; i++) {
            stringIn[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        return Arrays.toString(stringIn);
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
    
    public static void cardSeqP() {
        for (int i = 0; i < 50; i++) {
            if(branch.cardinality() != branch.sumIt()) {
                System.out.println("Error 0");
            }
        }
    }
    
    //Cardinality Add Principle
        //holder.add(randInt).cardinality <==> holder.cardinality()++
            //Since we allow duplicates, it should always go up    
        public static void cardAddP() {
            for(int i = 0; i < 50; i++) {
                Multiset holder = RMS(0, 20, 20);
                int randInt = randomInt(0, 20);
                int temp = holder.cardinality();
                if(holder.add(randInt).cardinality() == temp+1)
                {
                }
                else {
                    System.out.println("Something went wrong in cardAddP");
                }
            }
        }
    
    
    public static void main(String[] args) {
        //Static variables for initial testing
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
        System.out.println();
        
        //Actual tests
        System.out.println("checking to see multiplicity of " +randomInt + ""
                + "in " + branch.sequence().toString() + " = " + branch.multiplicity(randomInt));        
        System.out.println(randomString());
        System.out.println();
        System.out.println("BST card");
        System.out.println(branch.cardinality());
        System.out.println("Seq toString");
        System.out.println(branch.sequence().toString());
        System.out.println("Seq size");
        System.out.println(branch.sumIt());
        cardSeqP();
        cardAddP();
    }
}
