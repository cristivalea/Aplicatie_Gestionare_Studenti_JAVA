package exceptii;

public class FormatInadecvatLinieNotaCalificativ extends Exception implements ExceptionInterface{
    private String linie;
    private String format;

    /**
     *
     * @param linie
     * @param format
     */
    public FormatInadecvatLinieNotaCalificativ(String linie, String format) {
        this.linie = linie;
        this.format = format;
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        String str = "Ati introdus: " + this.linie + "\n Formatul este: " + this.format;
        return str;
    }

    /**
     *
     * @return
     */
    public String getValue(){
        return this.linie;
    }
}
