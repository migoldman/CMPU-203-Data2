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
        return new Branch(data, 1, new Leaf(), new Leaf());
    }
    
    public Multiset add(Comparable data, int n) {
        return new Branch(data, n, new Leaf(), new Leaf());
    }

    
    public Multiset remove(Comparable data) {
        return this;
    }

    
    public Multiset union(Multiset u) {
        return u;
    }

    
    public Multiset inter(Multiset u) {
        return this;
    }

    
    public Multiset diff(Multiset u) {
        return u;
    }

    
    public boolean equal(Multiset u) {
        return false;
    }

    
    public boolean subset(Multiset u) {
        return true;
    }

    
    public Iterator iterator() {
        return this.iterator();
    }
    
}
