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

//I will fix this later. This is for self balancing (will probably swap to Red Black)
public interface Fake<D extends Comparable> {
    Fake step1(D data, int n);
    Fake fake2(D data, int n, Multiset left, Multiset right);
    
}
