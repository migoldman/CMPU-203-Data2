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
public interface Fake<T extends Comparable> {
    Fake step1(T data, int n);
    Fake fake2(T data, int n, Multiset left, Multiset right);
    
}
