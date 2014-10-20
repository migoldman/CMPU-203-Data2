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
public interface Multiset<T extends Comparable> extends Iterable<T>{
    int cardinality();
    boolean isEmpty();
    int multiplicity(T data);
    Multiset add(T data);
    Multiset remove(T data);
    Multiset union(T u);
    Multiset inter(T u);
    Multiset diff(T u);
    boolean equal(Multiset u);
    boolean subset(Multiset u);
    
}
