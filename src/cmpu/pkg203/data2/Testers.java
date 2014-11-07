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
    Randomness<D> rand;
    static Random randNum = new Random();
    static Multiset MT = empty();

    static int cardAddF1 = 0, 
            cardAddF2 = 0,
            cardRemoveF1 = 0,
            cardRemoveF2 = 0,
            cardRemoveF3 = 0,
            memberAddF = 0,
            memberDiffF = 0,
            memberUnionF1 =0,
            memberUnionF2 =0,
            memberInterF1 = 0,
            memberInterF2 = 0,
            isEmptyF1 = 0,
            isEmptyF2 = 0,
            subsetUnionF= 0,
            subsetEqualF = 0,
            subsetInterF = 0,
            cardSumItF = 0;
    
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
            return RMS(n-1).add(rand.randomInput(),randomInt());
        }
    }
    //1
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
    //2 also does multiplicity
    public void cardRemoveP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bag = RMS(length);
            int bagCard = bag.cardinality();
            int newCard = bag.remove(elt).cardinality();
            if(bag.multiplicity(elt) > 0 && (newCard != bagCard-1)) {
                if(bag.multiplicity(elt)-1 != bag.remove(elt).multiplicity(elt)) {
                    System.out.println("cardRemoveF3: " + bag.sequence().toString() + " elt:" + elt + " now " + bag.remove(elt).sequence().toString() + " has: " + bag.remove(elt).multiplicity(elt));
                    cardRemoveF3++;
                }
                cardRemoveF1++;
            }
            else if(bag.multiplicity(elt) == 0 && bagCard != newCard) {
                cardRemoveF2++;
            }
        }
    }
    //3 does add and multiplicity
    public void memberAddP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bag = RMS(length);
            if(!bag.add(elt).member(elt)) {
                memberAddF++;
            }
            if(bag.add(elt).multiplicity(elt) != bag.multiplicity(elt) +1) {
                memberAddF++;
            }
        }
    }
    //4
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
    //5
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
    //6
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
    //7
    public void isEmptyP() {
        for(int i = 0; i < 1000; i++) {
            int length = randomInt();
            Multiset bag = RMS(length);
            if(randomInt() > 25) {
                if(bag.isBlackHuh()) {
                    isEmptyF1++;
                }
            }
            else {
                if(!MT.isEmpty()) {
                    isEmptyF2++;
                }
            }
        }
    }
    //8
    public void subsetUnionP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bagA = RMS(length);
            Multiset bagB = RMS(length);
            Multiset bagU = bagA.union(bagB);
            if(!bagA.subset(bagU) || !bagB.subset(bagU)) {
                subsetUnionF++;
            }
        }
    }
    //9
    public void subsetInterP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            int length = randomInt();
            Multiset bagA = RMS(length);
            Multiset bagB = RMS(length);
            Multiset bagI = bagA.inter(bagB);
            if(!bagI.subset(bagA) || !bagI.subset(bagB)) {
                subsetInterF++;
            }
        }
    }
    //10
    public void subsetEqualP() {
        for(int i = 0; i < 1000; i++) {
            D elt = rand.randomInput();
            Multiset bagA = RMS(3);
            Multiset bagB = RMS(3);
            if(bagA.subset(bagB) && bagB.subset(bagA) && !bagA.equal(bagB)) {
                subsetEqualF++;
            }
        }
    }
    //11
    public void cardSumItP() {
        for(int i = 0; i < 1000; i++) {
            int length = randomInt();
            Multiset bag = RMS(5);
            if(bag.sumIt() != bag.cardinality()) {
                System.out.println("bag: " + bag.sequence().toString() + " sumIt:" + bag.sumIt() + " card:" + bag.cardinality());
                cardSumItF++;
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
        System.out.println("cardRemoveF3 triggered " + cardRemoveF3 + " times");
        
        randomInt.memberDiffP();
        randomString.memberDiffP();
        System.out.println("memberAddF triggered " + memberAddF + " times");
        System.out.println("memberDiffF triggered " + memberDiffF + " times");
        
        randomInt.memberUnionP();
        randomString.memberUnionP();
        System.out.println("memberUnionF1 triggered " + memberUnionF1 + " times");
        System.out.println("memberUnionF2 triggered " + memberUnionF2 + " times");

        randomInt.memberInterP();
        randomString.memberInterP();
        System.out.println("memberInterF1 triggered " + memberInterF1 + " times");
        System.out.println("memberInterF2 triggered " + memberInterF2 + " times");

        randomInt.isEmptyP();
        randomString.isEmptyP();
        System.out.println("isEmptyF1 triggered " + isEmptyF1 + " times");
        System.out.println("isEmptyF2 triggered " + isEmptyF2 + " times");

        randomInt.subsetUnionP();
        randomString.subsetUnionP();
        System.out.println("subsetUnionF triggered " + subsetUnionF + " times");
        
        randomInt.subsetInterP();
        randomString.subsetInterP();
        System.out.println("subsetInterF triggered " + subsetInterF + " times");
        
        randomInt.subsetEqualP();
        randomString.subsetEqualP();
        System.out.println("subsetEqualF triggered " + subsetEqualF + " times");

        randomInt.cardSumItP();
        randomString.cardSumItP();
        System.out.println("cardSumItF triggered " + cardSumItF + " times");
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
//        Multiset branch = randomInt.RMS(20);
//        Multiset String = randomString.RMS(20);
        
//        System.out.println("BST card");
//        System.out.println(branch.cardinality());
//        System.out.println("Seq toString");
//        System.out.println(branch.sequence().toString());
//        System.out.println("Seq size");
//        System.out.println(branch.sumIt());
//        System.out.println(String.sequence().toString());

    }
}

