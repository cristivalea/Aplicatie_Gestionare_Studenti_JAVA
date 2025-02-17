import model.Data;
import model.Disciplina;
import model.Nota;
import model.Student;

import java.util.Optional;
import java.util.Scanner;

public class NotaNumerica extends Nota {
    private int notaExamen;
    private int notalaborator;
    private int notaProiect;
    private int notaSeminar;
    private int notaFinala;

    public NotaNumerica(int codDisciplina, String codStudent, int notaE, int notaL, int notaP, int notaS, Data data){
        super(codStudent, codDisciplina, data);
        this.notaExamen = notaE;
        this.notalaborator = notaL;
        this.notaProiect = notaP;
        this.notaSeminar = notaS;
    }

    public NotaNumerica(Disciplina disciplina, Student student, int notaE, int notaL, int notaP, int notaS, Data data){
        super(student, disciplina, data);
        this.notaExamen = notaE;
        this.notalaborator = notaL;
        this.notaProiect = notaP;
        this.notaSeminar = notaS;
    }

    public NotaNumerica(String linie){
        Scanner scanner = new Scanner(linie);
    }

    public boolean isPromovat(){
        if(this.notaExamen < 5 || this.notalaborator < 5 || this.notaProiect < 5 || this.notaSeminar < 5){
            this.promovat = false;
            return false;
        }
        this.notaFinala = (int)(this.notaExamen * this.disciplina.getCoefExamne() + this.notalaborator * this.disciplina.getCoefLab() + this.notaProiect * this.disciplina.getCoefProiect() + this.notaSeminar * this.disciplina.getCoefSeminar());
        if(this.notaFinala > 5){
            this.promovat = true;
            return true;
        }
        return false;
    } // end function isPromovat

    public Optional getNotaFinala(){
        Optional<Integer> obj = Optional.of(this.notaFinala);
        return obj;
    } // end Optional

}
