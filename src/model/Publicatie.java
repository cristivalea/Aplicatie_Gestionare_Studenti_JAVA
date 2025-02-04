package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Publicatie {
    private String autor;
    private String titluCarte;
    private String editura;
    private String orasAparitie;
    private int anAparitie;

    public Publicatie(String titlu, String edit, String oras, int an, String a){
        this.titluCarte = titlu;
        this.editura = edit;
        this.orasAparitie = oras;
        this.anAparitie = an;
        this.autor = a;
    }

    @Override
    public String toString() {
        return "Publicatie{" +
                "autor=" + autor +
                ", titluCarte='" + titluCarte + '\'' +
                ", editura='" + editura + '\'' +
                ", orasAparitie='" + orasAparitie + '\'' +
                ", anAparitie=" + anAparitie +
                '}';
    }
}
