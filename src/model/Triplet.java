package model;

public class Triplet <A, B, C>{
    private A a;
    private B b;
    private C c;

    public Triplet(A a, B b, C c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString(){
        return this.a + " " + this.b + " " + this.c;
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Triplet<?,?,?>){
            Triplet<A, B, C> t = (Triplet<A, B, C>)obj;
            if(this.a == t.a && this.b == t.b && this.c == t.c){
                return true;
            }
        }
        return false;
    }
}
