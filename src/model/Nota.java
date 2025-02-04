package model;

import model.Data;
import model.Disciplina;
import teste.Main2;

import java.util.Scanner;

public class Nota {
    private Student student;
    private String codStudent;
    private Disciplina disciplina;
    private int codDisciplina;
    private short nota1;
    private short nota2;
    private Data dataExamen;
    private boolean promovat = false;
    private int notaFinala;

    public Nota(Student s, Disciplina d, short n1, short n2, Data dataEx){
        this.student = s;
        this.disciplina = d;
        this.nota1 = n1;
        this.nota2 = n2;
        this.promovat = this.isPromovat();
        this.dataExamen = dataEx;
        this.notaFinala = this.getNotaFinala();
    }

    public Nota(String linie) throws Exception{
        Scanner scanner = new Scanner(linie);
        scanner.useDelimiter(";");
        this.codStudent = scanner.next();
        this.codDisciplina = scanner.nextShort();
        this.nota1 = scanner.nextShort();
        this.nota2 = scanner.nextShort();
        this.dataExamen = new Data(scanner.next());
        scanner.close();
        Main2.logger.info("S-aincarcat nota: " + this.codStudent + ";" + this.codDisciplina + ";" + this.nota1 + ";" + this.nota2 + ";" + this.dataExamen);
    }

    public Student getStudent() {
        return student;
    }

    public String getCodStudent() {
        return codStudent;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public short getNota1() {
        return nota1;
    }

    public short getNota2() {
        return nota2;
    }

    public Data getDataExamen() {
        return dataExamen;
    }

    public int getNotaFinala() {
        return notaFinala;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDataExamen(Data dataExamen) {
        this.dataExamen = dataExamen;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setPromovat(boolean promovat) {
        this.promovat = promovat;
    }

    public boolean isPromovat(){
        if(this.disciplina.getCoefExamne() < 1 && this.disciplina.getCoefLab() < 1){
            boolean cond1 = this.nota1 >= 5;
            boolean cond2 = this.nota2 >= 5;
            return cond1 && cond2;
        }
        else if(this.disciplina.getCoefExamne() == 1){
            return this.nota1 > 5;
        }
        else if(this.disciplina.getCoefLab() == 1){
            return this.nota2 > 5;
        }
        return false;
    }

    @Override
    public String toString() {
        return "model.Nota{" +
                "student=" + student +
                ", codStudent='" + codStudent + '\'' +
                ", disciplina=" + disciplina +
                ", codDisciplina=" + codDisciplina +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", dataExamen=" + dataExamen +
                ", promovat=" + promovat +
                ", notaFinala=" + notaFinala +
                '}';
    }

    protected void setNotaFinala(){
        if(this.isPromovat()){
            double nf = 0;
            nf = this.disciplina.getCoefExamne() * this.nota1+this.disciplina.getCoefLab()*this.nota2;
            int nt = (int)nf;
            double dif = nf - nt;
            if(dif < 0.5){
                this.notaFinala = nt;
            }
            else{
                this.notaFinala = nt + 1;
            }
        }
    }
}
