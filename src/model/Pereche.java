package model;

import java.util.Objects;

public class Pereche<A, B>{
    private A a;
    private B b;

    public Pereche(A a, B b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pereche{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pereche<?, ?> pereche = (Pereche<?, ?>) o;
        return Objects.equals(a, pereche.a) && Objects.equals(b, pereche.b);
    }

}
