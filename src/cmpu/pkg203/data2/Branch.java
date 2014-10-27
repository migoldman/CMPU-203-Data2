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
public class Branch implements Multiset {
    Comparable data;
    int counter;
    Multiset left;
    Multiset right;

    Branch(Comparable data, int counter, Multiset left, Multiset right) {
        this.data = data;
        this.counter = counter;
        this.left = left;
        this.right = right;
    }

    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    public boolean isEmpty() {
        return false;
    }

    public int multiplicity(Comparable elt) {
        if(data.compareTo(elt) == 0) {
            return counter;
        }
        else if(data.compareTo(elt) == -1) {
            return left.multiplicity(elt);
        }
        else {
            return right.multiplicity(elt);
        }
    }

        
    public Multiset add(Comparable elt) {
        if(data.compareTo(elt) == 0) {
            return new Branch(data, counter+1, left, right);
        }
        else if(data.compareTo(elt) == -1) {
            return new Branch(data, counter, left.add(data), right);
        }
        else {
            return new Branch(data, counter, left, right.add(elt));
        }
    }
    
    public Multiset add(Comparable elt, int n) {
        if(data.compareTo(elt) == 0) {
            return new Branch(data, counter + n, left, right);
        }
        else if(data.compareTo(elt) == -1) {
            return new Branch(data, counter, this.left.add(elt, n), right);
        }
        else {
            return new Branch(data, counter, left, right.add(elt, n));
        }
    }

    public Multiset remove(Comparable data) {
    }

    public Multiset union(Comparable u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Multiset inter(Comparable u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Multiset diff(Comparable u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean equal(Multiset u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean subset(Multiset u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Multiset 

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
