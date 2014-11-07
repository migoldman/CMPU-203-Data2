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
    
    /*
    INPUT: this
    OUTPUT:  int
        @ Returns the number of nodes that are in the Multiset
    EX:     {3, 3, 2, 1} ==> 4
    */
    int cardinality();  
    
    /*
    INPUT: this
    OUTPUT: boolean
        @ Returns if the Multiset is empty (or is a Leaf)
    EX1:    {} ==> true
    EX2:    {this, is, not, empty} ==> false
    */
    boolean isEmpty(); 
    
    /*
    INPUT: D data
    OUTPUT: int
        @ Returns the number of nodes that contain data as their input 
            @if data is not in the Multiset, multiplicity() returns 0
    
    EX1:    data = 3
                {3,2,2} ==> 2
    EX2:    data = 4
                {44, 4, 4, 4} ==> 3
    EX3:
            data = 5
                {4} ==> 0
    */
    int multiplicity(D data);   
    
    /*
    INPUT: D data
    OUTPUT: Multiset
        @ Returns a new Multiset with data added into the Multiset 1 time
   
    EX1:    data = "abc"
                {a, b, c} ==> {a, abc, b, c}
    EX2:    data = 2
                {9, 5, 2, 2} ==> {9, 5, 2, 2, 2}
    */
    Multiset add(D data);  
    
    /*
    INPUT: D data
    OUTPUT: Multiset
        @ Returns a new Multiset with data added into the Multiset n times
    
    EX:     data = 3 && n = 3
                {5, 2} ==> {5, 3, 3, 3, 2}
    */
    Multiset add(D data, int n);     
    
    /*
    INPUT: D data
    OUTPUT:  Multiset
        @ Returns a new Multiset with data removed from the Multiset 1 time
    
    EX1:    data = 5
                {5, 5, 2} ==> {5, 2}
    EX2:    data = 4
                {4, 2, 1} ==> {2, 1}
    EX3:    data = 2
                {99} ==> {99}
    
    */
    Multiset remove(D data);  
    
    /*
    INPUT: D data
    OUTPUT: Multiset
        @ Returns a new Multiset with data removed from the Multiset n times
    
    EX1:    data = b && n = 9999
                {b, b, c} ==> {c}
    */
    Multiset remove(D data, int n);   
    
    /*
    INPUT: D data
    OUTPUT: boolean
        @ Returns if a node contains an instance of input data
    
    EX1:    data = "foo"
                {"abc", "foo"} ==> true
    EX2:    data = "bar"
                {"foo", "thiscodeisgreat"} ==> false
    */
    boolean member(D data);  
    
    /*
    INPUT: Multiset u
    OUTPUT: Multiset
        @ Returns the union of Multiset this and Multiset u
    
    EX:     this = {"yes"} && u == {"no"}
                ==>    {"no, yes"}
    */
    Multiset union(Multiset u);  
    
    /*
    INPUT: Multiset u
    OUTPUT: Multiset
        @ Returns the intersection between Multiset this and Multiset u
    
    EX:     this = {5, 4, 3} && u = {3, 2, 1}
                ==> {3}
    */
    Multiset inter(Multiset u);
    
    /*
    INPUT: Multiset u
    OUTPUT: Multiset
        @ Returns all the elements in Multiset u that are not in Multiset this
    
    EX:     this = {5, 4, 3} && u = {3, 2, 1}
                ==> {2, 1}
    */
    Multiset diff(Multiset u);  
    
    /*
    INPUT: Multiset u
    OUTPUT: boolean
        @ Returns if Multiset this and Multiset u are the same
    
    EX:     this = {"foo", "foo", "bar"} && u = {"foo", "foo", bar"}
                ==> true
    */
    boolean equal(Multiset u);     
    
    /*
    INPUT: Multiset u
    OUTPUT: boolean
        @ Returns if Multiset this is a subset of Multiset u
    
    EX1:    this = {5, 2} && u = {5, 4, 3, 2, 1}
                ==> true
    EX2:
            this = {2, 2} && u = {5, 2, 1, 1}
                ==> false
    */
    boolean subset(Multiset u);
    
    /*
    INPUT: Multiset u
    OUTPUT: Sequence<D>
        @ Returns a sequence that contains all the objects (type D) in Multiset this
    */
    public Sequence<D> sequence();
    
    /*
    INPUT: this
    OUTPUT: int
        @ Returns the number of elements in the sequence this
    */
    public int sumIt();
    
    /*
    INPUT: this
    OUTPUT: Multiset
        @ "I see a red node and I want it painted black" ~ The Rollin Bytes
        @ Converts a red node into a black node. Used in format()
    */
    Multiset blacken();
    
    /*
    INPUT: this
    OUTPUT: boolean
        @ Returns whether the node color is black
    EX:     this = red
                this ==> false
    */
    boolean isBlackHuh();
    
    /*
    INPUT: this
    OUTPUT: Multiset
        @ Returns the Multiset this in a more balanced form, lowering the total average height
    */
    Multiset format();
    
    /*
    INPUT: D data, int n
    OUTPUT: Multiset
        @ Adds a node with data type D  n times into the Multiset in a balanced fashion
    */
    Multiset insert(D data, int n);    
}
