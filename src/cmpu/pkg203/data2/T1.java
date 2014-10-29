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
public class T1 implements Multiset {
    Multiset child;

    public T1(Multiset N) {
        this.child = child;
    }

    
    public int cardinality() {
        return child.cardinality();
    }

    public boolean isEmpty() {
        return child.isEmpty();
    }

    public int multiplicity(Comparable data) {
        return child.multiplicity(data);
    }

    public Multiset add(Comparable data) {
        fakeL fakeL;
        fake3 fake3;
        if(this.child instanceof Branch) {
            
        }
        else {
            
        }
    }

    public Multiset add(Comparable data, int n) {
        fakeL fakeL;
        fake3 fake3;
        if(this.child instanceof Branch) {
            
        }
        else {
            
        }
    }

    public Multiset remove(Comparable data) {
        return child.remove(data);
    }

    public Multiset union(Comparable u) {
        return child.union(u);
    }

    public Multiset inter(Comparable u) {
        return child.union(u);
    }

    public Multiset diff(Comparable u) {
        return child.diff(u);
    }

    public boolean equal(Multiset u) {
        return child.equal(u);
    }

    public boolean subset(Multiset u) {
        return child.subset(u);
    }
    
    public Iterator iterator() {
    }
    
    private class fakeL {
        Comparable data;
        int counter;

        public fakeL(Comparable data, int counter) {
            this.data = data;
            this.counter = counter;
        }
    }
    
    private class fake3 {
        Comparable data;
        int counter;
        Multiset left, right;
        
        public fake3(Comparable data, int counter, Multiset left, Multiset right) {
            this.data = data;
            this.counter = counter;
            this.left = left;
            this.right = right;
        }
    }
    
}

