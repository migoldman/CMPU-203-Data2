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
public class Leaf<D extends Comparable> implements Multiset<D> {

    
    public int cardinality() {
        return 0;
        //Leafs have no cardinaltiy
    }

    
    public boolean isEmpty() {
        return true;
        //Nothing is in a Leaf
    }

    
    public int multiplicity(D data) {
        return 0;
        //There are no multiplies of any data
    }

    
    public Multiset add(D data) {
        return new Branch(data, 1, new Leaf(), new Leaf());
    }
    
    public Multiset add(D data, int n) {
        return new Branch(data, n, new Leaf(), new Leaf());
    }

    
    public Multiset remove(D data) {
        return this;
    }
    
    public Multiset remove(D data, int n) {
        return this;
    }

    public boolean member(D data) {
        return false;
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
    
}
