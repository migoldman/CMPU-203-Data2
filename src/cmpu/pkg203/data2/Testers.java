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
    static Multiset branch = RMSi(0, 20, 20);
    static Multiset MT = empty();

    
    //Creates an empty multiset
    public static Multiset empty() {
        return new Leaf();
    }
    
    //Creates a random int from min to max
    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
    
    //Prints out a random letter
    public static char randomString() {
        String characters = "ABCDEFGHIJK";
        return characters.charAt(rand.nextInt(characters.length()));
    }
    
    //Creates a random Multiset (RMSi) with a max length of maxlen, data ranging
        //from min to max
    public static Multiset RMSi(int min, int max, int maxlen) {
        if(maxlen > 0) {
            return RMSi(min, max, (maxlen-1)).add(randomInt(min,max));
        }
        else {
            return new Leaf();
        }
    }
    
    //Creates a random Multiset (RMSs) with a max length of maxlen, ranging from 
        //A - K
    public static Multiset RMSs(int min, int max, int maxlen) {
        int random = randomInt(0, 20);
        Multiset temp = MT;
        for(int i = 0; i < random; i++) {
            temp.add(randomString());
        }
        return temp;
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
                Multiset holder = RMSi(0, 20, 20);
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
//        Multiset MS1 = MT.add(5);
//        Multiset MS2 = MS1.add(4);
//        Multiset MS3 = MS2.add(5);
//        
//        Multiset C1 = MT.add('t');
//        Multiset S1 = MT.add("foo");
//        Multiset S2 = S1.add("bar");
//        
//        
//        System.out.println("Cardinality tests");
//        System.out.println(0 + " is " + MT.cardinality());
//        System.out.println(1 + " is " + MS1.cardinality());
//        System.out.println(2 + " is " + MS2.cardinality());
//        System.out.println(2 + " is " + MS3.cardinality());
//        System.out.println(1 + " is " + C1.cardinality());
//        System.out.println(1 + " is " + C1.multiplicity('t'));
//        System.out.println(2 + " is " + S2.cardinality());
//        System.out.println(1 + " is " + S2.multiplicity("foo"));
//        System.out.println(0 + " is " + S2.multiplicity("this should be 0"));
//        System.out.println();
        
        System.out.println(randomString());
        System.out.println(RMSi(0,20,20).sequence().toString());
        System.out.println(RMSs(0,20,20).sequence().toString());
        
        //Actual tests
//        System.out.println("checking to see multiplicity of " +randomInt + ""
//                + "in " + branch.sequence().toString() + " = " + branch.multiplicity(randomInt));        
//        System.out.println(randomString());
//        System.out.println();
//        System.out.println("BST card");
//        System.out.println(branch.cardinality());
//        System.out.println("Seq toString");
//        System.out.println(branch.sequence().toString());
//        System.out.println("Seq size");
//        System.out.println(branch.sumIt());
        cardSeqP();
        cardAddP();
    }
}
