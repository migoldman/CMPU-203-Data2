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
public class Branch<D extends Comparable> implements Multiset<D> {
    D data;
    int counter;
    Multiset left, right;
    boolean isBlack;
    
    Branch(D data, int counter, Multiset left, Multiset right) {
        this.data = data;
        this.counter = counter;
        this.left = left;
        this.right = right;
        isBlack = false;
    }

    Branch(D data, int counter, Multiset left, Multiset right, boolean isBlack) {
        this.data = data;
        this.counter = counter;
        this.left = left;
        this.right = right;
        this.isBlack = isBlack;
    }
    
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    public boolean isEmpty() {
        return false;
    }
    
    public Multiset blacken() {
        return new Branch(this.data, this.counter, this.left, this.right, true);
    }
    
    public boolean isBlackHuh() {
        return this.isBlack;
    }

    public int multiplicity(D elt) {
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

        
    public Multiset add(D elt) {
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
    
    public Multiset add(D elt, int n) {
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

    public Multiset remove(D elt) {
        if(data.compareTo(elt) == 0) {
            this.counter = counter - 1;
            if(this.counter <= 0) {
                return left.union(right);
            }
            else {
                return new Branch(data, counter - 1, left, right);
            }
        }
        else if(data.compareTo(elt) == -1) {
            return new Branch(data, counter, left.remove(elt), right);
        }
        else {
            return new Branch(data, counter, left, right.remove(elt));
        }
    }
    
    public Multiset remove(D elt, int n) {
        if(data.compareTo(elt) == 0) {
            this.counter = counter - n;
            if(this.counter <= 0) {
                return left.union(right);
            }
            else {
                return new Branch(data, counter - n, left, right);
            }
        }
        else if(data.compareTo(elt) == -1) {
            return new Branch(data, counter, left.remove(elt), right);
        }
        else {
            return new Branch(data, counter, left, right.remove(elt));
        }
    }
    
    public boolean member(D elt) {
        if (data.compareTo(elt) == 0) {
            return true;
        } else if (data.compareTo(elt) == -1) {
            return left.member(elt);
        }
        else {
            return right.member(elt);
        }
    }

    public Multiset union(Multiset u) {
        return left.union(right.union(u)).add(data, counter);
    }

    public Multiset inter(Multiset u) {
        if (u.member(data)) {
            return new Branch(data, counter, left.inter(u), right.inter(u));
        } 
        return left.inter(u).union(right.inter(u));
    }
    
    public Multiset diff(Multiset u) {
        if(u.member(data)) {
            return left.union(right).diff(u.remove(data, counter));
        }
        return left.union(right).diff(u);
    }

    public boolean equal(Multiset u) {
        return this.subset(u) && u.subset(this);
    }
    
    public boolean subset(Multiset u) {
        if(!u.member(data)) {
            return false;
        } else {
            return left.union(right).subset(u);
        }
    } 
 
    public Multiset format() {
        //How do you get it so you can see the child of the child?
        return null;
    }
    
}
