/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpu.pkg203.data2;

import java.util.Iterator;

/**
 *
 * @author michaelgoldman
 */
public class Leaf implements Multiset {

    
    public int cardinality() {
        return 0;
        //Leafs have no cardinaltiy
    }

    
    public boolean isEmpty() {
        return true;
        //Nothing is in a Leaf
    }

    
    public int multiplicity(Comparable data) {
        return 0;
        //There are no multiplies of any data
    }

    
    public Multiset add(Comparable data) {
        return new Branch(data, 0, new Leaf(), new Leaf());
    }

    
    public Multiset remove(Comparable data) {
    }

    
    public Multiset union(Comparable u) {
    }

    
    public Multiset inter(Comparable u) {
    }

    
    public Multiset diff(Comparable u) {
    }

    
    public boolean equal(Comparable u) {
    }

    
    public boolean subset(Comparable u) {
    }

    
    public Iterator iterator() {
    }
    
}
