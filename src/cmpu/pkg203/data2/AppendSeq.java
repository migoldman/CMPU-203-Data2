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
public class AppendSeq<D extends Comparable> implements Sequence {
    Sequence<D> left;
    Sequence<D> right;
    
    public AppendSeq(Sequence<D> left, Sequence<D> right) {
        this.left = left;
        this.right = right;
    }
    
    public D here() {
        if(this.left.hasNext()) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }

    public boolean hasNext() {
        return this.left.hasNext() || this.right.hasNext();
    }

    public Sequence<D> next() {
        if(this.left.hasNext()) {
            return new AppendSeq(this.left.next(), this.right);
        }
        else {
            return this.right.next();
        }
    }
    
    public String toString() {
        return this.left.toString() + " " + this.right.toString();
    }
}
