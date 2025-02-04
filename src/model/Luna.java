package model;

import java.util.Arrays;

public enum Luna{
    IANUARIE("IANUARIE",(short)1,31),
    FEBRUARIE("FEBRUARIE",(short)2,28,29),
    MARTIE("MARTIE",(short)3,31),
    APRILIE("APRILIE",(short)4,30),
    MAI("MAI",(short)5,31),
    IUNIE("IUNIE",(short)6,30),
    IULIE("IULIE",(short)7,31),
    AUGUST("AUGUST",(short)8,31),
    SEPTEMBRIE("SEPTEMBRIE",(short)9,30),
    OCTOMBRIE("OCTOMBRIE",(short)10,31),
    NOIEMBRIE("NOIEMBRIE",(short)11,30),
    DECEMBRIE("DECEMBRIE",(short)12,31);

    private String nume;
    private short nrOrdine;
    private int[] nrZile = new int[2];

    private Luna(String nume, short nrOrd, int ...nrZile){
        this.nume = nume;
        this.nrOrdine = nrOrd;
        this.nrZile = Arrays.copyOf(nrZile,2);
    }

    public static Luna getLuna(int index){
        for(Luna l : Luna.values()){ // Scoate o lista cu tote valorile enumeratiei
            if(index == l.nrOrdine){
                return l;
            }
        }
        return null;
    }

    public String getNume() {
        return nume;
    }

    public short getNrOrdine() {
        return nrOrdine;
    }

    public int[] getNrZile() {
        return nrZile;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setNrOrdine(short nrOrdine) {
        this.nrOrdine = nrOrdine;
    }

    public void setNrZile(int[] nrZile) {
        this.nrZile = nrZile;
    }
}
