package exceptii;

import java.util.Map;
import java.util.HashMap;

public class StudentNeadecvat extends Exception{
    public static int UNICITATE = 1;
    public static int VARSTA_ADECVATA = 2;
    public static int DATA_INMATRICULARE_ADECVATA = 3;
    public static int DATA_NASTERE_INADECVATA = 4;

    private int cod;
    private String stud;

    Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(UNICITATE,"Numarul matricol nu este unic");
        map.put(VARSTA_ADECVATA, "Varsta este sub 18 ani");
        map.put(DATA_INMATRICULARE_ADECVATA, "model.Data inmatricularii este inainte de 1924");
        map.put(DATA_NASTERE_INADECVATA,"model.Data basterii nu poate fi mai mica decat data inmatricularii");
    }

    /**
     *
     * @param c
     * @param s
     */
    public StudentNeadecvat(int c, String s){
        this.cod = c;
        this.stud = s;
    }

    /**
     *
     * @return
     */
    public String getMessage(){

        return map.get(this.cod);
    }

    /**
     *
     * @param cod
     * @return
     */
    public boolean hasErrorCode(int cod){

        return map.containsKey(cod);
    }

}
