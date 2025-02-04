package exceptii;

import java.util.HashMap;
import java.util.Map;
public class ZiNeadecvata extends Exception{
    public final static int NEGATIV = 1;
    public final static int NULA = 2;
    public final static int GREATER_THAN_31 = 3;
    public final static int GREATER_THAN_30 = 4;
    public static final int GREATER_THAN_29 = 5;
    public static final int GREATER_THAN_28 = 6;
    private int cod;
    private int zi;

    Map<Integer,String> map = new HashMap<Integer, String>();

    // bloc de initializare = se ruleaza inaite de rularea constructorului
    {
        map.put(NEGATIV, "Ziua are valoare negativa");
        map.put(NULA, "Ziua are valoare nula");
        map.put(GREATER_THAN_28,"Ziua are valoare mai mare decat 28");
        map.put(GREATER_THAN_29, "Ziua are valoare mai mare decat 29");
        map.put(GREATER_THAN_30, "Ziua are valoare mai mare decat 30");
        map.put(GREATER_THAN_31, "Ziua are valoare mai mare decat 31");
    }
    public ZiNeadecvata(int c, int z){
        this.cod = c;
        this.zi = z;
    }

    public String getMessage(){
        return map.get(this.cod);
    }

    public boolean hasErrorCode(int cod){
        return map.containsKey(cod);
    }

}