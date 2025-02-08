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

    public String getMessage(){
        return "Calificativul nu exista" + this.calificativ;
    }

    public String getValue(){
        return this.calificativ;
    }
}
