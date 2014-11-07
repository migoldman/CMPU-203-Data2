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
    
    /*
    INPUT: this
    OUTPUT: D
        @ Returns the first object in the Sequence
    
    EX:     [5,3,3,2] ==> 5
    */
    public D here();
    
    /*
    INPUT: this
    OUTPUT: boolean
        @ Returns if there the Sequence has more after here
    
    EX1:    [5, 2, 1] ==> true
    EX2:    [4] ==> false     
    */
    public boolean hasNext();
    
    /*
    INPUT: this
    OUTPUT: Sequence<D>
        @ Returns the a Sequence with all the objects after here
    
    EX:     ["apple", "pie", "is"] ==> ["pie", "is"]
    */
    public Sequence<D> next();
    
    /*
    INPUT: this
    OUTPUT: String
        @ Returns the elements of the Sequence in String form, including the multiplicty
    
    EX:     ["regular", "pie", "2", "2"] ==> "(regularX1) (pieX1) (2X2)"
    */
    public String toString();
    
}
