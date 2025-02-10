package model;

import java.util.Optional;

public class NotaAR extends Nota{
    public final static String ADMIS = "ADMIS";
    public final static String RESPINS = "RESPINS";

    protected boolean valoare = true;



    public boolean isPromovat(){
        return false;
    }

    public Optional getNotaFinala(){
        return null;
    }
}
