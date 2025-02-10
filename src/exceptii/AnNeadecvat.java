package exceptii;

import java.time.LocalDate;
public class AnNeadecvat extends Exception{
    private int an;
    private static final int anInceput = 1924;

    public AnNeadecvat(int a){
        this.an = a;
    }

    /**
     *
     * @return
     */
    public static int extrageAn(){
        LocalDate dataCurenta = LocalDate.now();
        int anCurent = dataCurenta.getYear();
        return anCurent;
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        return ((this.an < anInceput) || (this.an > extrageAn())) ? "Anul are valoare gresita, anul trebuie sa fie intre 1924 si " + extrageAn() : " ";
    }
}
