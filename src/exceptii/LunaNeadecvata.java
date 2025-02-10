package exceptii;

public class LunaNeadecvata extends Exception{
    private int luna;

    public LunaNeadecvata(int l){
        this.luna = l;
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        return (this.luna < 1 || this.luna > 12) ? "Valoarea pentru luna nu este corecta. Valoarea lunii trebuie sa fie intre 1 si 12" : " ";
    }
}
