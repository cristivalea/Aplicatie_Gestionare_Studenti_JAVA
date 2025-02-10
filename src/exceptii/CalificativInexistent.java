package exceptii;

public class CalificativInexistent extends Exception implements ExceptionInterface{
    private String calificativ;

    /**
     *
     * @param calificativ
     */
    public CalificativInexistent(String calificativ) {
        this.calificativ = calificativ;
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        return "Calificativul nu exista" + this.calificativ;
    }

    /**
     *
     * @return
     */
    public String getValue(){
        return this.calificativ;
    }
}
