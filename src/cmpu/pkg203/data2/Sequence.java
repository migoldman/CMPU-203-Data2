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
public interface Sequence<D extends Comparable> {
    
    public D here();
    public boolean hasNext();
    public Sequence<D> next();
    
}
