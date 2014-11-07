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
public class BranchSeq<D extends Comparable> implements Sequence {
    D here;
    int count;
    Sequence<D> next;
    
    public BranchSeq(D here, int count, Sequence<D> next) {
        this.here = here;
        if ( count <= 0 ) {
            throw new RuntimeException("Should never create a BranchSeq of count 0: " + here);
        }
        this.count = count;
        this.next = next;
    }

    public D here() {
        return here;
    }

    public boolean hasNext() {
        return true;
    }

    public Sequence next() {
        if(count > 1) {
            return new BranchSeq(here, (count - 1), next);
        } else {
            return next;
        }
    }

    public String toString() {
        return "(" + this.here + "x" + this.count + ") " + this.next;
    }
}
