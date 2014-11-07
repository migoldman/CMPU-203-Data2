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
public class Branch<D extends Comparable> implements Multiset<D> {
    D data;
    int counter;
    Multiset left, right;
    boolean isBlack;
    
    Branch(D data, int counter) {
        this.data = data;
        this.counter = counter;
        this.left = new Leaf();
        this.right = new Leaf();
        this.isBlack = false;
    }
    
    Branch(D data, int counter, Multiset left, Multiset right) {
        this.data = data;
        this.counter = counter;
        this.left = left;
        this.right = right;
        this.isBlack = false;
    }

    Branch(D data, int counter, Multiset left, Multiset right, boolean isBlack) {
        this.data = data;
        this.counter = counter;
        this.left = left;
        this.right = right;
        this.isBlack = isBlack;
    }
    
    public int cardinality() {
        return this.counter + left.cardinality() + right.cardinality();
    }

    public boolean isEmpty() {
        return false;
    }

    public int multiplicity(D elt) {
        if(data.compareTo(elt) == 0) {
            return counter;
        }
        else if(data.compareTo(elt) < 0) {
            return left.multiplicity(elt);
        }
        else {
            return right.multiplicity(elt);
        }
    }

        
    public Multiset add(D elt) {
        return this.add(elt,1);
    }
    
    public Multiset add(D elt, int n) {
        if(data.compareTo(elt) == 0) {
            return new Branch(data, counter + n, left, right, this.isBlack);
        }
        else if(data.compareTo(elt) < 0) {
            return new Branch(data, counter, this.left.add(elt, n), right, this.isBlack).format();
        }
        else {
            return new Branch(data, counter, left, right.add(elt, n), this.isBlack).format();
        }
    }

    public Multiset remove(D elt) {
        return this.remove(elt, 1);
    }
    
    public Multiset remove(D elt, int n) {
        int max = Math.max(0, this.counter-n);
        if(elt.compareTo(data) == 0) {
            if(max == 0) {
                return left.union(right);
            }
            else {
                return new Branch(data, max, this.left, this.right).format();
            }
        } else if (elt.compareTo(data) < 0) {
            return new Branch(data, this.counter, this.left.remove(elt, n), this.right);
        } else {
            return new Branch(data, this.counter, this.left, this.right.remove(elt, n));
        }
    }
    
    public boolean member(D elt) {
        if (data.compareTo(elt) == 0) {
            return true;
        } else if (data.compareTo(elt) < 0) {
            return left.member(elt);
        }
        else {
            return right.member(elt);
        }
    }

    public Multiset union(Multiset u) {
        return left.union(right.union(u)).add(data, this.multiplicity(data));
    }

    public Multiset inter(Multiset u) {
        if(u.member(data)) {
            if(u.multiplicity(data) > this.multiplicity(data)) {
                return new Branch(this.data, this.multiplicity(data), 
                        this.left.inter(u), this.right.inter(u));
            }
            else {
                return new Branch(this.data, u.multiplicity(data), 
                        this.left.inter(u), this.right.inter(u));
            }
        }
        else {
            return this.left.inter(u).union(this.right.inter(u));
        }
    }
    
    public Multiset diff(Multiset u) {
        return left.union(right).diff(u.remove(data, this.multiplicity(data)));
    }

    public boolean equal(Multiset u) {
        return this.subset(u) && u.subset(this);
    }
    
    public boolean subset(Multiset u) {
        return (u.multiplicity(data) >= this.multiplicity(data)) 
                && this.left.subset(u) 
                && this.right.subset(u);
    } 
    
    public Sequence<D> sequence() {
        return new BranchSeq(data, counter, (new AppendSeq(left.sequence(),right.sequence())));
    }
    
    public int sumIt() {
        return sumIts(this.sequence());
    }
    
    public int sumIts(Sequence<D> temp) {
        int sum = 0;
        while(temp.hasNext()) {
            sum = sum+1;
            temp = temp.next();
        }
        return sum;
    }

    public Multiset blacken() {
        return new Branch(this.data, this.counter, this.left, this.right, true);
    }
    
    public boolean isBlackHuh() {
        return this.isBlack;
    }
    
    public Multiset insert(D elt, int n) {
        return this.insertIn(elt, n).blacken();
    }
    
    public Multiset insertIn(D elt, int n) {
        if(elt.compareTo(this.data) == 0) {
            return new Branch(this.data, this.counter + n, this.left, this.right, this.isBlack);
        }
        else if(elt.compareTo(this.data) < 0) {
            return new Branch(this.data, this.counter, left.insert(elt, n), this.right, this.isBlack).format();
        }
        else {
            return new Branch(this.data, this.counter, left, this.right.insert(elt, n), this.isBlack).format();
        }
        
    }
    
    public Multiset format() {
        Branch L;
        Branch LL;
        Branch LR;
        Branch R;
        Branch RL;
        Branch RR;
        
        //CASE 1
        if((this.isBlackHuh()
                && (this.left instanceof Branch)
                && (((Branch) this.left).left instanceof Branch)
                && !((Branch) this.left).isBlackHuh()
                && !((Branch) this.left).left.isBlackHuh())) {
            
            //////////////////

            L = ((Branch) this.left);
            LL = ((Branch) L.left);
            
            //////////////////

            return new Branch(
                    L.data,
                    L.counter,
                    new Branch(LL.data, LL.counter, LL.left, LL.right, true),
                    new Branch(this.data, this.counter, LL.right, this.right, true),
                    false);
        }   
        
        
        //CASE 2
        else if((this.isBlackHuh() 
                && (this.left instanceof Branch)
                && (((Branch) this.left).left instanceof Branch)
                && !((Branch) this.left).isBlackHuh()
                && !((Branch) this.left).left.isBlackHuh())) {
            
            //////////////////

            L = ((Branch) this.left);
            LL = ((Branch) L.left);
            LR = ((Branch) L.right);
            
            //////////////////

            return new Branch(
                //Data
                LR.data, 
                //Counter
                LR.counter, 
                //Left
                new Branch(L.data, L.counter, LL, LR, true),
                //Right
                new Branch(this.data, this.counter, LR.right, this.right, true),
                //isBlack
                false);
        }
        
        
        //CASE 3
        else if ((this.isBlackHuh()
                && (this.right instanceof Branch)
                && (((Branch) this.right).left instanceof Branch)
                && !((Branch) this.right).isBlackHuh()
                && !((Branch) this.right).left.isBlackHuh())) {
            
            //////////////////

            R = ((Branch) this.right);
            RL = ((Branch) R.left);
            
            //////////////////

            return new Branch(
                    //Data
                    RL.data,
                    //Counter
                    RL.counter,
                    //Left
                    new Branch(this.data, this.counter, RL.left, this.right, true),
                    //Right
                    new Branch(R.data, R.counter, RL.right, R.right, true),
                    false);
        }
        
        //CASE 4
        else if((this.isBlackHuh()
                && (this.right instanceof Branch)
                && (((Branch) this.right).right instanceof Branch)
                && !((Branch) this.right).isBlackHuh()
                && !((Branch) this.right).right.isBlackHuh())) {
            
            //////////////////
            
            R = ((Branch) this.right);
            RR = ((Branch) R.right);
            RL = ((Branch) R.left);
            
            //////////////////
            
            return new Branch(
                    R.data,
                    R.counter,
                    new Branch(this.data, this.counter, this.left, RL, true),
                    new Branch(RR.data, RR.counter, RR.left, RR.right,true),
            false);
        }
        else {
            return this;       
        }
    }
    
}
