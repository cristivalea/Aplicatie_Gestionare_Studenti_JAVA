package exceptii;

import java.util.Map;
import java.util.HashMap;

public class FormatException extends Exception{
    private String str;
    private int cod;

    public static final int DATA_FORMAT = 1;
    public static final int NR_MATRICOL_FORMAT = 2;
    public static final int NUME_PRENUME_FORMAT = 3;
    public static final int STUDENT_LINIE_FORMAT = 4;
    public static final int FORMAT_LINIE_NOTA_CALIFICATIV = 5;
    public static final int FORMAT_LINIE_AR = 6;
    public static final int FORMAT_LINIE_NOTA_NUMERICA = 7;


    Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(DATA_FORMAT, "[123]?\\d\\/[1]?\\d\\/\\d{4}");
        map.put(NR_MATRICOL_FORMAT, "CTI\\d{3}[1-9]\\d{2}");
        map.put(NUME_PRENUME_FORMAT, "^[A-ZĂÂÎȘȚ][a-zăâîșț]*$");
        map.put(STUDENT_LINIE_FORMAT, "CTI\\d{3}[1-9]\\d{2}\\;[A-Z]\\w*\\;([A-Z]\\w*\\s?)+\\;[123]?\\d\\/[1]?\\d\\/\\d{4}\\;[123]?\\d\\/[1]?\\d\\/\\d{4}");
        map.put(FORMAT_LINIE_NOTA_CALIFICATIV, "[C]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
        map.put(FORMAT_LINIE_AR, "[A]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
        map.put(FORMAT_LINIE_NOTA_NUMERICA, "[N]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2}\\;([1-9][0]?\\;){4}([0](\\,\\d)\\;?){4}[1-3]?\\d\\/[1-9]?[1-2]?\\/\\d{4}");
    }

    /**
     *
     * @param s
     * @param c
     */
    public FormatException(String s, int c){
        this.str = s;
        this.cod = c;
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        return map.get(this.cod);
    }
}
