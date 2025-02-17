package model;

import exceptii.CalificativInexistent;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class NotaAR extends Nota{
    public final static String ADMIS = "ADMIS";
    public final static String RESPINS = "RESPINS";
    public final static ArrayList<String> noteAR = new ArrayList<String>();

    {
        noteAR.add(ADMIS);
        noteAR.add(RESPINS);
    }
    protected String valoare = "RESPINS";

    //C;CTI022105;100;FOARTE BINE;26/6/2024
    public NotaAR(String linie) throws Exception{
        super();
//        if(!RegularExpresion.RegularExpresionLinieNotaCalificativ(linie)){
//            FormatInadecvatLinieNotaCalificativ inadecvat = new FormatInadecvatLinieNotaCalificativ(linie, "[A]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
//            throw inadecvat;
//        }
        Scanner scanner =  new Scanner(linie);
        scanner.useDelimiter(";");
        scanner.next();
        String codStudent = scanner.next().trim();
        int cod_Disciplina = scanner.nextInt();
        String calificativ = scanner.next().trim();
        String data = scanner.next().trim();
        scanner.close();
        if(!noteAR.contains(calificativ)){
            CalificativInexistent inexistent = new CalificativInexistent(calificativ);
            throw inexistent;
        }
        if(!RegularExpresion.RegularExpresionData(data)){
            DataFormatException dataex = new DataFormatException(data);
            throw dataex;
        }
        Data d= new Data(data);
        this.codStudent = codStudent;
        this.codDisciplina = cod_Disciplina;
        this.dataExamen = d;
        this.valoare = calificativ;
        this.promovat = isPromovat();
    }

    public NotaAR(String codStudent, int codDisciplina, Data dataExamne, String calificativ) {
        super(codStudent, codDisciplina, dataExamne);
        this.codStudent = codStudent;
        this.codDisciplina = codDisciplina;
        this.dataExamen = dataExamne;
        this.valoare = calificativ;
    }

    public boolean isPromovat(){
        return (this.valoare.equals(ADMIS));
    }

    public Optional getNotaFinala(){
        Optional<String> obj = Optional.of(this.valoare);
        return obj;
    }

    public String toString(){
        return "Nota Admis/Respins ["
                + (valoare != null ? "valoare= " + this.valoare +",":"")
                + (codStudent != null ? "codu studentului= " + this.codStudent + ",":"")
                + (codDisciplina != 0 ? "codul disciplinei= " + this.codDisciplina + ",":"")
                + (dataExamen != null ? "data examen= " + this.dataExamen + ",":"")
                + "promovat= " + this.promovat + " "
                + (this.getNotaFinala() != null ? "nota finala= " + this.getNotaFinala().get() + ",":"")
                + " ]";
    }
}
