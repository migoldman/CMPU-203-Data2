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
public interface Randomness<D extends Comparable> {
    
    /*
    INPUT: this
    OUTPUT: D
        @ Returns a random input of type D
    */
    public D randomInput();
}
