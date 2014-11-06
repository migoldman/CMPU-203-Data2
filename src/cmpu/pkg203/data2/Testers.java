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
    Randomness<D> rand;
    static Random randNum = new Random();
    static Multiset MT = empty();

    static int cardAddF1 = 0, 
            cardAddF2 = 0,
            cardRemoveF1 = 0,
            cardRemoveF2 = 0,
            memberAddF = 0,
            memberDiffF = 0,
            memberUnionF1 =0,
            memberUnionF2 =0,
            memberInterF1 = 0,
            memberInterF2 = 0;
    
    //P is for PROPERTY
    //B is for FAILS
    
    Testers(Randomness<D> rand) {
        this.rand = rand;
    }
    
    //Creates an empty multiset
    public static Multiset empty() {
        return new Leaf();
    }
    
    //Creates a random int from min to max
    public static int randomInt() {
        return randNum.nextInt((50 - 0) + 1) + 0;
    }
    
    public Multiset<D> RMS(int n) {
        if(n <= 0) {
            return empty();
        } else {
            return RMS(-1).add(rand.randomInput(),randomInt());
        }
    }
    
    public void cardAddP() {
        for(int i = 0; i < 1000; i++) {
            int length = randomInt();
            Multiset bag = RMS(length);
            int bagCard = bag.cardinality();
            if(bag.add(rand.randomInput()).cardinality() != bagCard +1) {
                cardAddF1++;
                
            }
            else if(bag.add(rand.randomInput()).cardinality() == bagCard) {
                cardAddF2++;
            }
        }
    }
        
    public void cardRemoveP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bag = RMS(length);
            int bagCard = bag.cardinality();
            int newCard = bag.remove(elt).cardinality();
            if(bag.multiplicity(elt) >= 1 && newCard != bagCard-1) {
                cardRemoveF1++;
            }
            else if(bag.multiplicity(elt) == 0 && bagCard != newCard) {
                cardRemoveF2++;
            }
        }
    }
    
    public void memberAddP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bag = RMS(length);
            if(!bag.add(elt).member(elt)) {
                memberAddF++;
            }
        }
    }
    
    public void memberDiffP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bagA = RMS(length);
            Multiset bagB = RMS(length);
            if(bagA.diff(bagB).member(elt) && !bagB.member(elt)) {
                memberDiffF++;
            }
        }
    }
    
    public void memberUnionP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bagA = RMS(length);
            Multiset bagB = RMS(length);
            Multiset bagU = bagA.union(bagB);
            if(bagU.member(elt) && !(bagA.member(elt) || bagB.member(elt))) {
                memberUnionF1++;
            }
            else if(bagU.multiplicity(elt) != (bagA.multiplicity(elt)+bagB.multiplicity(elt))) {
                memberUnionF2++;
            }
        }
    }
    
    public void memberInterP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bagA = RMS(length);
            Multiset bagB = RMS(length);
            Multiset bagI = bagA.inter(bagB);
            if(bagI.member(elt) && (!bagA.member(elt) || !bagB.member(elt))) {
                memberInterF1++;
            }
            else if(bagI.multiplicity(elt) != bagA.multiplicity(elt)) {
                if(bagI.multiplicity(elt) != bagB.multiplicity(elt)) {
                    memberInterF2++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Testers randomInt = new Testers(new RandomInt());
        Testers randomString = new Testers(new RandomString());
        
        randomInt.cardAddP();
        randomString.cardAddP();
        System.out.println("cardAddF1 triggered " + cardAddF1 + " times");
        System.out.println("cardAddF2 triggered " + cardAddF2 + " times");
        
        randomInt.cardRemoveP();
        randomString.cardRemoveP();
        System.out.println("cardRemoveF1 triggered " + cardRemoveF1 + " times");
        System.out.println("cardRemoveF2 triggered " + cardRemoveF2 + " times");
        
        randomInt.memberDiffP();
        randomString.memberDiffP();
        System.out.println("memberAddF triggered " + memberAddF + " times");
        System.out.println("memberDiffF triggered " + memberDiffF + " times");
        
        randomInt.memberUnionP();
        randomString.memberUnionP();;
        System.out.println("memberUnionF1 triggered " + memberUnionF1 + " times");
        System.out.println("memberUnionF2 triggered " + memberUnionF2 + " times");

        randomInt.memberInterP();
        randomString.memberInterP();
        System.out.println("memberInterF1 triggered " + memberInterF1 + " times");
        System.out.println("memberInterF2 triggered " + memberInterF2 + " times");

        //Static variables for initial testing
//        Multiset MS1 = MT.add(5);
//        Multiset MS2 = MS1.add(4);
//        Multiset MS3 = MS2.add(5);
//        
//        Multiset C1 = MT.add('t');
//        Multiset S1 = MT.add("foo").add("foo");
//        Multiset S2 = S1.add("bar");
//        Multiset S3 = S2.remove("foo");
//        
//        
//       
//        System.out.println(1 + " is " + C1.multiplicity('t'));
//        System.out.println(2 + " is " + S2.multiplicity("foo"));
//        System.out.println(2 + " is " + S2.multiplicity("foo"));
//        System.out.println(1 + " is " + S3.multiplicity("foo"));
//        System.out.println();
        //System.out.println(RMSs(20).sequence().toString());
        
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

    }
}

