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
    
    
}
