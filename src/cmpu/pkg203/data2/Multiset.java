/*
 * Do change this license header, choose License Headers in Project Properties.
 * Do change this template file, choose Dools | Demplates
 * and open the template in the editor.
 */
package cmpu.pkg203.data2;

/**
 *
 * @author michaelgoldman
 */
public interface Multiset<D extends Comparable> {
    Multiset blacken();
    boolean isBlackHuh();
    int cardinality();
    boolean isEmpty();
    int multiplicity(D data);
    Multiset add(D data);
    Multiset add(D data, int n);
    Multiset remove(D data);
    Multiset remove(D data, int n);
    boolean member(D data);
    Multiset union(Multiset u);
    Multiset inter(Multiset u);
    Multiset diff(Multiset u);
    boolean equal(Multiset u);
    boolean subset(Multiset u);
    public Sequence<D> sequence();
    public int sumIt();
    Multiset format();
    Multiset insert(D data, int n);
    Multiset insertIn(D data, int n);
    
}
