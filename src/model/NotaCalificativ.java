package model;

import exceptii.CalificativInexistent;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class NotaCalificativ extends Nota{
    public final static String EXCELENT = "EXCELENT";
    public final static String FOARTE_BINE = "FOARTE BINE";
    public final static String BINE = "BINE";
    public final static String SUFICIENT = "SUFICIENT";
    public final static String INSUFICIENT = "INSUFICIENT";
    public final static ArrayList<String> calificative = new ArrayList<String>();

    {
        calificative.add(EXCELENT);
        calificative.add(FOARTE_BINE);
        calificative.add(BINE);
        calificative.add(SUFICIENT);
        calificative.add(INSUFICIENT);
    }

    public String valoarea = "SUFICIENT";
    private String calificativ = "";

    /**
     *
     * @param linie
     * @throws Exception
     */
    public NotaCalificativ(String linie) throws Exception{
        //C;CTI022105;100;FOARTE BINE;26/6/2024
        super();
//        if(!RegularExpresion.RegularExpresionLinieNotaCalificativ(linie)){
//            FormatInadecvatLinieNotaCalificativ inadecvat = new FormatInadecvatLinieNotaCalificativ(linie, "[C]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
//            throw inadecvat;
//        }
        Scanner scanner = new Scanner(linie);
        scanner.useDelimiter(";");
        scanner.next();
        String str_cod_student = scanner.next().trim();
        int cod_disciplina = scanner.nextInt();
        String calificativ = scanner.next().trim();
        String data = scanner.next().trim();
        scanner.close();

        if(!calificative.contains(calificativ)){
            CalificativInexistent inexistent = new CalificativInexistent(calificativ);
            throw inexistent;
        }
       if(!RegularExpresion.RegularExpresionData(data)){
           DataFormatException dataex = new DataFormatException(data);
           throw dataex;
       }
       Data d= new Data(data);
       this.codStudent = str_cod_student;
       this.codDisciplina = cod_disciplina;
       this.dataExamen = d;
       this.calificativ = calificativ;
       this.valoarea = calificativ;
       this.promovat = isPromovat();
    }

    /**
     *
     * @param registrationCode
     * @param codDisciplina
     * @param dataExamne
     * @param calificativ
     */
    public NotaCalificativ(String registrationCode, int codDisciplina, Data dataExamne, String calificativ) throws Exception{
        super(registrationCode, codDisciplina, dataExamne);
        this.codStudent = registrationCode;
        this.codDisciplina = codDisciplina;
        this.dataExamen = dataExamne;
        this.calificativ = calificativ;
        this.valoarea = calificativ;
    }

    /**
     *
     * @return
     */
    public boolean isPromovat(){
        return this.valoarea.equals(SUFICIENT) || this.valoarea.equals(BINE) || this.valoarea.equals(FOARTE_BINE) || this.valoarea.equals(EXCELENT);
    }

    /**
     *
     * @return
     */
    public Optional getNotaFinala(){
        Optional<String> obj = Optional.of(this.valoarea);
        return obj;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "Nota Calificativ ["
                + (valoarea != null ? "valoare= " + valoarea + ", ":"")
                + (codStudent != null ? "cod student= " + codStudent + ",": "")
                + "cod disciplina= " + codDisciplina + ", "
                + (dataExamen != null ? "data examen= " + dataExamen + ",": "")
                + (this.getNotaFinala() != null ? "nota finala= " + this.getNotaFinala().get() + ",":"")
                + "promovat= " + promovat
                +"]";
    }

    public void setNotaFinala(){
        this.valoarea = calificativ;
    }
}
