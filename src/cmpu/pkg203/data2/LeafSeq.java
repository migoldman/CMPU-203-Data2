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
public class LeafSeq<D extends Comparable> implements Sequence {
    
    public D here() {
        throw new RuntimeException("Asked for here in LeafSeq");
    }
    
    public boolean hasNext() {
        return false;
    }
    
    public Sequence<D> next() {
        throw new RuntimeException("There is no \"next()\" in LeafSeq");
    }
    
    
    public String toString() {
        return "";
    }
}
